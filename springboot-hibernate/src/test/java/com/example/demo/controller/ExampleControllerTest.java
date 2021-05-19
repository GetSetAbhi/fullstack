package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.beansannodemo.DemoService;

@SpringBootTest
public class ExampleControllerTest {
	
	@Mock
	DemoService service;
	
	@InjectMocks
	ExampleController controller;
	
	@Test
	public void testHello() {
		doNothing().when(service).hello();
		ResponseEntity<String> response = controller.hello();
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody(), "Yaya");
	}

}
