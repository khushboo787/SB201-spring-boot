package com.masaischool.B28_SB201_Ex_24.exception;

public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException(String message) {
		super(message);
	}
}