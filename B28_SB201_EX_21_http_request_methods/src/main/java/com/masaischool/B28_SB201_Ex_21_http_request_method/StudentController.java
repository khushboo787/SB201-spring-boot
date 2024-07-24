package com.masaischool.B28_SB201_Ex_21_http_request_method;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	//This method is used to return all students
	//URL: GET http://localhost:8080/students
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}
	
	/** Output
	 * [
	 * 	{"roll":1,"name":"ABC","marks":94},
	 * 	{"roll":2,"name":"BCD","marks":90},
	 * 	{"roll":3,"name":"CDE","marks":85},
	 * 	{"roll":4,"name":"DEF","marks":80},
	 * 	{"roll":5,"name":"EFG","marks":72},
	 * 	{"roll":6,"name":"FGH","marks":65}
	 * ]
	 */
	
	//This method is used to return student by roll number
	//URL: GET http://localhost:8080/students/any-roll-number
	@GetMapping("/students/{roll}")
	//@GetMapping("/students/{rollNumber}") ---- (a)
	public ResponseEntity<Student> getStudentByRollNo(@PathVariable Integer roll) {
	//public Student getStudentByRollNo(@PathVariable("rollNumber") Integer roll) { ---- (b)
		//Conventional way
//		Student temp = null;
//		for(Student st: studentList) {
//			if(st.getRoll() == roll) {
//				temp = st;
//				break;				
//			}
//		}
//		return temp;
		
		//using Stream API
		List<Student> list = studentList.stream().filter(st -> st.getRoll() == roll).toList();
		if(list.size() == 0)
			return new ResponseEntity<Student>(new Student(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<Student>(list.get(0), HttpStatus.OK);
	}
	
	/**
	 * Output for http://localhost:8080/students/1
	 * {"roll": 1, "name": "ABC", "marks": 94}
	 */
	
	
	//This method is to find students for a marks range
	//GET http://localhost:8080/searchbymarksrange?start=75&end=87
	@GetMapping("/searchbymarksrange")
	public ResponseEntity<List<Student>> getStudentListByMarkRange(@RequestParam Integer start, @RequestParam Integer end){//is same as
	//public List<Student> getStudentListByMarkRange(Integer start, Integer end)
		List<Student> list = studentList.stream().filter(st -> st.getMarks() >= start && st.getMarks() <= end).toList();
		if(list.size() == 0)
			return new ResponseEntity<List<Student>>(new ArrayList<Student>(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
	
	/**
	 * For http://localhost:8080/searchbymarksrange?start=75&end=87
	 * Output
	 * [{ "roll": 3, "name": "CDE", "marks": 85 },
	 *  { "roll": 4, "name": "DEF", "marks": 80 }]
	 */
	
	
	//This method is to add the Student
	//POST http://localhost:8080/students
	//{"roll":"7","name":"GHI","marks":"65"}
	@PostMapping("/students")
	public ResponseEntity<String> registerStudent(@RequestBody Student st) {
		//just for checking if the parameter o taking information from request body
		//System.out.println(st.getRoll() + ", " + st.getName() + ", " + st.getMarks());
		studentList.add(st);
		return new ResponseEntity<String>("Student added Successfully", HttpStatus.CREATED);
	}
	
	/**
	 * Output : Student added Successfully
	 */
	
	//This will change the details of the student on the behalf of roll number
	//URL: PUT http://localhost:8080/students
	//{"roll": "1", "name": "XYZ", "marks": "44"}
	@PutMapping("/students")
	public ResponseEntity<String> updateStudent(@RequestBody Student st) {
		//get the student by roll number
		Student student = studentList.stream().filter(s -> s.getRoll() == st.getRoll()).toList().get(0);
		
		//update the student details
		student.setName(st.getName());
		student.setMarks(st.getMarks());
		
		return new ResponseEntity<String>("Student updated successfully", HttpStatus.OK);
	}
	
	/**
	 * GET http://localhost:8080/students/1
	 * Output: {"roll":1,"name":"ABC","marks":94}
	 * 
	 * PUT http://localhost:8080/students
	 * {"roll": "1", "name": "xyz", "marks": 99}
	 * Student updated successfully
	 * 
	 * GET http://localhost:8080/students/1
	 * Output: {"roll":1,"name":"xyz","marks":99}
	 */
	
	//This will change the details of the student on the behalf of roll number
	//URL: PATCH http://localhost:8080/students/{roll}
	//{"name": "STU", "marks": 85} or;
	//{"name": "STU"} or;
	//{"marks": 85}
	@PatchMapping("/students/{roll}")
	public ResponseEntity<String> updateStudentDetails(@PathVariable("roll") Integer rollNumber, @RequestBody Map<String, String> map) {
		//get the student by roll number
		Student student = studentList.stream().filter(s -> s.getRoll() == rollNumber).toList().get(0);
		//code to update the name
		if(map.get("name") != null) {
			//you are here means the request body contains updated name
			student.setName(map.get("name"));
		}
		//code to update the marks
		if(map.get("marks") != null) {
			//you are here means the request body contains updated marks
			student.setMarks(Integer.valueOf(map.get("marks")));
		}
		
		return new ResponseEntity<String>("Student updated successfully", HttpStatus.OK);
	}
	
	/**
	 * GET http://localhost:8080/students/1
	 * Output: {"roll":1,"name":"xyz","marks":99}
	 * 
	 * PATCH http://localhost:8080/students/1
	 * {"name": "ABC", "marks": 94}
	 * Output: Student updated successfully
	 * 
	 * GET http://localhost:8080/students/1
	 * Output: {"roll":1,"name":"ABC","marks":94}
	 * 
	 * PATCH http://localhost:8080/students/1
	 * {"name": "PQR"}
	 * Output: Student updated successfully 
	 * 
	 * GET http://localhost:8080/students/1
	 * Output: {"roll":1,"name":"PQR","marks":94}
	 * 
	 * PATCH http://localhost:8080/students/1
	 * {"marks": 100}
	 * Output: Student updated successfully 
	 * 
	 * GET http://localhost:8080/students/1
	 * {"roll":1,"name":"PQR","marks":100}
	 */
	
	//This will delete the student on the behalf of roll number
	//URL: DELETE http://localhost:8080/students/{roll}
	@DeleteMapping("/students/{roll}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer roll) {
		//get the student by roll number
		Student student = studentList.stream().filter(s -> s.getRoll() == roll).toList().get(0);
		studentList.remove(student);
		
		return new ResponseEntity<String>("Student deleted successfully of roll number " + roll, HttpStatus.OK);
	}
	
	/**
	 * GET http://localhost:8080/students/1
	 * Output: {"roll":1,"name":"xyz","marks":99}
	 * 
	 * DELETE http://localhost:8080/students/1
	 * Output: Student deleted successfully of roll number 1
	 * 
	 * GET http://localhost:8080/students
	 * Output
	 * [ {"roll":2,"name":"BCD","marks":90},
	 *   {"roll":3,"name":"CDE","marks":85},
	 *   {"roll":4,"name":"DEF","marks":80},
	 *   {"roll":5,"name":"EFG","marks":72},
	 *   {"roll":6,"name":"FGH","marks":65}
	 * ]
	 */
	
	
}
