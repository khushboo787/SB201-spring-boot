package com.masaischool.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.masaischool.entity.Customer;
import com.masaischool.exception.CustomerException;
import com.masaischool.model.CustomerDetails;
import com.masaischool.repository.CustomerRepository;

@Service
public class CustomerDetailsService implements UserDetailsService {
	private CustomerRepository customerRepository;
	
	public CustomerDetailsService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws CustomerException {
		Optional<Customer> opCustomer = customerRepository.findByEmail(username);
		Customer customer = opCustomer.orElseThrow(() -> new CustomerException("No customer is available with email " + username));
		return new CustomerDetails(customer);
	}
}
