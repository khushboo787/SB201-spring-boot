package com.masaischool.B28_SB201_Ex_16_value_annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class A {
	@Value("10")
	private int i;
	
	@Value("Ram")
	private String name;

	@Override
	public String toString() {
		return "A [i=" + i + ", name=" + name + "]";
	}
}
