package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beansannodemo.DemoService;
import com.example.demo.exceptions.ExampleException;
import com.example.demo.model.Property;

@RestController
@RequestMapping(path = "/example")
public class ExampleController {
	
	@Autowired
	//@Qualifier("primaryDemoService")
	DemoService demoService;
	/**
	 * 
	 * This will demo exception
	 * **/
	@GetMapping(path = "/exception")
	public ResponseEntity<String> exceptionDemo() {
		throw new ExampleException("You can not pass");
	}
	
	/**
	 * 
	 * This will demo interceptor in llogs
	 * **/
	@GetMapping(path = "/interceptor")
	public ResponseEntity<String> interceptorDemo() {
		System.out.println("#########Im inside controller");
		return new ResponseEntity<String>("Yay !!", HttpStatus.OK);
	}
	
	/**
	 * 
	 * This will return a value from .property file
	 * **/
	
	@Value("${spring.application.name}")
	private String configvalue;
	@GetMapping(path = "/configvalue")
	public ResponseEntity<String> configValueDemo() {
		System.out.println("#########Im inside controller");
		return new ResponseEntity<String>(configvalue, HttpStatus.OK);
	}
	
	/**
	 * 
	 * This will return a value from properties file
	 * **/
	@Autowired
	private Property property;
	@GetMapping(path = "/configvaluelist")
	public ResponseEntity<List<String>> listConfigValueDemo() {
		List<String> list = new ArrayList<>();
		list.add(property.getFirstName());
		list.add(property.getLastName());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	/**
	 * 
	 * This will show filters in logs
	 * **/
	@GetMapping(path = "/filter")
	public ResponseEntity<String> filtertest() {
		return new ResponseEntity<>("Yaya", HttpStatus.OK);
	}
	
	/**
	 * 
	 * This will show filters in logs
	 * **/
	@GetMapping(path = "/qualifiers")
	public ResponseEntity<String> hello() {
		demoService.hello();
		return new ResponseEntity<>("Yaya", HttpStatus.OK);
	}

}
