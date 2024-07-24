package com.masaischool.B28_SB201_Ex_17_value_annotation_properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class A {
	@Value("${intvalue}")
	private int i;
	
	@Value("${strvalue}")
	private String name;

	@Override
	public String toString() {
		return "A [i=" + i + ", name=" + name + "]";
	}
}
