package com.masaischool.B28_SB201_Ex_24.dto;

public class StudentDTO {
	private String name;
	private Integer marks;
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentDTO(String name, Integer marks) {
		super();
		this.name = name;
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
}
