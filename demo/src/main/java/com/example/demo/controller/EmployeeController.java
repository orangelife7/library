package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.CrudService;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController extends CrudController<Employee> {

	@Autowired
	EmployeeService employeeService;
	
	public CrudService<Employee> getService() {
		return employeeService;
	}
}
