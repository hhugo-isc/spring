package com.hh.webcustomertracker.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hh.webcustomertracker.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

//		get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

//		create a query
		Query<Customer> query = session.createQuery("from Customer", Customer.class);

//		execute query and get result list
		List<Customer> customers = query.getResultList();

//		return the result
		return customers;
	}

}
