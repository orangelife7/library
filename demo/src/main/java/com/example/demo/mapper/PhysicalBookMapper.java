package com.example.demo.mapper;

public class PhysicalBookMapper extends CoreMapper {
	
	private static final long serialVersionUID = 1L;
	
	{
		addFilter("physicalBookFilter", filterOutAllExcept("id", "catalogNumber", "description", "book", "orders"));
		
		addFilter("bookFilter", filterOutAllExcept("title", "author"));
		
		addFilter("orderFilter", filterOutAllExcept("id", "loadDate", "deadline", "maximumDeadline", 
				"returnDate", "cancelled", "prepared", "damaged", "paid", "amountToPaid", "status"));
	}
	
}