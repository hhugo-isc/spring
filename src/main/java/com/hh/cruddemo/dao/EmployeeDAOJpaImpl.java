package com.hh.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
		// create a query
		Query query = entityManager.createQuery("from Employee");

		// execute query and get result list
		List<Employee> employees = query.getResultList();

		// return the result
		return employees;
	}

	@Override
	public Employee findById(int employeeId) {
//		get the employee
		Employee employee = entityManager.find(Employee.class, employeeId);
//		return the employee
		return employee;
	}

	@Override
	public void save(Employee thEmployee) {
//		save or update the employee
		Employee dbEmployee = entityManager.merge(thEmployee);
//		update with id from db... so we can get generated id for save/persist
		thEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int employeeId) {
//		create query for deleting
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", employeeId);
		query.executeUpdate();
	}

}
