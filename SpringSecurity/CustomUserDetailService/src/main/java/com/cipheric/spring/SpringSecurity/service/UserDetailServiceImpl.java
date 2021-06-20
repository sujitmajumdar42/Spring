package com.cipheric.spring.SpringSecurity.service;

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
public class UserDetailServiceImpl implements UserDetailsService {
	
	private static final String ADMIN_USERNAME = "admin@gmail";
	private static final String USER_USERNAME = "user@gmail";
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<GrantedAuthority> roles = new ArrayList();
		
		
		if(ADMIN_USERNAME.equals(username)) {
			roles.clear();
			roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			roles.add(new SimpleGrantedAuthority("ROLE_USER"));
			return new User(ADMIN_USERNAME, "$2a$10$cX6Ldjr9GxewTVvPr22qLOS.iP5Fb9H7TuvjoKKIbia54yMM7r6Oy", roles);
		} else if(USER_USERNAME.equals(username)) {
			roles.clear();
			roles.add(new SimpleGrantedAuthority("ROLE_USER"));
			return new User(USER_USERNAME, "$2a$10$cX6Ldjr9GxewTVvPr22qLOS.iP5Fb9H7TuvjoKKIbia54yMM7r6Oy", roles);
		} else {
			throw new UsernameNotFoundException("Userno not found "+username);
		}
	}

}
