package com.hh.webcustomertracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);

//		execute query and get result list
		List<Customer> customers = query.getResultList();

//		return the result
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
//		get current hibernate session
		Session session = sessionFactory.getCurrentSession();
//		save the customer ... finally	
		session.saveOrUpdate(customer);

	}

	@Override
	public Customer getCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, customerId);

	}

	@Override
	public void deleteCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", customerId);
		query.executeUpdate();
	}

}
