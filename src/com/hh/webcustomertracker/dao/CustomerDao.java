package com.hh.webcustomertracker.dao;

import java.util.List;

import com.hh.webcustomertracker.entity.Customer;

public interface CustomerDao {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

}
