package com.masaischool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.entity.Customer;
import com.masaischool.model.CustomerDetails;
import com.masaischool.service.CustomerService;

@RestController
public class CustomerController {
	private CustomerService customerService;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public CustomerController(CustomerService customerService, PasswordEncoder passwordEncoder) {
		this.customerService = customerService;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/customers")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
		//code to encrypt the password before saving
		String encPassword = passwordEncoder.encode(customer.getPassword());
		customer.setPassword(encPassword);
		
		Customer cust = customerService.registerCustomer(customer);
		return new ResponseEntity<Customer>(cust, HttpStatus.CREATED);
	}
	
	@GetMapping("/check-logged-in-user")
	public ResponseEntity<Customer> getLoggedInCustomerDetails(){
		CustomerDetails cd = (CustomerDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = cd.getCustomer();
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
}
