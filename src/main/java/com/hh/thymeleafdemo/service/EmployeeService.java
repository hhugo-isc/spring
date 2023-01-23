package com.hh.thymeleafdemo.service;

import java.util.List;

import com.hh.thymeleafdemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int employeeId);

	public void save(Employee thEmployee);

	public void deleteById(int employeeId);
}