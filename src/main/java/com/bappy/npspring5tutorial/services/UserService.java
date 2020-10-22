package com.bappy.npspring5tutorial.services;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;

import com.bappy.npspring5tutorial.dto.ForgotPasswordForm;
import com.bappy.npspring5tutorial.dto.ResetPasswordForm;
import com.bappy.npspring5tutorial.dto.SignupForm;

public interface UserService {
	
	public abstract void signup(SignupForm signupForm);
	
	public abstract void verify(String verificationCode);

	public abstract void forgotPassword(@Valid ForgotPasswordForm forgotPasswordForm);

	public abstract void resetPassword(String forgotPasswordCode, ResetPasswordForm resetPasswordForm, BindingResult result);

}
