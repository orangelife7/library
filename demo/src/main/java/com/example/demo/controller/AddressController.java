package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Address;
import com.example.demo.service.AddressService;
import com.example.demo.service.CrudService;

@RestController
@RequestMapping("/api/address")
public class AddressController extends CrudController<Address> {

	@Autowired
	private AddressService addressService;

	public CrudService<Address> getService() {
		return addressService;
	}

}
