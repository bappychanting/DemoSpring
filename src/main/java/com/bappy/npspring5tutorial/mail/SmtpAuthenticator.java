package com.bappy.npspring5tutorial.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SmtpAuthenticator extends Authenticator{
	
	private String username;
	private String password;
	
	/*
	 * public String getUsername() { return username; }
	 */
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	/*
	 * public String getPassword() { return password; }
	 */
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}

}
