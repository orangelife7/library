package com.example.demo.mapper;

import java.awt.print.Book;

import com.example.demo.entity.Author;
import com.example.demo.entity.Author_;
import com.example.demo.entity.Book_;
import com.example.demo.entity.PhysicalBook;
import com.example.demo.entity.PhysicalBook_;

public class BookMapper extends CoreMapper {

	private static final long serialVersionUID = 1L;

	{
		addFilter(Book.class, filterOutAllExcept(Book_.TITLE, Book_.AUTHOR, Book_.YEAR_OF_PUBLICATION, Book_.ISBN, Book_.PHYSICAL_BOOKS));
		addFilter(PhysicalBook.class, filterOutAllExcept(PhysicalBook_.CATALOG_NUMBER, PhysicalBook_.DESCRIPTION));
		addFilter(Author.class, filterOutAllExcept(Author_.FIRST_NAME, Author_.SURNAME));
	}

}
