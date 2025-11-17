package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {


	@Column(name = "first_name")
	private String firstName;

	@Column(name = "surnname")
	private String surname;

	@Column(name = "pesel")
	private String pesel;

	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> orders;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

//	Konstruktory

	public Customer() {

	}

	public Customer(String firstName, String surname, String pesel) {
		this.firstName = firstName;
		this.surname = surname;
		this.pesel = pesel;
	}

//	Gettery i Settery

	public String getFirstName() {
		return firstName;
	}
	
	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", surname=" + surname + ", pesel=" + pesel
				+ "]";
	}

}
