package com.hh.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hh.thymeleafdemo.entity.Employee;
import com.hh.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

//	add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model model) {
//		add to the spring model
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);
		return "list-employees";
	}

}
