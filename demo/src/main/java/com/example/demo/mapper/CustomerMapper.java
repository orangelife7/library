package com.example.demo.mapper;

public class CustomerMapper extends CoreMapper {
	
	private static final long serialVersionUID = 1L;
	
	{
		addFilter("customerFilter", filterOutAllExcept("id", "firstName", "surname", "pesel", "address"));
		addFilter("addressFilter", filterOutAllExcept("country", "city", "street", "numberOfHouseOrApartment", "zipCode"));
	}
	
}