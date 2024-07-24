package com.masaischool.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {
	@NotNull(message = "Please provide value for customer id")	//means the id must have a value
	@Min(value = 1L, message = "Id must be a positive integer")
	private Integer id;
	
	//Interview: What is the difference between @NotNull,@NotEmpty & @NotBlank 
	//@NotNull: null is not allowed but empty String ("") is allowed
	//@NotEmpty:neither null nor empty is allowed it trim the value then check if it is empty
	@NotBlank(message = "Please provide name")
	@Size(min = 3, max = 10, message = "{name.invalid}")
	private String name;
	
	@NotNull(message = "Please provide value for last purchase date")
	@PastOrPresent(message = "Last purchase date must be of today or past")
	private LocalDate lastPurchaseDate;
	
	@NotNull(message = "Please provide email")
	@Email(
			regexp = "[a-z0-9.]+@[a-z0-9.]+\\.[a-z]{2,3}",
			flags = Pattern.Flag.CASE_INSENSITIVE,
			message = "Please provide a valid email")
	private String email;
	
	@Pattern(regexp = "[6-9][0-9]{9}", message = "please provide 10 digit Indian mobile number")
	private String mobile;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer id, String name, LocalDate lastPurchaseDate, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.lastPurchaseDate = lastPurchaseDate;
		this.email = email;
		this.mobile = mobile;
	}
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public LocalDate getLastPurchaseDate() {
		return lastPurchaseDate;
	}
	public String getEmail() {
		return email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLastPurchaseDate(LocalDate lastPurchaseDate) {
		this.lastPurchaseDate = lastPurchaseDate;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
