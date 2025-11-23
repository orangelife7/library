package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.CrudService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/book")
public class BookController extends CrudController<Book> {

	@Autowired
	private BookService bookService;

	public CrudService<Book> getService() {
		return bookService;
	}
}
