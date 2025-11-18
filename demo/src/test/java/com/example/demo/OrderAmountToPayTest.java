package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.Order;

public class OrderAmountToPayTest {

	private void assertEqualsAmount(Order order, BigDecimal expectedAmount) {
		order.refreshAmountToPay();
		assertEquals(expectedAmount, order.getAmountToPay());
	}

	@Test
	public void testAmountToPayWhenEverythingOk() {
		Order order = new Order();
		LocalDateTime loanDate = LocalDateTime.of(2025, 04, 05, 0, 0);
		order.setLoanDate(loanDate);
		LocalDateTime returnDate = LocalDateTime.of(2025, 06, 12, 0, 0);
		order.setReturnDate(returnDate);
		order.setDamaged(false);
		assertEqualsAmount(order, BigDecimal.ZERO);

	}
	
	
	
	

}
