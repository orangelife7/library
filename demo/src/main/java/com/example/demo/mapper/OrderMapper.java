package com.example.demo.mapper;

public class OrderMapper extends CoreMapper {
	
	private static final long serialVersionUID = 1L;
	
	{
		addFilter("orderFilter", filterOutAllExcept("id", "loanDate", 
				"deadline", "maximumDeadline", "returnDate", "cancelled",
				"prepared", "damaged", "paid", "amountToPay", "status", "customer", "employee", "physicalBooks"));
		
		addFilter("customerFilter", filterOutAllExcept("id", "firstName", "surname", "pesel", "label"));
		addFilter("employeeFilter", filterOutAllExcept("id", "firstName", "surname", "label"));
		addFilter("physicalBookFilter", filterOutAllExcept("id", "catalogNumber", "description", "book"));
		 addFilter("bookFilter", filterOutAllExcept("id", "title", "author", "description"));
	}
	
		
	
}