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
	private Long catalogNumber;

	@Column(name = "description")
	private String description;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;


	@JsonIgnore
	@ManyToMany(mappedBy = "physicalBooks")
	private List<Order> orders;
	
	public PhysicalBook(Long catalogNumber, String description) {
		this.catalogNumber = catalogNumber;
		this.description = description;
	}

	
	
	public Long getCatalogNumber() {
		return catalogNumber;
	}

	public void setCatalogNumber(Long catalogNumber) {
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
