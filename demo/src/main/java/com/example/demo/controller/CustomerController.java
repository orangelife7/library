package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CrudService;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController extends CrudController<Customer> {

	@Autowired
	private CustomerService customerService;

	public CrudService<Customer> getService() {
		return customerService;
	}
}