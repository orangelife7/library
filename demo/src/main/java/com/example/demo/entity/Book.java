package com.example.demo.entity;

import java.util.List;

import com.example.demo.enumerable.BookState;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book extends BaseEntity {

	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String author;

	@Column(name = "year_of_publication")
	private Integer yearOfPublication;

	@Column(name = "isbn")
	private String isbn;

	@JsonIgnore
	@OneToMany(mappedBy = "book")
	private List<PhysicalBook> physicalBooks;
	
	@Column(name = "state")
	@Enumerated(EnumType.STRING)
	private BookState state;

//	Konstruktory

	public Book() {
	}

	public Book(String title, String author, int yearOfPublication, String isbn) {
		this.title = title;
		this.author = author;
		this.yearOfPublication = yearOfPublication;
		this.isbn = isbn;
	}

//	Gettery i Settery

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(Integer yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean isPublishedAfter2010() {
		return yearOfPublication > 2010;
	}

	public List<PhysicalBook> getPhysicalBooks() {
		return physicalBooks;
	}

	public void setPhysicalBooks(List<PhysicalBook> physicalBooks) {
		this.physicalBooks = physicalBooks;
	}

}
