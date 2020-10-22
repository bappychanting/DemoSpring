package com.bappy.npspring5tutorial.validators;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.bappy.npspring5tutorial.dto.ResetPasswordForm;
import com.bappy.npspring5tutorial.repositories.UserRepository;

@Component
public class ResetPasswordValidator  extends LocalValidatorFactoryBean{
	
	private UserRepository userRepository;
	
	@Resource
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(ResetPasswordForm.class);
	}
	
	@Override
	public void validate(Object obj, Errors errors) {
		
		super.validate(obj, errors);
		
		if(!errors.hasErrors()) {
			ResetPasswordForm resetPasswordForm = (ResetPasswordForm) obj;
			if(!resetPasswordForm.getPassword().equals(resetPasswordForm.getRetypePassword()))
				errors.reject("passwordsDontMatch");
		}
	}

}
