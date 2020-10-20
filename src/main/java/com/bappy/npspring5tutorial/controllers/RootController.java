package com.bappy.npspring5tutorial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import com.bappy.npspring5tutorial.mail.MailSender;

@Controller
public class RootController {
	
	private MailSender mailSender;
	
	@Autowired
	public RootController(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
//	@RequestMapping("/")
//	public String home() throws MessagingException {
//		
//		// mailSender.send("bappy@gmail.com", "A test mail", "A body of my mail");
//		
//		return "home";
//	}
	

}
