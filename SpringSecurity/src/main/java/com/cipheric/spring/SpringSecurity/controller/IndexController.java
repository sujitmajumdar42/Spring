package com.cipheric.spring.SpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	@RequestMapping(method=RequestMethod.GET, path="/hello", produces="application/JSON")
	public String greet() {
		return "Hello";
	}
	
	@GetMapping(path="/bye")
	public String bye() {
		return "Thank you";
	}
}
