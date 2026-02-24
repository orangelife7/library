package com.example.demo.repository;

import com.example.demo.entity.Author;

public interface AuthorRepository extends CoreRepository<Author, Long> {
	
	Author findByFirstName (String firstName);
	Author findBySurname (String surname);
}