package com.example.demo.mapper;

public class PhysicalBookMapper extends CoreMapper {
	
	private static final long serialVersionUID = 1L;
	
	{
		addFilter("physicalBookFilter", filterOutAllExcept("id", "catalogNumber", "description", "book", "orders"));
		
		addFilter("bookFilter", filterOutAllExcept("id", "title", "author", "description"));
		
		addFilter("orderFilter", filterOutAllExcept("id", "loanDate", "deadline", "maximumDeadline", 
				"returnDate", "cancelled", "prepared", "damaged", "paid", "amountToPaid", "status"));
	}
	
}