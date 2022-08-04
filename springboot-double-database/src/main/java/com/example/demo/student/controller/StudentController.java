package com.example.demo.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.student.model.Student;
import com.example.demo.student.repository.StudentRepository;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Student>> getAllStudent() {
		return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
	}

}
