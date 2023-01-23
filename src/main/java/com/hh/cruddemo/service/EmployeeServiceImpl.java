package com.hh.cruddemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hh.cruddemo.dao.EmployeDAO;
import com.hh.cruddemo.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeDAO employeDAO;

	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeDAO employeDAO) {
		this.employeDAO = employeDAO;
	}

	@Override
	public List<Employee> findAll() {
		return employeDAO.findAll();
	}

	@Override
	public Employee findById(int employeeId) {
		return employeDAO.findById(employeeId);
	}

	@Override
	public void save(Employee thEmployee) {
		employeDAO.save(thEmployee);
	}

	@Override
	public void deleteById(int employeeId) {
		employeDAO.deleteById(employeeId);
	}

}
