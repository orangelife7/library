package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Employee;
import com.example.demo.repository.CoreRepository;
import com.example.demo.repository.EmployeeRepository;

public class EmployeeService extends CrudService<Employee>{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public CoreRepository<Employee, Long> getRepository() {
		return employeeRepository;
	}
}
