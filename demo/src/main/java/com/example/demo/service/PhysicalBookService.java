package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.PhysicalBook;
import com.example.demo.mapper.CoreMapper;
import com.example.demo.mapper.PhysicalBookMapper;
import com.example.demo.repository.CoreRepository;
import com.example.demo.repository.PhysicalBookRepository;

@Service
public class PhysicalBookService extends CrudService<PhysicalBook>{

	@Autowired
	private PhysicalBookRepository physicalBookRepository;
	
	public CoreRepository<PhysicalBook, Long> getRepository() {
		return physicalBookRepository;
	}
	
	@Override
	protected CoreMapper getMapper() {
		return new PhysicalBookMapper();
	}
	
	protected PhysicalBook createEmpty() {
		return new PhysicalBook();
	}
}
