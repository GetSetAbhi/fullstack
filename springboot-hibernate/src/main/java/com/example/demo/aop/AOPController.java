package com.example.demo.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/aop")
public class AOPController {
	
	@Autowired
	private AOPService aopService;

	@GetMapping(path = "/before")
	public ResponseEntity<String> beforeAdvice() {
		aopService.beforeTest();
		return new ResponseEntity<String>("Before", HttpStatus.OK);
	}
	
	@GetMapping(path = "/after")
	public ResponseEntity<String> afterAdvice() {
		aopService.afterTest();
		return new ResponseEntity<String>("After", HttpStatus.OK);
	}
	
	@GetMapping(path = "/afterreturn")
	public ResponseEntity<String> afterReturnAdvice() {
		String output = aopService.afterReturning();
		return new ResponseEntity<String>(output, HttpStatus.OK);
	}
	
	@GetMapping(path = "/afterthrow")
	public ResponseEntity<String> afterThrowingAdvice() {
		aopService.afterThrowing();
		return new ResponseEntity<String>("Error", HttpStatus.OK);
	}
	
	@GetMapping(path = "/around")
	public ResponseEntity<String> aroundAdvice() {
		aopService.aroundTest();
		return new ResponseEntity<String>("Around", HttpStatus.OK);
	}
	
	@GetMapping(path = "/aroundreturn")
	public ResponseEntity<String> aroundReturnAdvice() {
		String output = aopService.aroundTestWithReturnValue();
		return new ResponseEntity<String>(output, HttpStatus.OK);
	}
	
	@GetMapping(path = "/aroundparam")
	public ResponseEntity<String> aroundParamAdvice() {
		aopService.aroundTestWithParams(10, 20);
		return new ResponseEntity<String>("Param", HttpStatus.OK);
	}
}
