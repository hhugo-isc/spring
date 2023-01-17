package com.hh.webcustomertracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hh.webcustomertracker.dao.CustomerDao;
import com.hh.webcustomertracker.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerDao repository;

	@GetMapping("/list")
	public String getCustomers(Model model) {
		List<Customer> customers = repository.getCustomers();
		model.addAttribute("customers", customers);
		return "list-customers";
	}

}
