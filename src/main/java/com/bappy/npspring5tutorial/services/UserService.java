package com.bappy.npspring5tutorial.services;

import javax.validation.Valid;

import com.bappy.npspring5tutorial.dto.ForgotPasswordForm;
import com.bappy.npspring5tutorial.dto.SignupForm;

public interface UserService {
	
	public abstract void signup(SignupForm signupForm);
	
	public abstract void verify(String verificationCode);

	public abstract void forgotPassword(@Valid ForgotPasswordForm forgotPasswordForm);

}
