package com.cipheric.spring.security.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	@GetMapping(path = "/adminpage")
	public String adminPage() {
		return "Welcome Admin";
	}
}
