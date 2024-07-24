package com.masaischool.B28_SB201_Ex_5_circular_dependency_solution;

public class A {
	private B b;

	public A(B b) {
		System.out.println("Inside parameterized constructor of class A");
		this.b = b;
	}
}
//dependent class : A
//dependency class : B
