package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.Employees;
import com.example.demo.repository.EmployeeRepository;

@RestController
// This is to allow angular to access the app
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository repository;
	
	@GetMapping(path = "/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws ResourceNotFoundException {
		Optional<Employee> e = repository.findById(id);
		Employee employee = e.get();
		if (employee == null) {
			throw new ResourceNotFoundException("No Employee Found");
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@GetMapping(path = "/employees")
	public ResponseEntity<Employees> getAllEmployees() throws ResourceNotFoundException {
		List<Employee> employees = repository.findAll();
		if (CollectionUtils.isEmpty(employees)) {
			throw new ResourceNotFoundException("Records Empty");
		}
		return new ResponseEntity<Employees>(new Employees(employees), HttpStatus.OK);
	}
	
	@PostMapping("/create/employee")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
		//User savedUser = service.save(user);
		Employee savedUser = null;
		
		try {
			savedUser = repository.save(employee);
		} catch (Exception e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
		
		System.out.println(location.toString());
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(path = "/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmp) throws ResourceNotFoundException {
		Optional<Employee> e = repository.findById(id);
		Employee employee = e.get();
		if (employee == null) {
			throw new ResourceNotFoundException("No Employee Found");
		}
		employee.setName(updatedEmp.getName());
		employee.setDesignation(updatedEmp.getDesignation());
		try {
			updatedEmp = repository.save(employee);
		} catch (Exception ex) {
			throw new ResourceNotFoundException(ex.getMessage());
		}
		return new ResponseEntity<Employee>(updatedEmp, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/employee/{id}")
	public ResponseEntity<Employee> removeEmployee(@PathVariable Long id) throws ResourceNotFoundException {
		
		try {
			repository.deleteById(id);;
		} catch (Exception ex) {
			throw new ResourceNotFoundException(ex.getMessage());
		}
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}
	
}
