package com.example.demo.mapper;

public class PhysicalBookMapper extends CoreMapper {
	
	private static final long serialVersionUID = 1L;
	
	{
		addFilter("physicalBookFilter", filterOutAllExcept("id", "catalogNumber", "description"));
	}
	
}