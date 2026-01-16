package com.example.demo.mapper;

public class BookMapper extends CoreMapper {

	private static final long serialVersionUID = 1L;

	{
		addFilter("bookFilter", filterOutAllExcept("id", "title", "author", "yearOfPublication", "isbn"));
	}

}
