package com.example.demo.mapper;

import com.example.demo.entity.Address_;
import com.example.demo.entity.Customer_;
import com.example.demo.entity.Order_;

public class CustomerMapper extends CoreMapper {
	
	private static final long serialVersionUID = 1L;
	
	{
		addFilter("customerFilter", filterOutAllExcept(Customer_.ID, Customer_.FIRST_NAME, Customer_.SURNAME, Customer_.PESEL, Customer_.ADDRESS, Customer_.ORDERS));
		addFilter("addressFilter", filterOutAllExcept(Address_.ID, Address_.COUNTRY, Address_.CITY, Address_.STREET, Address_.NUMBER_OF_HOUSE_OR_APARTMENT, Address_.ZIP_CODE));
		addFilter("orderFilter", filterOutAllExcept(Order_.ID, Order_.LOAN_DATE, Order_.DEADLINE, Order_.MAXIMUM_DEADLINE, 
				Order_.RETURN_DATE, Order_.CANCELLED, Order_.PREPARED, Order_.DAMAGED, Order_.PAID, Order_.AMOUNT_TO_PAY, Order_.STATUS));
	}
	
}