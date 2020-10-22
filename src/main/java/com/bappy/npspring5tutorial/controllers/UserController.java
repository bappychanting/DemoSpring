package com.bappy.npspring5tutorial.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bappy.npspring5tutorial.dto.ResetPasswordForm;
import com.bappy.npspring5tutorial.dto.UserEditForm;
import com.bappy.npspring5tutorial.entities.User;
import com.bappy.npspring5tutorial.services.UserService;
import com.bappy.npspring5tutorial.util.MyUtil;

@Controller
@RequestMapping("/users/")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	@RequestMapping("/{verificationCode}/verify")
	public String verify(@PathVariable("verificationCode") String verificationCode, 
			RedirectAttributes redirectAttributes, HttpServletRequest request) throws ServletException{
		userService.verify(verificationCode);
		
		MyUtil.flash(redirectAttributes, "success", "verificationSuccess");
		
		request.logout();
		
		return "redirect:/";
		
	}
	
	@RequestMapping("/{userId}")
	public String getById(@PathVariable("userId") long userId, Model model){
		
		model.addAttribute(userService.findOne(userId));
		
		return "user";
		
	}
	
	@RequestMapping("/{userId}/edit")
	public String edit(@PathVariable("userId") long userId, Model model){
		
		User user = userService.findOne(userId);
		UserEditForm form = new UserEditForm();
		form.setName(user.getName());
		form.setRoles(user.getRoles());
		model.addAttribute(form);
		
		return "user-edit";
		
	}
	
	@RequestMapping(value = "/{userId}/edit", method = RequestMethod.POST)
	public String edit(@PathVariable("userId") long userId, 
			@ModelAttribute("userEditForm") @Valid UserEditForm userEditForm,
			BindingResult result, RedirectAttributes redirectAttributes, HttpServletRequest request) throws ServletException{
		
		if(result.hasErrors())
			return "user-edit";
		
		userService.update(userId, userEditForm);
		
		MyUtil.flash(redirectAttributes, "success", "editSuccess");
		request.logout();
		
		return "redirect:/";
		
	}
	
	
}
