package com.example.demo.mapper;

import com.example.demo.entity.Address_;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Customer_;

public class AddressMapper extends CoreMapper {

	private static final long serialVersionUID = 1L;

	{
		addFilter("addressFilter", filterOutAllExcept(Address_.ID, Address_.COUNTRY, Address_.CITY, Address_.STREET, Address_.NUMBER_OF_HOUSE_OR_APARTMENT, Address_.ZIP_CODE, Address_.CUSTOMERS));
		addFilter("customerFilter", filterOutAllExcept(Customer_.ID, Customer_.FIRST_NAME, Customer_.SURNAME, Customer_.PESEL));
	}

}
