package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CoreRepository;

@Service
public class AddressService extends CrudService<Address> {

	@Autowired
	private AddressRepository addressRepository;
	
	public CoreRepository<Address, Long> getRepository() {
		return addressRepository;
	}

	protected Address createEmpty() {
		return new Address();
	}
}
