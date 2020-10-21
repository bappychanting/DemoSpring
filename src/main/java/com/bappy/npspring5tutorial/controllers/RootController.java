package com.bappy.npspring5tutorial.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import javax.validation.Valid;

import com.bappy.npspring5tutorial.NpSpring5TutorialApplication;
import com.bappy.npspring5tutorial.dto.SignupForm;
import com.bappy.npspring5tutorial.mail.MailSender;
import com.bappy.npspring5tutorial.services.UserService;
import com.bappy.npspring5tutorial.util.MyUtil;
import com.bappy.npspring5tutorial.validators.SignupFormValidator;

@Controller
public class RootController {
	
	private MailSender mailSender;
	private UserService userService;
	private SignupFormValidator signupFormValidator;
	
	private static final Logger logger = LoggerFactory.getLogger(RootController.class);
	
	@Autowired
	public RootController(MailSender mailSender, UserService userService, SignupFormValidator signupFormValidator) {
		this.mailSender = mailSender;
		this.userService = userService;
		this.signupFormValidator = signupFormValidator;
	}
	
	@InitBinder("signupForm")
	protected void initSignupBinder(WebDataBinder binder) {
		binder.setValidator(signupFormValidator);
	}
	
//	@RequestMapping("/")
//	public String home() throws MessagingException {
//		
//		// mailSender.send("bappy@gmail.com", "A test mail", "A body of my mail");
//		
//		return "home";
//	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		
		model.addAttribute("signupForm", new SignupForm());
		
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute("signupForm") @Valid SignupForm signupForm,
			BindingResult result, RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors())
			return "signup";
		
		userService.signup(signupForm);
		
		MyUtil.flash(redirectAttributes, "success", "signupSuccess");
		
		return "redirect:/";
		
	}
	

}
