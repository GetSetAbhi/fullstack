package com.example.demo.teacher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.teacher.model.Teacher;
import com.example.demo.teacher.repository.TeacherRepository;

@RestController
@RequestMapping(path = "/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Teacher>> getAllTeachers() {
		return new ResponseEntity<>(teacherRepository.findAll(), HttpStatus.OK);
	}

}
