package com.manipal.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.model.MessageBean;

@RestController
@RequestMapping("/rest")
public class WelcomeController {
	
	@RequestMapping(value="welcome" , method = RequestMethod.GET)
	public String welcome() {		
		return "Welcome to Spring REST Application";
	}
	
	@RequestMapping(value="welcome/{name}")
	public String welcomeMessage(@PathVariable String name) {
		return "Welcome to Spring REST Application " + name;
	}
	
	
	@RequestMapping(value="wel-message")
	public MessageBean welcomeMessage() {		
		return new MessageBean("Welcome to Messaging...");
	}
	
	
	
	
	
	
	
	
	
	
}

// http://localhost:8090/rest/welcome
