package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.repository.CoreRepository;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService extends CrudService<Order> {

	@Autowired
	private OrderRepository orderRepository;

	public CoreRepository<Order, Long> getRepository() {
		return orderRepository;
	}
}
