package com.masaischool.model;

public class Student {
	private Integer roll;
	private String name;
	private Integer marks;
	
	public Student(Integer roll, String name, Integer marks) {
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}
	
	public Student(String name, Integer marks) {
		super();
		this.name = name;
		this.marks = marks;
	}
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getRoll() {
		return roll;
	}
	public String getName() {
		return name;
	}
	
	public Integer getMarks() {
		return marks;
	}
	public void setRoll(Integer roll) {
		this.roll = roll;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
}
