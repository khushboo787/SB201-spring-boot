package com.masaischool.B28_SB201_Ex_18_environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class A {
	private int i;
	private String name;
	
	@Autowired
	private Environment environment;
	
	void set() {
		System.out.println("The environment object is of " + environment.getClass().getName() + " class");
		i = Integer.valueOf(environment.getProperty("intvalue"));
		name = environment.getProperty("strvalue");
	}

	@Override
	public String toString() {
		return "A [i=" + i + ", name=" + name + "]";
	}
}
