package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.Employees;

public interface EmployeeService {
	public Employee getEmployeeById(Long id);

	public Employees getAllEmployees();

	public void createEmployee(Employee employee);

	public Employee updateEmployee(Long id, Employee updatedEmp);

	public void deleteEmployee(Long id);
}
