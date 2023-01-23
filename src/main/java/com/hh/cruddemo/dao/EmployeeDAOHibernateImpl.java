package com.hh.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hh.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {

//		get the current hibernate session
		Session session = entityManager.unwrap(Session.class);

//		create the query
		Query<Employee> theQuery = session.createQuery("from Employee", Employee.class);

//		execute query and get result list
		List<Employee> employees = theQuery.getResultList();

//		return the results
		return employees;
	}

	@Override
	public Employee findById(int employeeId) {
//		get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
//		get the employee
		Employee employee = session.get(Employee.class, employeeId);
//		return the employee
		return employee;
	}

	@Override
	public void save(Employee thEmployee) {
//		get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
//		save or update the employee
		session.saveOrUpdate(thEmployee);
	}

	@Override
	public void deleteById(int employeeId) {
//		get the current hibernate session
		Session session = entityManager.unwrap(Session.class);

//		save or update the employee
		Query query = session.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", employeeId);

		query.executeUpdate();
	}

}
