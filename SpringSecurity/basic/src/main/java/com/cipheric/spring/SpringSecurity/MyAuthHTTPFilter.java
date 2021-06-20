package com.cipheric.spring.SpringSecurity;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyAuthHTTPFilter extends HttpFilter{
	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response,
            FilterChain chain) throws IOException, ServletException {
		System.out.println("Request received at MyAuthHTTPFilter URI="+request.getRequestURI());
		chain.doFilter(request, response);
		System.out.println("Chain filter completed from HTTP Filter.");
    }
}
