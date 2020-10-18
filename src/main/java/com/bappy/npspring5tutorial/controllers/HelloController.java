package com.bappy.npspring5tutorial.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private String appname;
	
	@RequestMapping("/hello")
	public String hello() {
		
		return "Hello, world";
	}
	
}
