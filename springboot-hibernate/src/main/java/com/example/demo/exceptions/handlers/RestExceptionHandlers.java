package com.example.demo.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exceptions.ExampleException;

@RestControllerAdvice
public class RestExceptionHandlers {

	@ExceptionHandler
	public ResponseEntity<String> exampleExceptionHandler(ExampleException exampleException) {
		return new ResponseEntity<String>(exampleException.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
	}
}
