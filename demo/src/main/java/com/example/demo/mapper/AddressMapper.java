package com.example.demo.mapper;

public class AddressMapper extends CoreMapper {

	private static final long serialVersionUID = 1L;

	{
		addFilter("addressFilter", filterOutAllExcept("id", "country", "city", "street", "numberOfHouseOrApartment", "zipCode", "customers"));
		addFilter("customerFilter", filterOutAllExcept("id", "firstName", "surname", "pesel"));
	}

}
