package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.Order;
import com.example.demo.enumerable.OrderStatus;
import com.example.demo.factory.OrderFactory;

public class OrderStatusTest {

	@Test
	public void testCancelled() {
		Order order = new Order();
		order.setCancelled(Boolean.TRUE);
		_assertEquals(order, OrderStatus.CANCELLED);
	}

	@Test
	public void testPrepared() {
		Order order = new Order();
		order.setPrepared(Boolean.TRUE);
		_assertEquals(order, OrderStatus.PREPARED);
	}

	@Test
	public void testInPreparation() {
		Order order = new Order();
		order.setPrepared(Boolean.FALSE);
		_assertEquals(order, OrderStatus.IN_PREPARATION);
	}

	@Test
	public void testOnLoan() {
		Order order = new Order();
		order.setLoanDate(LocalDateTime.now());
		order.refreshDeadline();
		_assertEquals(order, OrderStatus.ON_LOAN);
	}

	@Test
	public void testReturned() {
		LocalDateTime loanDate = LocalDateTime.of(2025, 10, 24, 0, 0);
		LocalDateTime returnDate = LocalDateTime.of(2025, 11, 10, 0, 0);
		Order order = OrderFactory.get(loanDate, returnDate);
		_assertEquals(order, OrderStatus.RETURNED);
	}

	@Test
	public void testReturnAfterDeadline() {
		LocalDateTime loanDate = LocalDateTime.of(2025, 10, 24, 0, 0);
		LocalDateTime returnDate = LocalDateTime.of(2026, 01, 28, 0, 0);
		Order order = OrderFactory.get(loanDate, returnDate);
		_assertEquals(order, OrderStatus.RETURN_AFTER_DEADLINE);
	}

	@Test
	public void testHighPenalty() {
		LocalDateTime loanDate = LocalDateTime.of(2025, 10, 15, 0, 0);
		LocalDateTime returnDate = LocalDateTime.of(2026, 11, 12, 0, 0);
		Order order = OrderFactory.get(loanDate, returnDate);
		_assertEquals(order, OrderStatus.HIGH_PENALTY);
	}

	@Test
	public void testUnreturned() {
		LocalDateTime loanDate = LocalDateTime.of(2025, 6, 20, 0, 0);
		Order order = OrderFactory.get(loanDate);
		_assertEquals(order, OrderStatus.UNRETURNED);
	}

	private void _assertEquals(Order order, OrderStatus expectedStatus) {
		order.refreshStatus();
		assertEquals(expectedStatus, order.getStatus());
	}

}
