package com.example.demo.aop;

import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ExampleException;

@Service
public class AOPService {

	public void beforeTest() {
		System.out.println("Inside Before Test Method");
	}
	
	public void afterTest() {
		System.out.println("Inside After Test Method");
	}
	
	public String afterReturning() {
		System.out.println("Inside afterReturning Test Method");
		return "After Returning";
	}
	
	public void afterThrowing() {
		System.out.println("Inside afterThrowing Test Method");
		throw new ExampleException("example exception");
	}
	
	public void aroundTest() {
		System.out.println("Inside around Test Method");
	}
	
	public String aroundTestWithReturnValue() {
		System.out.println("Inside aroundTestWithReturnValue Test Method");
		return "Returning Value";
	}
	
	public void aroundTestWithParams(int a, int b) {
		System.out.println("Inside aroundTestWithParams Test Method with param values " + a + " " + b);
	}
	
	@TestAOPAnnotation
	public void beforeTestWithInterface(int a, int b) {
		System.out.println("Inside beforeTestWithannotation signature Test Method with param values " + a + " " + b);
	}
}
