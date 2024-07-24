package com.masaischool.B28_SB201_Ex_3_circular_dependency;

public class B {
	private A a;

	public B(A a) {
		this.a = a;
	}
}
//dependent class : B
//dependency class : A
