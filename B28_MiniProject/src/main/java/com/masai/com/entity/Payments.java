package com.masai.com.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private Integer paymentId;

	@ManyToOne
	@JoinColumn(name = "ride_id")
	private Rides ride;

	@Column(name = "amount")
	private BigDecimal amount;

	@Column(name = "currency")
	private String currency;

	@Column(name = "payment_method")
	private String paymentMethod;

	@Column(name = "payment_status")
	private String paymentStatus;

	@Column(name = "timestamp")
	private LocalDateTime timestamp;

	public Payments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payments(Rides ride, BigDecimal amount, String currency, String paymentMethod, String paymentStatus,
			LocalDateTime timestamp) {
		super();
		this.ride = ride;
		this.amount = amount;
		this.currency = currency;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.timestamp = timestamp;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Rides getRide() {
		return ride;
	}

	public void setRide(Rides ride) {
		this.ride = ride;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Payments [paymentId=" + paymentId + ", ride=" + ride + ", amount=" + amount + ", currency=" + currency
				+ ", paymentMethod=" + paymentMethod + ", paymentStatus=" + paymentStatus + ", timestamp=" + timestamp
				+ "]";
	}

}
