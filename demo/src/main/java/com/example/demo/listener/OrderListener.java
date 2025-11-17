package com.example.demo.listener;

import com.example.demo.entity.Order;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PreUpdate;

public class OrderListener {

	@PostPersist
	@PreUpdate
	public void handle(Order order) {
		order.refreshDeadline();
		order.refreshStatus();
		order.refresAmountToPay();
		order.maximumDeadline();
	}
}
