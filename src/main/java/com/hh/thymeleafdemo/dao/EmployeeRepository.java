package com.hh.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hh.thymeleafdemo.entity.Employee;

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}