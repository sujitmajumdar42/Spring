package com.cipheric.spring.security.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

@SpringBootApplication
public class Oauth2Application {

	 
	public static void main(String[] args) {
		SpringApplication.run(Oauth2Application.class, args);
	}

}
