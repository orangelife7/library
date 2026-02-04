package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.example.demo.enumerable.OrderStatus;
import com.example.demo.listener.OrderListener;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
@JsonFilter("orderFilter")
@EntityListeners(OrderListener.class)
public class Order extends BaseEntity {

	@Column(name = "loan_date")
	private LocalDateTime loanDate;

	@Column(name = "deadline")
	private LocalDateTime deadline;

	@Column
	private LocalDateTime maximumDeadline;

	@Column(name = "returnDate")
	private LocalDateTime returnDate;

	@Column(name = "cancelled")
	private Boolean cancelled;

	@Column(name = "prepared")
	private Boolean prepared;

	@Column(precision = 6, scale = 2)
	private BigDecimal amountToPay;

	@Column
	private Boolean damaged;

	@Column
	private Boolean paid;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToMany
	@JoinTable(name = "order_physical_book", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "physical_book_id"))
	private List<PhysicalBook> physicalBooks;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

//  Konstruktor
	public Order() {	
	}
	
	
//	Metody

	public void refreshDeadline() {
		if (loanDate != null) {
			LocalDateTime deadline = loanDate.plusDays(90);
			setDeadline(deadline);
		} else {
			setDeadline(null);
		}

	}

	public void refreshMaximumDeadline() {
		if (deadline != null) {
			LocalDateTime maxDeadline = deadline.plusDays(180);
			setMaximumDeadline(maxDeadline);
		} else {
			setMaximumDeadline(null);
		}
	}

//	Statusy zamówień

	public void refreshStatus() {
		OrderStatus status = getStatusByDates();
		setStatus(status);
	}

	public void refreshAmountToPay() {
		BigDecimal amount = calculateAmountToPay();
		setAmountToPay(amount);
	}

	private OrderStatus getStatusByDates() {
		if (Boolean.TRUE.equals(cancelled)) {
			return OrderStatus.CANCELLED;
		}
		if (loanDate == null || LocalDateTime.now().isBefore(loanDate)) {
			if (Boolean.TRUE.equals(prepared)) {
				return OrderStatus.PREPARED;
			}
			return OrderStatus.IN_PREPARATION;
		}

		if (returnDate != null) {
			if (maximumDeadline != null && returnDate.isAfter(maximumDeadline)) {
				return OrderStatus.HIGH_PENALTY;
			}
			if (returnDate.isAfter(deadline)) {
				return OrderStatus.RETURN_AFTER_DEADLINE;
			}
			return OrderStatus.RETURNED;
		}

		if (LocalDateTime.now().isAfter(loanDate) && LocalDateTime.now().isBefore(deadline)) {
			return OrderStatus.ON_LOAN;
		}

		if (maximumDeadline != null && LocalDateTime.now().isAfter(maximumDeadline)) {
			return OrderStatus.HIGH_PENALTY;
		}
		return OrderStatus.UNRETURNED;

	}

//	Dodatkowe opłaty

	private BigDecimal calculateAmountToPay() {
		BigDecimal sum = BigDecimal.ZERO;

		LocalDateTime date = returnDate;
		if (date == null) {
			date = LocalDateTime.now();
		}
		BigDecimal amountByDays = getAmountByDays(date, deadline, maximumDeadline);
		sum = sum.add(amountByDays);

		if (Boolean.TRUE.equals(damaged)) {
			sum = sum.add(BigDecimal.valueOf(50));
		}
		return sum;
	}

	private BigDecimal getAmountByDays(LocalDateTime date, LocalDateTime deadline, LocalDateTime maxDeadline) {
		if (date == null || deadline == null || maximumDeadline == null) {
			return BigDecimal.ZERO;
		}
		if (date.isBefore(deadline)) {
			return BigDecimal.ZERO;
		}
		if (date.isAfter(maxDeadline)) {
			long daysBetweenDeadlineAndMaxDeadline = ChronoUnit.DAYS.between(deadline, maxDeadline) * 1;
			long daysBetwenDateAndMaxDeadline = ChronoUnit.DAYS.between(maxDeadline, date) * 2;
			long sum = daysBetweenDeadlineAndMaxDeadline + daysBetwenDateAndMaxDeadline;
			return BigDecimal.valueOf(sum);
		}
		long daysBetweenDateAndDeadline = ChronoUnit.DAYS.between(deadline, date) * 1;
		return BigDecimal.valueOf(daysBetweenDateAndDeadline);
	}

	public String getLabel() {
		return getId() != null ? String.valueOf(getId()) : "";
	}
	
//	Gettery i Settery

	public LocalDateTime getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(LocalDateTime loanDate) {
		this.loanDate = loanDate;
	}

	public LocalDateTime getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<PhysicalBook> getPhysicalBooks() {
		return physicalBooks;
	}

	public void setPhysicalBooks(List<PhysicalBook> physicalBooks) {
		this.physicalBooks = physicalBooks;
	}

	public Boolean getCancelled() {
		return cancelled;
	}

	public void setCancelled(Boolean cancelled) {
		this.cancelled = cancelled;
	}

	public Boolean getPrepared() {
		return prepared;
	}

	public void setPrepared(Boolean prepared) {
		this.prepared = prepared;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	public BigDecimal getAmountToPay() {
		return amountToPay;
	}

	public void setAmountToPay(BigDecimal amountToPay) {
		this.amountToPay = amountToPay;
	}

	public Boolean getDamaged() {
		return damaged;
	}

	public void setDamaged(Boolean damaged) {
		this.damaged = damaged;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public LocalDateTime getMaximumDeadline() {
		return maximumDeadline;
	}

	public void setMaximumDeadline(LocalDateTime maximumDeadline) {
		this.maximumDeadline = maximumDeadline;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
