package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dao.EmailRepository;
import com.example.demo.model.Email;
import com.example.demo.model.Emails;
import com.example.demo.model.Employee;
import com.example.demo.model.Employees;
import com.example.demo.service.EmployeeServiceImpl;

@RestController
@RequestMapping(path = "/api")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl service;
	
	@Autowired
	EmailRepository emailService;
	
	@GetMapping(path = "/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee e = service.getEmployeeById(id);
		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}
	
	@GetMapping(path = "/employee/{id}/emails")
	public ResponseEntity<Emails> getEmployeeEmails(@PathVariable Long id, @RequestParam(name = "bro", defaultValue = "bro") String bro) {
		Employee e = service.getEmployeeById(id);
		List<Email> mails = e.getEmails();
		Emails emails = new Emails();
		emails.setEmails(mails);
		return new ResponseEntity<Emails>(emails, HttpStatus.OK);
	}
	
	@GetMapping(path = "/employees")
	public ResponseEntity<Employees> getAllEmployees() {

		Employees e = service.getAllEmployees();
		return new ResponseEntity<Employees>(e, HttpStatus.OK);
	}
	
	@PostMapping("/create/employee")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
		service.createEmployee(employee);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(employee.getId()).toUri();
	
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/create/email")
	public ResponseEntity<Object> createEmployee(
			@RequestParam(name = "employeeId") Long id, @RequestBody String email) {
		
		Employee employee = service.getEmployeeById(id);
		Email emailObj = new Email();
		emailObj.setEmail(email);
		emailObj.setUser(employee);
		emailService.save(emailObj);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(employee.getId()).toUri();
	
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/test")
	public ResponseEntity<String> test(@RequestBody Employee employee) {
		service.test(employee);;
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
	
	@PostMapping("/test2")
	public ResponseEntity<String> test2(@RequestBody Employee employee) {
		service.test2(employee);;
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.deleteEmployee(id);
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}

}
