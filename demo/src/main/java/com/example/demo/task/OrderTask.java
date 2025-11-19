package com.example.demo.task;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.service.OrderService;

@Component
public class OrderTask {

	@Autowired
	private OrderService orderService;
	
	@Scheduled(cron = "*/10 * * * * *")
	public void run() {
		orderService.refreshStatus();
		System.out.println("Task execution at: " + LocalDateTime.now());
	}
}
