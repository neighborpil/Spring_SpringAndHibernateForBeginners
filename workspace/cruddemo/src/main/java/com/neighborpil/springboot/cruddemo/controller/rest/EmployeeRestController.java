package com.neighborpil.springboot.cruddemo.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neighborpil.springboot.cruddemo.entity.Employee;
import com.neighborpil.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	// quick and dirty: inject employee service 
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		
		employeeService = theEmployeeService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll()	{
		
		return employeeService.findAll();
	}
	
}
