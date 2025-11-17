package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Order;

public interface OrderRepository extends CoreRepository<Order, Long> {

	Order findByCustomerId(Long customerId);
}
