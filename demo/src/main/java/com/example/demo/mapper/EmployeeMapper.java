package com.example.demo.mapper;

public class EmployeeMapper extends CoreMapper {
	
	public static final long serialVersionUID = 1L; 
	
	{
		addFilter("employeeFilter", filterOutAllExcept("id", "firstName", "surname"));
	}
}