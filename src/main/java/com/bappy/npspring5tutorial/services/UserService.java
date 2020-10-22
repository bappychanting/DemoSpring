package com.bappy.npspring5tutorial.services;

import com.bappy.npspring5tutorial.dto.SignupForm;

public interface UserService {
	
	public abstract void signup(SignupForm signupForm);
	
	public abstract void verify(String verificationCode);

}
