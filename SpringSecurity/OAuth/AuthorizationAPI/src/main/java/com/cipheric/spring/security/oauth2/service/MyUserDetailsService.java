package com.cipheric.spring.security.oauth2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	private static final String ADMIN = "admin@gmail.com";
	private static final String USER = "user@gmail.com";
	private static final String PASS_ENCRYPTED = "$2a$10$i881.Q5.DCXhnl0rJ/T7selLNH.gKl6v2J.8zfXqWH9o5JRboNAaC";
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		
		if(ADMIN.equals(username)) {
			roles.clear();
			roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			return new User(ADMIN,PASS_ENCRYPTED,roles);
		} if(USER.equals(username)) {
			roles.clear();
			roles.add(new SimpleGrantedAuthority("ROLE_USER"));
			return new User(USER,PASS_ENCRYPTED,roles);
		} else {
			throw new UsernameNotFoundException(username+" not found");
		}
	}
	
}
