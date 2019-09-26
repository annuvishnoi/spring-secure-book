package com.training.secure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	//mapping for custom login form
	@GetMapping("/mylogin")
	public String customLogin() {
		return "login-page";
	}
	
	//mapping for custom access denied page
	@GetMapping("/accessdenied")
	public String accessDenied() {
		return "access-denied";
	}
}
