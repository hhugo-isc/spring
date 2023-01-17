package com.hh.webcustomertracker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hh.webcustomertracker.dao.CustomerDao;
import com.hh.webcustomertracker.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

//	need to inject customer dao
	@Autowired
	CustomerDao customerDao;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int customerId) {
		return customerDao.getCustomer(customerId);
	}

}
