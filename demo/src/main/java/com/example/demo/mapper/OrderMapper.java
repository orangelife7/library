package com.example.demo.mapper;

import java.awt.print.Book;

import com.example.demo.entity.Book_;
import com.example.demo.entity.Customer_;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Employee_;
import com.example.demo.entity.Order_;
import com.example.demo.entity.PhysicalBook;
import com.example.demo.entity.PhysicalBook_;

public class OrderMapper extends CoreMapper {
	
	private static final long serialVersionUID = 1L;
	
	{
		addFilter("orderFilter", filterOutAllExcept(Order_.LOAN_DATE, Order_.DEADLINE, Order_.MAXIMUM_DEADLINE,
				Order_.RETURN_DATE, Order_.CANCELLED, Order_.PREPARED, Order_.DAMAGED, Order_.PAID, Order_.AMOUNT_TO_PAY,
				Order_.STATUS, Order_.CUSTOMER, Order_.EMPLOYEE, Order_.PHYSICAL_BOOKS));
		
		addFilter("customerFilter", filterOutAllExcept(Customer_.FIRST_NAME, Customer_.SURNAME, Customer_.PESEL));
		addFilter("employeeFilter", filterOutAllExcept(Employee_.FIRST_NAME, Employee_.SURNAME));
		addFilter("physicalBookFilter", filterOutAllExcept(PhysicalBook_.CATALOG_NUMBER, PhysicalBook_.DESCRIPTION, PhysicalBook_.BOOK));
		 addFilter("bookFilter", filterOutAllExcept(Book_.TITLE, Book_.AUTHOR));
	}
	
		
	
}