package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Employees;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public Employee getEmployeeById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.select(employeeRoot);
		criteria.where(builder.equal(employeeRoot.get("id"), id));
		Employee e = session.createQuery(criteria).getSingleResult();
		return e;
	}

	@Override
	public Employees getAllEmployees() {
		Session session = entityManager.unwrap(Session.class);
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.select(employeeRoot);
		List<Employee> employeeList = session.createQuery(criteria).getResultList();
		Employees e = new Employees();
		e.setEmployees(employeeList);
		return e;
	}

	@Override
	public void createEmployee(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
	}

	@Override
	public Employee updateEmployee(Long id, Employee updatedEmp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
