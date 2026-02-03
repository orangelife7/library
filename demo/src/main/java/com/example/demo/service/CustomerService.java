package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import com.example.demo.mapper.CoreMapper;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.mapper.PhysicalBookMapper;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CoreRepository;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService extends CrudService<Customer> {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AddressService addressService;

	public CoreRepository<Customer, Long> getRepository() {
		return customerRepository;
	}
	
	@Override
	protected CoreMapper getMapper() {
		return new CustomerMapper();
	}

	@Override
	protected void beforeCreate(Customer entity) {
		if(entity.getAddress() == null) {
			Address address = new Address();
			addressService.create(address);
			entity.setAddress(address);
		}
		
	}
	
	
}
