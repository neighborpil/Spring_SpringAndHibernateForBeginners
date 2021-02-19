package com.neighborpil.springboot.cruddemo.dao;

import java.util.List;

import com.neighborpil.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
}
