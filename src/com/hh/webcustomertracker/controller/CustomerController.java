package com.hh.webcustomertracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hh.webcustomertracker.entity.Customer;
import com.hh.webcustomertracker.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String getCustomers(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer, Model model) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}

}
