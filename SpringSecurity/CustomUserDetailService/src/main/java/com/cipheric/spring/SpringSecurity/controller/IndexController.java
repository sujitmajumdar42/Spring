package com.cipheric.spring.SpringSecurity.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping(path = "/f5Monitor")
	public String monitor() {
		return "Hello Admin!!!";
	}
	
	public static void main(String[] args) {
		BCryptPasswordEncoder en = new BCryptPasswordEncoder();
		System.out.println(en.encode("Sujit2021"));
	}
}
