package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Employee;
import com.example.demo.service.CrudService;
import com.example.demo.service.EmployeeService;

public class EmployeeController extends CrudController<Employee> {

	@Autowired
	EmployeeService employeeService;
	
	public CrudService<Employee> getService() {
		return employeeService;
	}
}
