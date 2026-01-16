package com.example.demo.mapper;

public class OrderMapper extends CoreMapper {
	
	private static final long serialVersionUID = 1L;
	
	{
		addFilter("orderFilter", filterOutAllExcept("id", "loadDate", 
				"deadline", "maximumDeadline", "returnDate", "cancelled",
				"prepared", "damaged", "paid", "amountToPay", "status", "customer", "employee", "physicalBooks"));
		
		addFilter("customerFilter", filterOutAllExcept("id", "firstName", "surname", "pesel"));
		addFilter("employeeFilter", filterOutAllExcept("id", "firstName", "surname"));
		addFilter("physicalBookFilter", filterOutAllExcept("id", "catalogNumber", "description", "book"));
		 addFilter("bookFilter", filterOutAllExcept("title", "author"));
	}
	
		
	
}