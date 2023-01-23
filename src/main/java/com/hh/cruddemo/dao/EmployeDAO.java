package com.hh.cruddemo.dao;

import java.util.List;

import com.hh.cruddemo.entity.Employee;

public interface EmployeDAO {

	public List<Employee> findAll();

	public Employee findById(int employeeId);

	public void save(Employee thEmployee);

	public void deleteById(int employeeId);

}
