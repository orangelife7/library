package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book extends BaseEntity{

	
	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String author;

	@Column(name = "year_of_publication")
	private Integer yearOfPublication;

	@Column(name = "isbn")
	private String isbn;

	@JsonIgnore
	@OneToMany(mappedBy = "books")
	private List<Order> orders;

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

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public boolean isPublishedAfter2010() {
		return yearOfPublication > 2010;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", yearOfPublication=" + yearOfPublication
				+ ", isbn=" + isbn + ", orders=" + orders + "]";
	}

}
