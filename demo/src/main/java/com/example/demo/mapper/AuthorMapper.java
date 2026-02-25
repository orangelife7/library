package com.example.demo.mapper;



import com.example.demo.entity.Author;
import com.example.demo.entity.Author_;
import com.example.demo.entity.Book;
import com.example.demo.entity.Book_;

public class AuthorMapper extends CoreMapper {

	private static final long serialVersionUID = 1L;

	{
		addFilter(Author.class, filterOutAllExcept(Author_.FIRST_NAME, Author_.SURNAME, Author_.BOOKS));
		addFilter(Book.class, filterOutAllExcept(Book_.TITLE, Book_.YEAR_OF_PUBLICATION, Book_.ISBN));
	}
}