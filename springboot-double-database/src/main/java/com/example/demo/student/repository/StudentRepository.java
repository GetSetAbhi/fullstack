package com.example.demo.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.student.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}