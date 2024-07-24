package com.masaischool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome(){
		//Getting the object of Security Context using static SecurityContext getContext() method of SecurityContextHolder class  
		SecurityContext context = SecurityContextHolder.getContext();
		
		//get the authentication object
		Authentication authentication = context.getAuthentication();
		
		//Get the object that contains the details of the Logged in user
		Object principal = authentication.getPrincipal();
		
		//Type case the principal object of org.springframework.security.core.userdetails.User object
		User user = (User)principal;

		//The above same code can be written as-
		//User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		System.out.println("Username: " + user.getUsername());
		System.out.println("Password: " + user.getPassword());
		
		return new ResponseEntity<String>("Welcome: All is well", HttpStatus.OK);
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> hello(){
		return new ResponseEntity<String>("Hello: All is well", HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> post(){
		return new ResponseEntity<String>("Post: All is well", HttpStatus.OK);
	}
}
