package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFilter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "physical_book")
@JsonFilter("physicalBookFilter")
public class PhysicalBook extends BaseEntity {

	@NotNull
	@Column(name = "catalog_number", unique = true, nullable=false)
	private String catalogNumber;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	@ManyToMany(mappedBy = "physicalBooks")
	private List<Order> orders;

	public PhysicalBook() {
	}

	public PhysicalBook(Book book, String catalogNumber) {
		this(book, catalogNumber, null);
	}

	public PhysicalBook(Book book, String catalogNumber, String description) {
		this.book = book;
		this.catalogNumber = catalogNumber;
		this.description = description;
	}

	public String getLabel() {
		return getId() != null ? String.valueOf(getId()) : "";
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

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
