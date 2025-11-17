package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.service.CrudService;
import com.example.demo.service.OrderService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/order")
public class OrderController extends CrudController<Order> {

	@Autowired
	private OrderService orderService;

	public CrudService<Order> getService() {
		return orderService;
	}
}
