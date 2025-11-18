package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.Order;
import com.example.demo.enumerable.OrderStatus;

public class OrderStatusTest {

	private void _assertEquals(Order order, OrderStatus expectedStatus) {
		order.refreshStatus();
		assertEquals(expectedStatus, order.getStatus());
	}

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
		Order order = new Order();
		LocalDateTime loanDateTime = LocalDateTime.of(2025, 10, 24, 0, 0);
		order.setLoanDate(loanDateTime);
		order.refreshDeadline();
		LocalDateTime returnDate = LocalDateTime.of(2025, 11, 10, 0, 0);
		order.setReturnDate(returnDate);
		_assertEquals(order, OrderStatus.RETURNED);
	}

	@Test
	public void testReturnAfterDeadline() {
		Order order = new Order();
		LocalDateTime loanDateTime = LocalDateTime.of(2025, 10, 24, 0, 0);
		order.setLoanDate(loanDateTime);
		order.refreshDeadline();
		LocalDateTime returnDate = LocalDateTime.of(2026, 01, 28, 0, 0);
		order.setReturnDate(returnDate);
		_assertEquals(order, OrderStatus.RETURN_AFTER_DEADLINE);
	}

	@Test
	public void testHighPenalty() {
		Order order = new Order();
		LocalDateTime loanDateTime = LocalDateTime.of(2025, 10, 15, 0, 0);
		order.setLoanDate(loanDateTime);
		order.refreshDeadline();
		order.setMaximumDeadline(order.getDeadline());
		LocalDateTime returnDate = LocalDateTime.of(2026, 11, 12, 0, 0);
		order.setReturnDate(returnDate);
		_assertEquals(order, OrderStatus.HIGH_PENALTY);
	}

	@Test
	public void testUnreturned() {
		Order order = new Order();
		LocalDateTime loanDate = LocalDateTime.of(2025, 4, 20, 0, 0);
		order.setLoanDate(loanDate);
		order.refreshDeadline();
		order.refreshMaximumDeadline();
		_assertEquals(order, OrderStatus.UNRETURNED);
	}
}
