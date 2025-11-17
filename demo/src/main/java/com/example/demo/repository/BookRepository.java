package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;

public interface BookRepository extends CoreRepository<Book, Long> {
	
	Book findByTitle(String title);

	Book findByIsbn(String isbnNumber);
	
	List<Book> findAllByYearOfPublicationGreaterThan(int year);
	
}
