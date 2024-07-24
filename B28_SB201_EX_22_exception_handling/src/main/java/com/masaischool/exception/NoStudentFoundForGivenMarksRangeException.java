package com.masaischool.exception;


//Throwable
//Exception (checked exception)
//	RuntimeException (unchecked exception)
//Error (Fatal Error, unchecked exception)

//public class NoStudentFoundForRollNumberException extends Exception { --- (1) Checked
//In case of REST API it is not good to throw checked Exception

public class NoStudentFoundForGivenMarksRangeException extends RuntimeException { //--- (2) Unchecked
	public NoStudentFoundForGivenMarksRangeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
