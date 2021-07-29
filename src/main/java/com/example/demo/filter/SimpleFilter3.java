package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
//@WebFilter(urlPatterns = "/prod", filterName = "SimpleFilter3") -- not working

public class SimpleFilter3 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filter 3");
//		System.out.println("Remote Host: "+request.getRemoteHost());
//		System.out.println("Remote address: "+request.getRemoteAddr());
		chain.doFilter(request, response);
		System.out.println("Filter 3: request processing completed");
		
	}

}
