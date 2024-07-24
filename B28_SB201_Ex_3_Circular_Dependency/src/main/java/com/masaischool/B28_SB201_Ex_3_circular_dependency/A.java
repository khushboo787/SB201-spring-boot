package com.masaischool.B28_SB201_Ex_3_circular_dependency;

public class A {
	private B b;

	public A(B b) {
		this.b = b;
	}
}
//dependent class : A
//dependency class : B
