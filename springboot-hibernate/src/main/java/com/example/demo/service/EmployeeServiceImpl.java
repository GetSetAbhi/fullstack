package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;
import com.example.demo.model.Employees;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	@Transactional
	@Override
	public Employee getEmployeeById(Long id) {
		return employeeDao.getEmployeeById(id);
	}

	@Transactional
	@Override
	public Employees getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployees();
	}

	@Transactional
	@Override
	public void createEmployee(Employee employee) {
		employeeDao.createEmployee(employee);
	}

	@Transactional
	@Override
	public Employee updateEmployee(Long id, Employee updatedEmp) {
		return employeeDao.updateEmployee(id, updatedEmp);
	}

	@Transactional
	@Override
	public void deleteEmployee(Long id) {
		employeeDao.deleteEmployee(id);
	}
	
	/**
	 * Exception will be thrown and no database commit will take place.
	 * 
	 * **/
	@Transactional
	public void test(Employee employee) {
		employeeDao.createEmployee(employee);
		throw new DataIntegrityViolationException("Throwing exception for demoing Rollback!!!");
	}
	
	/**
	 * Exception will be thrown but database commit will still take place.
	 * 
	 * **/
	@Transactional(noRollbackFor = { DataIntegrityViolationException.class })
	public void test2(Employee employee) {
		employeeDao.createEmployee(employee);
		throw new DataIntegrityViolationException("Throwing exception for demoing Rollback!!!");
	}

	public EmployeeDAO getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}

}
