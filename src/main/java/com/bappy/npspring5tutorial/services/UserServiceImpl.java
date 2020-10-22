package com.bappy.npspring5tutorial.services;

import javax.mail.MessagingException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.validation.BindingResult;
import org.springframework.transaction.annotation.Propagation;

import com.bappy.npspring5tutorial.controllers.RootController;
import com.bappy.npspring5tutorial.dto.ForgotPasswordForm;
import com.bappy.npspring5tutorial.dto.ResetPasswordForm;
import com.bappy.npspring5tutorial.dto.SignupForm;
import com.bappy.npspring5tutorial.dto.UserDetailsImpl;
import com.bappy.npspring5tutorial.entities.User;
import com.bappy.npspring5tutorial.entities.User.Role;
import com.bappy.npspring5tutorial.mail.MailSender;
import com.bappy.npspring5tutorial.repositories.UserRepository;
import com.bappy.npspring5tutorial.util.MyUtil;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class UserServiceImpl implements UserService, UserDetailsService {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private MailSender mailSender;

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, MailSender mailSender) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.mailSender = mailSender;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void signup(SignupForm signupForm) {
		final User user = new User();
		user.setEmail(signupForm.getEmail());
		user.setName(signupForm.getName());
		user.setPassword(passwordEncoder.encode(signupForm.getPassword()));
		user.getRoles().add(Role.UNVERIFIED);
		user.setVerificationCode(RandomStringUtils.randomAlphanumeric(16));
		userRepository.save(user);
		// For transaction error
		// int j = 20/0;
		
		TransactionSynchronizationManager.registerSynchronization(
				new TransactionSynchronizationAdapter() {
					@Override
					public void afterCommit() {
						try {
							String verifyLink = MyUtil.hostUrl() + "/users/" + user.getVerificationCode() + "/verify";
							mailSender.send(user.getEmail(), MyUtil.getMessage("verifySubject"), MyUtil.getMessage("verifyEmail", verifyLink));
							logger.info("Verification mail to " + user.getEmail() + " queued.");
						} catch (MessagingException e) {
							logger.error(ExceptionUtils.getStackTrace(e));
						}
					}
				}
				
		);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) 
		throws UsernameNotFoundException{
		User user = userRepository.findByEmail(username);
		if(user == null)
			throw new UsernameNotFoundException(username);
		
		return new UserDetailsImpl(user);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void verify(String verificationCode) {
		long loggedInUserId = MyUtil.getSessionUser().getId();
		User user = userRepository.getOne(loggedInUserId);
		
		MyUtil.validate(user.getRoles().contains(Role.UNVERIFIED), "alreadyVerified");
		MyUtil.validate(user.getVerificationCode().equals(verificationCode), 
				"incorrect", "verification code");
		
		user.getRoles().remove(Role.UNVERIFIED);
		user.setVerificationCode(null);
		userRepository.save(user);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void forgotPassword(ForgotPasswordForm form) {
		final User user = userRepository.findByEmail(form.getEmail());
		final String forgotPasswordCode = RandomStringUtils.randomAlphanumeric(User.RANDOM_CODE_LENGTH);
				
		user.setForgotPasswordCode(forgotPasswordCode);
		final User savedUser = userRepository.save(user);
		
		TransactionSynchronizationManager.registerSynchronization(
				new TransactionSynchronizationAdapter() {
					@Override
					public void afterCommit() {
						try {
							mailForgotPasswordLink(savedUser);
						} catch (MessagingException e) {
							logger.error(ExceptionUtils.getStackTrace(e));
						}
					}
				}
				
		);
	}

	private void mailForgotPasswordLink(User user) throws MessagingException{
		String forgotPasswordLink = MyUtil.hostUrl() + "/reset-password/" + user.getForgotPasswordCode();
		mailSender.send(user.getEmail(), 
				MyUtil.getMessage("forgotPasswordSubject"), 
				MyUtil.getMessage("forgotPasswordEmail", forgotPasswordLink));
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void resetPassword(String forgotPasswordCode, ResetPasswordForm resetPasswordForm, BindingResult result) {
		User user = userRepository.findByForgotPasswordCode(forgotPasswordCode);
		
		if(user == null)
			result.reject("invalidForgotPassword");
		
		if(result.hasErrors())
			return;
		
		user.setForgotPasswordCode(null);
		user.setPassword(passwordEncoder.encode(resetPasswordForm.getPassword().trim()));
		userRepository.save(user);
	}
	
	@Override
	public User findOne(long userId) {
		User loggedIn = MyUtil.getSessionUser();
		
		User user = userRepository.findById(userId).orElse(null);
		
		if(loggedIn == null ||
			loggedIn.getId() != user.getId() && !loggedIn.isAdmin())
			
			user.setEmail("Confidential"); 
		
		return user;
	}
	
}
