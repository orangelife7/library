package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
@JsonFilter("addressFilter")
public class Address extends BaseEntity {

	@Column(name = "country")
	private String country;

	@Column(name = "city")
	private String city;

	@Column(name = "street")
	private String street;
	
	@Column(name = "number_of_house_or_apartment")
	private String numberOfHouseOrApartment;

	@Column(name = "zip_code")
	private String zipCode;
	
	@OneToMany(mappedBy = "address")
	private List<Customer> customers;

//	Konstruktory

	public Address() {
	}

	public Address(String country, String city, String street,  String numberOfHouseOrApartment, String zipCode) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.numberOfHouseOrApartment = numberOfHouseOrApartment;
		this.zipCode = zipCode;
	}

//	Gettery i Settery

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumberOfHouseOrApartment() {
		return numberOfHouseOrApartment;
	}

	public void setNumberOfHouseOrApartment(String numberOfHouseOrApartment) {
		this.numberOfHouseOrApartment = numberOfHouseOrApartment;
	}
	
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
