package com.neighborpil.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neighborpil.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// no need to write any code at all
	
	// add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
