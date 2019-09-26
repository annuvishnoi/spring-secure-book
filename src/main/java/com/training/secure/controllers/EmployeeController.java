package com.training.secure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
	
	//mapping method for root
	@GetMapping("/")
	public String home() {
		return "home";
	}
}
