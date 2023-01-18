package com.hh.webcustomertrackeraop.dao;

import java.util.List;

import com.hh.webcustomertrackeraop.entity.Customer;

public interface CustomerDao {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int customerId);

	public void deleteCustomer(int customerId);

}