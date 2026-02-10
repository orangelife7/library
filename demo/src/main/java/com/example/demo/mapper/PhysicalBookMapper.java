package com.example.demo.mapper;

import com.example.demo.entity.Book;
import com.example.demo.entity.Book_;
import com.example.demo.entity.Order;
import com.example.demo.entity.Order_;
import com.example.demo.entity.PhysicalBook;
import com.example.demo.entity.PhysicalBook_;

public class PhysicalBookMapper extends CoreMapper {
	
	private static final long serialVersionUID = 1L;
	
	{
		addFilter(PhysicalBook.class, filterOutAllExcept(PhysicalBook_.CATALOG_NUMBER, PhysicalBook_.DESCRIPTION, PhysicalBook_.BOOK, PhysicalBook_.ORDERS));
		
		addFilter(Book.class, filterOutAllExcept(Book_.TITLE, Book_.AUTHOR));
		
		addFilter(Order.class, filterOutAllExcept(Order_.LOAN_DATE, Order_.DEADLINE, Order_.MAXIMUM_DEADLINE, 
				Order_.RETURN_DATE, Order_.CANCELLED, Order_.PREPARED, Order_.DAMAGED, Order_.PAID, Order_.AMOUNT_TO_PAY, Order_.STATUS));
	}
	
}