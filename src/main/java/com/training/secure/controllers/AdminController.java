package com.training.secure.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	//mapping for /admin
	@GetMapping("/admin")
	public String adminHome() {
		
		return "admin-home";
	}
	public static void main(String[] args) {
		String encoded=new BCryptPasswordEncoder().encode("123456");
		System.out.println(encoded);
	}
}
