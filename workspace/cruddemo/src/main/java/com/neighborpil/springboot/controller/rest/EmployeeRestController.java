package com.neighborpil.springboot.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neighborpil.springboot.dao.EmployeeDAO;
import com.neighborpil.springboot.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeDAO employeeDAO;

	// quick and dirty: inject employee dao
	@Autowired
	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
		
		employeeDAO = theEmployeeDAO;
	}
	
	// expose "/employee" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll()	{
		
		return employeeDAO.findAll();
	}
	
}
