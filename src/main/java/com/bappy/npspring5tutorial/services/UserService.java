package com.bappy.npspring5tutorial.services;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;

import com.bappy.npspring5tutorial.dto.ForgotPasswordForm;
import com.bappy.npspring5tutorial.dto.ResetPasswordForm;
import com.bappy.npspring5tutorial.dto.SignupForm;
import com.bappy.npspring5tutorial.dto.UserEditForm;
import com.bappy.npspring5tutorial.entities.User;

public interface UserService {
	
	public abstract void signup(SignupForm signupForm);
	
	public abstract void verify(String verificationCode);

	public abstract void forgotPassword(@Valid ForgotPasswordForm forgotPasswordForm);

	public abstract void resetPassword(String forgotPasswordCode, ResetPasswordForm resetPasswordForm, BindingResult result);

	public abstract User findOne(long userId);

	public abstract void update(long userId, UserEditForm userEditForm);

}
