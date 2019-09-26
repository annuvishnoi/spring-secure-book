package com.training.secure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {

	//add mapping for /manager
	@GetMapping("/manager")
	public String managerHome() {
		return "manager-home";
	}
}
