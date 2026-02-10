package com.example.demo.mapper;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Employee_;
import com.example.demo.entity.Order;
import com.example.demo.entity.Order_;

public class EmployeeMapper extends CoreMapper {
	
	public static final long serialVersionUID = 1L; 
	
	{
		addFilter(Employee.class, filterOutAllExcept(Employee_.FIRST_NAME, Employee_.SURNAME, Employee_.ORDERS));
		addFilter(Order.class, filterOutAllExcept(Order_.LOAN_DATE, Order_.DEADLINE, Order_.MAXIMUM_DEADLINE, 
				Order_.RETURN_DATE, Order_.CANCELLED, Order_.PREPARED, Order_.DAMAGED, Order_.PAID, Order_.AMOUNT_TO_PAY, Order_.STATUS));
	}
}