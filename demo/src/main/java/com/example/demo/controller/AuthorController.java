package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Author;
import com.example.demo.service.AuthorService;
import com.example.demo.service.CrudService;

@RestController
@RequestMapping("/api/author")
public class AuthorController extends CrudController<Author> {
	
	@Autowired
	private AuthorService authorService;
	
	public CrudService<Author> getService() {
		return authorService;
	}
}