package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.mapper.CoreMapper;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.mapper.PhysicalBookMapper;
import com.example.demo.repository.CoreRepository;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService extends CrudService<Customer> {

	@Autowired
	private CustomerRepository customerRepository;

	public CoreRepository<Customer, Long> getRepository() {
		return customerRepository;
	}
	
	@Override
	protected CoreMapper getMapper() {
		return new CustomerMapper();
	}
}
