package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "physical_book")
public class PhysicalBook extends BaseEntity {

	@NotNull
	@Column(name = "catalog_number", unique = true)
	private String catalogNumber;

	@Column(name = "description")
	private String description;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;


	@JsonIgnore
	@ManyToMany(mappedBy = "physicalBooks")
	private List<Order> orders;
	
	public PhysicalBook(Book book, String catalogNumber) {
		this.book = book;
		this.catalogNumber = catalogNumber;
	}

	
	
	public String getCatalogNumber() {
		return catalogNumber;
	}

	public void setCatalogNumber(String catalogNumber) {
		this.catalogNumber = catalogNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
