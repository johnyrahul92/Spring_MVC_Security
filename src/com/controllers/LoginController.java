package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	

	@RequestMapping(value = "/jlogin", method = RequestMethod.GET)
	public String loginpAge(ModelMap model) {
		model.addAttribute("Meaasge", "Login Page");
		
		return "jlogin";
		
	}

	
	@RequestMapping(value = "/loginFail", method = RequestMethod.GET)
	public String loginFailed(ModelMap model) {
		model.addAttribute("errMsg", "Login Credentials Wrong");
		
		return "jlogin";
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(ModelMap model) {
		model.addAttribute("logOutMsg", "Successfully Logged Out");
		
		return "logout";
		
	}
}
