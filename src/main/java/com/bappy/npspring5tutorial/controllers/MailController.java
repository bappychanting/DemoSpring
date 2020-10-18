package com.bappy.npspring5tutorial.controllers;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bappy.npspring5tutorial.mail.MailSender;

@RestController
public class MailController {
	
	private MailSender mailSender;

	public MailController(MailSender smtp) {
		this.mailSender = smtp;
	}
	
	/*
	 * public MailSender getMailSender() { return mailSender; }
	 * 
	 * public void setMailSender(MailSender mailSender) { this.mailSender =
	 * mailSender; }
	 */

	@RequestMapping("/mail")
	public String mail() throws MessagingException{
		
		mailSender.send("bappy@gmail.com", "A test mail", "A body of my mail");
		
		return "mail sent!";
	}
}
