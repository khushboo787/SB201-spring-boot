package com.masaischool.B28_SB201_Ex_1_Dependency_Injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		// instantiate the container
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		// ctrl + 2, L : to assign value to local variable from a method call or
		// expression
		System.out.println("Container started");
		// get the bean from Container
		A bean = context.getBean("a", A.class);
		// call the fun method of the class A
		bean.fun();
		System.out.println("Bye Bye");
	}
}