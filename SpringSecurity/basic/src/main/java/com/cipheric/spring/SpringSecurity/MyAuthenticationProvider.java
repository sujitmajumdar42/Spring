package com.cipheric.spring.SpringSecurity;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String pass = authentication.getCredentials().toString();
		System.out.println("Request from USERNAME="+userName+" PASSWORD="+pass);
		
		// admin/pass - This combination will throw error by spring. 
		if ("admin".equals(userName) && "C1ph3r".equals(pass)) {
			return new UsernamePasswordAuthenticationToken(userName, pass, Arrays.asList());
		}
		else {
			throw new BadCredentialsException("Invalid Username or Password");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
