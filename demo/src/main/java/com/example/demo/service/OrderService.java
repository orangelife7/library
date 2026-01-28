package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Order;
import com.example.demo.mapper.CoreMapper;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.repository.CoreRepository;
import com.example.demo.repository.OrderRepository;

@Service
@Transactional
public class OrderService extends CrudService<Order> {

	@Autowired
	private OrderRepository orderRepository;

	public CoreRepository<Order, Long> getRepository() {
		return orderRepository;
	}

	public void refreshStatus() {
		List<Order> orders = orderRepository.findAll();
		
		for (Order order : orders) {
			order.refreshStatus();
		}
	}

	@Override
	protected CoreMapper getMapper() {
		return new OrderMapper();
	}
		
}
