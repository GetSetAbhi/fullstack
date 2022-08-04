package com.example.demo.teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.teacher.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}