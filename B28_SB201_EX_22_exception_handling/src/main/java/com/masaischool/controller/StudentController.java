package com.masaischool.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.exception.NoStudentFoundForGivenMarksRangeException;
import com.masaischool.exception.NoStudentFoundForRollNumberException;
import com.masaischool.model.Student;

import jakarta.annotation.PostConstruct;

@RestController
public class StudentController {
	private List<Student> studentList;
	
	@PostConstruct
	public void init() {
		System.out.println("Inside init method");
		studentList = new ArrayList<>();
		studentList.add(new Student(1, "ABC", 94));
		studentList.add(new Student(2, "BCD", 90));
		studentList.add(new Student(3, "CDE", 85));
		studentList.add(new Student(4, "DEF", 80));
		studentList.add(new Student(5, "EFG", 72));
		studentList.add(new Student(6, "FGH", 65));
	}
	
	//This method is used to return student by roll number
	//URL: GET http://localhost:8080/students/any-roll-number
	@GetMapping("/students/{roll}")
	//@GetMapping("/students/{rollNumber}") ---- (a)
	public ResponseEntity<Student> getStudentByRollNo(@PathVariable Integer roll) {
		List<Student> list = studentList.stream().filter(st -> st.getRoll() == roll).toList();
		if(list.size() == 0)
			throw new NoStudentFoundForRollNumberException("No Student found for Roll Number " + roll);

		return new ResponseEntity<Student>(list.get(0), HttpStatus.OK);
	}
	
	/**
	 * Output for http://localhost:8080/students/1
	 * {"roll": 1, "name": "ABC", "marks": 94}
	 * 
	 * Output for http://localhost:8080/students/100
	 * No Student found for Roll Number 100
	 */
	
//	This is not a recommended approach to handle the exception
//	@ExceptionHandler(NoStudentFoundForRollNumberException.class)
//	public ResponseEntity<String> getExceptionForNoStudentByRollNumber(NoStudentFoundForRollNumberException ex){
//		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//	}
	
	//This method is to find students for a marks range
	//GET http://localhost:8080/searchbymarksrange?start=75&end=87
	@GetMapping("/searchbymarksrange")
	public ResponseEntity<List<Student>> getStudentListByMarkRange(@RequestParam Integer start, @RequestParam Integer end){//is same as
	//public List<Student> getStudentListByMarkRange(Integer start, Integer end)
		List<Student> list = studentList.stream().filter(st -> st.getMarks() >= start && st.getMarks() <= end).toList();
		if(list.size() == 0)
			throw new NoStudentFoundForGivenMarksRangeException("No Student has scored marks between " + start + " and " + end);


		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
	
	/**
	 * For http://localhost:8080/searchbymarksrange?start=75&end=87
	 * Output
	 * [{ "roll": 3, "name": "CDE", "marks": 85 },
	 *  { "roll": 4, "name": "DEF", "marks": 80 }]
	 */
}
