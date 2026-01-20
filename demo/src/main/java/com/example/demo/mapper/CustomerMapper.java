package com.example.demo.mapper;

public class CustomerMapper extends CoreMapper {
	
	private static final long serialVersionUID = 1L;
	
	{
		addFilter("customerFilter", filterOutAllExcept("id", "firstName", "surname", "pesel", "address", "orders"));
		addFilter("addressFilter", filterOutAllExcept("country", "city", "street", "numberOfHouseOrApartment", "zipCode"));
		addFilter("orderFilter", filterOutAllExcept("id", "loadDate", "deadline", "maximumDeadline", 
				"returnDate", "cancelled", "prepared", "damaged", "paid", "amountToPaid", "status"));
	}
	
}