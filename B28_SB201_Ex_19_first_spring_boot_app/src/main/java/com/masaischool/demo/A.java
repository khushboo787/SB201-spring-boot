package com.masaischool.demo;

import org.springframework.stereotype.Component;

@Component
public class A {
	public A() {
		System.out.println("Inside constructor of class A");
	}
	
	public void fun() {
		System.out.println("Inside fun");
	}
}
