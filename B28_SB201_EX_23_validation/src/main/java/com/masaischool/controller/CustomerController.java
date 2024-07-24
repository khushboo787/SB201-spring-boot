package com.masaischool.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.model.Customer;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

@RestController
public class CustomerController {
	private List<Customer> customerList;
	
	@PostConstruct
	public void setUp() {
		customerList = new ArrayList<>();
	}
	
	@PostMapping("/customers")
	public ResponseEntity<String> addCustomer(@Valid @RequestBody Customer customer){
		customerList.add(customer);
		return new ResponseEntity<String>("Customer Added Successfully", HttpStatus.CREATED);
	}
	
	/**
	 * {"id": "1",, "name": "ABC",, "lastPurchaseDate": "2022-12-31",
	 * "email": "a@b.in",, "mobile": "9865321474"}
	 * Customer Added Successfully
	 * 
	 * 
	 */
	
}
