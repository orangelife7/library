package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Address;

public interface AddressRepository extends CoreRepository<Address, Long> {

	Address findByCity(String city);

	Address findByStreet(String street);

	Address findByZipCode(String zipCode);
}
