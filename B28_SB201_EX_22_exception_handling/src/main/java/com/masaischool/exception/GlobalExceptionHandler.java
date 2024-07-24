package com.masaischool.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(NoStudentFoundForRollNumberException.class)
	public ResponseEntity<String> getExceptionForNoStudentByRollNumber(NoStudentFoundForRollNumberException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoStudentFoundForGivenMarksRangeException.class)
	public ResponseEntity<ErrorDetails> getExceptionForNoStudentByMarks(NoStudentFoundForGivenMarksRangeException ex, WebRequest request){
		//Create an object of ErrorDetails class
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now() , ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> getExceptionForNoHandler(NoHandlerFoundException ex, WebRequest request){
		//Create an object of ErrorDetails class
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now() , ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
}
