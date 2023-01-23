package com.hh.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
		return "employees/list-employees";
	}

	@GetMapping("showFormForAdd")
	public String showFormForAdd(Model model) {
//		create and add attribute to the model
		model.addAttribute("employee", new Employee());

		return "employees/employee-form";
	}

	@PostMapping("save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees/list";
	}

}
