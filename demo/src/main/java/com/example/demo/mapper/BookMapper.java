package com.example.demo.mapper;

import java.awt.print.Book;

import com.example.demo.entity.Book_;
import com.example.demo.entity.PhysicalBook;
import com.example.demo.entity.PhysicalBook_;

public class BookMapper extends CoreMapper {

	private static final long serialVersionUID = 1L;

	{
		addFilter("bookFilter", filterOutAllExcept(Book_.TITLE, Book_.AUTHOR, Book_.YEAR_OF_PUBLICATION, Book_.ISBN, Book_.PHYSICAL_BOOKS));
		addFilter("physicalBookFilter", filterOutAllExcept(PhysicalBook_.CATALOG_NUMBER, PhysicalBook_.DESCRIPTION));
	}

}
