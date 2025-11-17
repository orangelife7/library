package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Customer;

public interface CustomerRepository extends CoreRepository<Customer, Long> {

	Customer findByFirstName(String firstName);

	Customer findBySurname(String surname);

	Customer findByPesel(String pesel);
	
	List<Customer> findAllByAddressCityOrderBySurnameDesc(String city);
}
