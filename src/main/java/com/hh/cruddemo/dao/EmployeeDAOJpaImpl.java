package com.hh.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.hh.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeDAO {

	private EntityManager entityManager;

	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		return;
	}

	@Override
	public Employee findById(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Employee thEmployee) {
		Employee dbEmployee = entityManager.merge(thEmployee);
		thEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int employeeId) {
		// TODO Auto-generated method stub

	}

}
