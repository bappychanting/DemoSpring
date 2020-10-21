package com.bappy.npspring5tutorial.validators;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.bappy.npspring5tutorial.dto.SignupForm;
import com.bappy.npspring5tutorial.entities.User;
import com.bappy.npspring5tutorial.repositories.UserRepository;

@Component
public class SignupFormValidator extends LocalValidatorFactoryBean {

	private UserRepository userRepository;
	
	@Resource
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(SignupForm.class);
	}
	
	@Override
	public void validate(Object obj, Errors errors) {
		
		super.validate(obj, errors);
		
		if(!errors.hasErrors()) {
			SignupForm signupForm = (SignupForm) obj;
			User user = userRepository.findByEmail(signupForm.getEmail());
			if(user != null)
				errors.rejectValue("email", "emailNotUnique");
		}
	}
	
}
