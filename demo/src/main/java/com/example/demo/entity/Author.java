package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFilter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "author")
@JsonFilter("authorFilter")
public class Author extends BaseEntity {
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "surname")
	private String surname;
	
	@OneToMany(mappedBy = "author")
	private List<Book> books;
	
	public Author() {
		
	}
	
	public Author(String firstName, String surname) {
		this.firstName = firstName;
		this.surname = surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}