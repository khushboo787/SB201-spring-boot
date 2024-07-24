package com.masaischool.B28_SB201_Ex_21_http_request_method;

public class Student {
	private int roll;
	private String name;
	private int marks;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int roll, String name, int marks) {
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}

	public int getRoll() {
		return roll;
	}

	public String getName() {
		return name;
	}

	public int getMarks() {
		return marks;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
}
