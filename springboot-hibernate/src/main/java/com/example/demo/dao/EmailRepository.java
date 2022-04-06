package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Email;

@Service
public interface EmailRepository extends JpaRepository<Email, Long> {

}
