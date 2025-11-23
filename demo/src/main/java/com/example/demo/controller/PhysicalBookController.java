package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PhysicalBook;
import com.example.demo.service.CrudService;
import com.example.demo.service.PhysicalBookService;

@RestController
@RequestMapping("/api/physical-book")
public class PhysicalBookController extends CrudController<PhysicalBook> {

	@Autowired
	private PhysicalBookService physicalBookService;
	
	public CrudService<PhysicalBook> getService() {
		return physicalBookService;
	}
}
