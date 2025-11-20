package com.example.demo.factory;

import java.time.LocalDateTime;

import com.example.demo.entity.Order;

public class OrderFactory {

	public static Order get(LocalDateTime loanDate) {
		return get(loanDate, null);
	}

	public static Order get(LocalDateTime loanDate, LocalDateTime returnDate) {
		return get(loanDate, returnDate, null);
	}

	public static Order get(LocalDateTime loanDate, LocalDateTime returnDate, Boolean damaged) {
		Order order = new Order();
		order.setLoanDate(loanDate);
		order.refreshDeadline();
		order.refreshMaximumDeadline();
		order.setReturnDate(returnDate);
		order.setDamaged(damaged);
		return order;
	}

}
