package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.CoreMapper;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CoreRepository;

@Service
public class BookService extends CrudService<Book> {

	@Autowired
	private BookRepository bookRepository;

	public CoreRepository<Book, Long> getRepository() {
		return bookRepository;
	}

	@Override
	protected CoreMapper getMapper() {
		return new BookMapper();
	}

}
