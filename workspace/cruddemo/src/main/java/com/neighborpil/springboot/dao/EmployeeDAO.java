package com.neighborpil.springboot.dao;

import java.util.List;

import com.neighborpil.springboot.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
}
