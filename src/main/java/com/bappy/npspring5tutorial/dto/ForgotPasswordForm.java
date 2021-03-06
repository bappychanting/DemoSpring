package com.bappy.npspring5tutorial.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.bappy.npspring5tutorial.entities.User;
import com.sun.istack.NotNull;

public class ForgotPasswordForm {

	@NotNull
	@Size(min=1, max=User.EMAIL_MAX, message="{emailSizeError}")
	@Pattern(regexp=User.EMAIL_PATTERN, message="{emailPatternError}")
	private String email;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
