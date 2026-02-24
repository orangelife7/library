package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Author;
import com.example.demo.mapper.AuthorMapper;
import com.example.demo.mapper.CoreMapper;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.CoreRepository;

@Service
public class AuthorService extends CrudService<Author> {
	
	@Autowired
	AuthorRepository authorRepository;
	
	public CoreRepository<Author, Long> getRepository() {
		return authorRepository;
	}
	
	protected CoreMapper getMapper() {
		return new AuthorMapper() ;
	}
}