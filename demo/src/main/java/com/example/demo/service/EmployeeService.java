package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.mapper.CoreMapper;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.CoreRepository;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService extends CrudService<Employee>{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public CoreRepository<Employee, Long> getRepository() {
		return employeeRepository;
	}
	
	@Override
	protected CoreMapper getMapper() {
		return new EmployeeMapper();
	}
}
