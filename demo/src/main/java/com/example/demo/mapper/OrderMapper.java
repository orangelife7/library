package com.example.demo.mapper;

public class OrderMapper extends CoreMapper {
	
	private static final long serialVersionUID = 1L;
	
	{
		addFilter("orderFilter", filterOutAllExcept("id", "loadDate", 
				"deadline", "maximumDeadline", "returnDate", "cancelled",
				"prepared", "damaged", "paid", "amountToPay", "status"));
	}
}