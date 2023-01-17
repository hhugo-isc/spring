package com.hh.webcustomertracker.service;

import java.util.List;

import com.hh.webcustomertracker.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int customerId);

}
