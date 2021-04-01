package com.example.demo.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * In order to used this annotation we need the
 * @ServletComponentScan annotation with the @SPringBootApplication
 * annotation
 * 
 * **/
@WebFilter(urlPatterns = "/example/filter", dispatcherTypes = {DispatcherType.REQUEST})
public class ExampleFIlter extends HttpFilter {
	
	private static final long serialVersionUID = 1813954015101399857L;

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("#####INside the filter");
		super.doFilter(request, response, chain);
		System.out.println("#####After the filter");
	}
}
