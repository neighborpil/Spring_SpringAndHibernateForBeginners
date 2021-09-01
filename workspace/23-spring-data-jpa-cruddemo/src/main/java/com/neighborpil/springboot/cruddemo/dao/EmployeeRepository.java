package com.neighborpil.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neighborpil.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// no need to write any code at all
}
