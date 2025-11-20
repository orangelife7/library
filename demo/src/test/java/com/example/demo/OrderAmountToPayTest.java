package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.Order;
import com.example.demo.factory.OrderFactory;

public class OrderAmountToPayTest {

	@Test
	public void testAmountToPayWhenEverythingOk() {
		LocalDateTime loanDate = LocalDateTime.of(2025, 04, 05, 0, 0);
		LocalDateTime returnDate = LocalDateTime.of(2025, 06, 12, 0, 0);
		Order order = OrderFactory.get(loanDate, returnDate, false);
		assertEqualsAmount(order, BigDecimal.ZERO);
	}

	@Test
	public void testAmountToPayWhenUndamagedAfterDeadline() {
		LocalDateTime loanDate = LocalDateTime.of(2025, 05, 21, 17, 30);
		LocalDateTime returnDate = LocalDateTime.of(2025, 9, 14, 12, 47);
		Order order = OrderFactory.get(loanDate, returnDate, false);
		long subtractionDays = ChronoUnit.DAYS.between(order.getDeadline(), returnDate);
		BigDecimal expected = BigDecimal.valueOf(subtractionDays);
		assertEqualsAmount(order, expected);
	}

	@Test
	public void testAmountToPayWhenUndamagedAfterMaximumDeadline() {
		LocalDateTime loanDate = LocalDateTime.of(2025, 01, 15, 15, 0);
		LocalDateTime returnDate = LocalDateTime.of(2025, 11, 19, 12, 15);
		Order order = OrderFactory.get(loanDate, returnDate, false);
		long subDays1 = ChronoUnit.DAYS.between(order.getDeadline(), order.getMaximumDeadline());
		BigDecimal expected1 = BigDecimal.valueOf(subDays1).multiply(BigDecimal.ONE);
		long subtDays2 = ChronoUnit.DAYS.between(order.getMaximumDeadline(), returnDate);
		BigDecimal expected2 = BigDecimal.valueOf(subtDays2).multiply(BigDecimal.TWO);
		BigDecimal expected = expected1.add(expected2);
		assertEqualsAmount(order, expected);
	}

	@Test
	public void testAmountToPayWhenDamagedAndReturnedOnTime() {
		LocalDateTime loanDate = LocalDateTime.of(2025, 07, 16, 0, 0);
		LocalDateTime returnDate = LocalDateTime.of(2025, 9, 27, 13, 35);
		Order order = OrderFactory.get(loanDate, returnDate, true);
		long subtraction = ChronoUnit.DAYS.between(loanDate, returnDate);
		BigDecimal exp = BigDecimal.valueOf(subtraction).multiply(BigDecimal.ZERO);
		BigDecimal expected = exp.add(BigDecimal.valueOf(50));
		assertEqualsAmount(order, expected);
	}

	@Test
	public void testAmountToPayWhenDamagedAndReturnedAfterDeadline() {
		LocalDateTime loanDate = LocalDateTime.of(2025, 06, 04, 13, 57);
		LocalDateTime returnDate = LocalDateTime.of(2025, 10, 03, 14, 32);
		Order order = OrderFactory.get(loanDate, returnDate, true);
		long subtraction = ChronoUnit.DAYS.between(order.getDeadline(), returnDate);
		BigDecimal exp = BigDecimal.valueOf(subtraction).multiply(BigDecimal.ONE);
		BigDecimal expected = exp.add(BigDecimal.valueOf(50));
		assertEqualsAmount(order, expected);
	}

	@Test
	public void testAmountToPayWhenDamagedAndReturnAfterMaximumDeadline() {
		LocalDateTime loanDate = LocalDateTime.of(2025, 04, 24, 15, 16);
		LocalDateTime returnDate = LocalDateTime.of(2026, 02, 25, 9, 46);
		Order order = OrderFactory.get(loanDate, returnDate, true);

		LocalDateTime maximumDeadline = order.getMaximumDeadline();
		long subtraction1 = ChronoUnit.DAYS.between(order.getDeadline(), maximumDeadline);
		BigDecimal exp1 = BigDecimal.valueOf(subtraction1).multiply(BigDecimal.ONE);
		long subtraction2 = ChronoUnit.DAYS.between(maximumDeadline, returnDate);
		BigDecimal exp2 = BigDecimal.valueOf(subtraction2).multiply(BigDecimal.TWO);
		BigDecimal expected = exp1.add(exp2).add(BigDecimal.valueOf(50));
		assertEqualsAmount(order, expected);
	}

	private void assertEqualsAmount(Order order, BigDecimal expectedAmount) {
		order.refreshAmountToPay();
		assertEquals(expectedAmount, order.getAmountToPay());
	}

}
