package com.example.demo.entity;

import java.util.List;

import com.example.demo.enumerable.BookState;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
@JsonFilter("bookFilter")
public class Book extends BaseEntity {

	@Column(name = "title")
	private String title;

	@Column(name = "year_of_publication")
	private Integer yearOfPublication;

	@Column(name = "isbn")
	private String isbn;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;

	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	private List<PhysicalBook> physicalBooks;

	@Column(name = "state")
	@Enumerated(EnumType.STRING)
	private BookState state;

//	Konstruktory

	public Book() {
	}

	public Book(String title, int yearOfPublication, String isbn) {
		this.title = title;
		this.yearOfPublication = yearOfPublication;
		this.isbn = isbn;
	}

	public String getLabel() {
		String t = title == null ? "" : title;
		String yp = yearOfPublication == null ? "" : yearOfPublication.toString();
		String in = isbn == null ? "" : isbn;
		return (t + ", " + yp + ", " + in);
	}
	
//	Gettery i Settery

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public BookState getState() {
		return state;
	}

	public void setState(BookState state) {
		this.state = state;
	}

}
