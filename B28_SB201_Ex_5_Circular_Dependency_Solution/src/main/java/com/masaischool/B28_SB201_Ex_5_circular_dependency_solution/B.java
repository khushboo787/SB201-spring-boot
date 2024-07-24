package com.masaischool.B28_SB201_Ex_5_circular_dependency_solution;

public class B {
	private A a;

	public B() {
		System.out.println("Inside default constructor of class B");
	}

	public void setA(A a) {
		System.out.println("Inside setter method of class B");
		this.a = a;
	}
	
	
}
//dependent class : B
//dependency class : A
