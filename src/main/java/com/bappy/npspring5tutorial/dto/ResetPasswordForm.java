package com.bappy.npspring5tutorial.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bappy.npspring5tutorial.entities.User;

public class ResetPasswordForm {
	
	
	@NotNull
	@Size(min=6, max=User.PASSWORD_MAX, message="{passwordSizeError}")
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

	@NotNull
	@Size(min=6, max=User.PASSWORD_MAX, message="{passwordSizeError}")
	private String retypePassword;

}
