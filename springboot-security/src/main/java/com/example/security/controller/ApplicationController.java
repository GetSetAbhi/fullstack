package com.example.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.model.User;

@RestController
@RequestMapping(path = "/api")
public class ApplicationController {
	/**
	 * Add basic authentication in postman
	 * add username and password as given in .properties
	 * 
	 * **/
	@GetMapping(path = "/user")
	public ResponseEntity<User> getUser() {
		User user = new User("Abhishek", "Raina");
		ResponseEntity<User> r = new ResponseEntity<User>(user, HttpStatus.OK);
		return r;
	}
	
	/**
	 * Add basic authentication in postman
	 * add username and password as given in .properties
	 * 
	 * **/
	@GetMapping(path = "/auth/user")
	public ResponseEntity<User> getAuthenticatedUser() {
		User user = new User("Abhishek", "Authenticated");
		ResponseEntity<User> r = new ResponseEntity<User>(user, HttpStatus.OK);
		return r;
	}
	
	/**
	 * Add basic authentication in postman
	 * add username and password as given in .properties
	 * 
	 * **/
	@GetMapping(path = "/auth/manager")
	public ResponseEntity<User> getAuthenticatedManager() {
		User user = new User("Abhishek", "Manager");
		ResponseEntity<User> r = new ResponseEntity<User>(user, HttpStatus.OK);
		return r;
	}

}
