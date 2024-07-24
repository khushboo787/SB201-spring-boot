package com.masaischool.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Column(unique = true, nullable = false)
	private String email;	//I want to use email as username
	
	//Password will be written from json object to java object but when userdetails is read from database
	//then password will not be converted from java object to json object i.e. for the read operation
	//password will be skipped.
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	//auto_increment
	
	private String name;
	private String address;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String email, String password, String name, String address) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [email=" + email + ", id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}
