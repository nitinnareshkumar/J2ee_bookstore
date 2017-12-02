package com.bookStore.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondRequestTimeTakenFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("second filter before request" + new Date());
		chain.doFilter(request, response);
		System.out.println("second filter after request" + new Date());
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
