package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "surname")
	private String surname;

	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<Order> orders;

// Konstruktor
	public String toString() {
		return "Employee [firstName=" + firstName + ", surname=" + surname + ", orders=" + orders + "]";
	}

// Gettery i Settery
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

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}


