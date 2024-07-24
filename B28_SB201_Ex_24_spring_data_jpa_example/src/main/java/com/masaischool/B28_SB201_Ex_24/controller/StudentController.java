package com.masaischool.B28_SB201_Ex_24.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.B28_SB201_Ex_24.dto.StudentDTO;
import com.masaischool.B28_SB201_Ex_24.entity.Student;
import com.masaischool.B28_SB201_Ex_24.service.StudentService;

@RestController
public class StudentController {
	private StudentService studentService;
	
	//public StudentController(@Autowired StudentService studentService) {
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student st) {
		return new ResponseEntity<Student>(studentService.addStudent(st), HttpStatus.CREATED);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> viewAllStudent() {
		return new ResponseEntity<List<Student>>(studentService.viewAllStudent(), HttpStatus.OK);
	}
	
	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> viewStudentByRoll(@PathVariable Integer roll) {
		return new ResponseEntity<Student>(studentService.viewStudentByRoll(roll), HttpStatus.OK);
	}
	
	@GetMapping("/studentsbyname/{name}")
	public ResponseEntity<Student> viewStudentByName(@PathVariable String name) {
		return new ResponseEntity<Student>(studentService.viewStudentByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/studentsbymarks/{marks}")
	public ResponseEntity<List<String>> viewStudentByName(@PathVariable Integer marks) {
		return new ResponseEntity<List<String>>(studentService.viewStudentByMarks(marks), HttpStatus.OK);
	}
	
	@GetMapping("/studentsbyrollmarks/{roll}/{marks}")
	public ResponseEntity<List<Student>> viewStudentByRollorMarks(@PathVariable Integer roll, @PathVariable Integer marks) {
		return new ResponseEntity<List<Student>>(studentService.viewStudentByRollGreaterThanOrMarks(roll, marks) , HttpStatus.OK);
	}
	
	@GetMapping("/studentsbymarksrange/{begin}/{end}")
	public ResponseEntity<List<Student>> viewStudentByMarksRange(@PathVariable Integer begin, @PathVariable Integer end) {
		return new ResponseEntity<List<Student>>(studentService.viewStudentByMarksRange(begin, end) , HttpStatus.OK);
	}
	
	@GetMapping("/studentsbyrollnumber/{roll}")
	public ResponseEntity<List<StudentDTO>> getDetailsByRollNumberMore(@PathVariable Integer roll){
		return new ResponseEntity<List<StudentDTO>>(studentService.getDetailsByRollNumberMore(roll), HttpStatus.OK);
	}
	
	@GetMapping("/studentsbynq")
	public ResponseEntity<List<String>> viewAllStudentByNQ(){
		return new ResponseEntity<List<String>>(studentService.viewAllStudentByNQ() , HttpStatus.OK);
	}
	
	@GetMapping("/getfivebyname")
	public ResponseEntity<List<Student>> getTop5ByOrderByNameDesc(){
		return new ResponseEntity<List<Student>>(studentService.getTop5ByOrderByNameDesc() , HttpStatus.OK);
	}
	
	@GetMapping("/getthreebymarks/{marks}")
	public ResponseEntity<List<Student>> getTop3ByMarksGreaterThan(@PathVariable Integer marks){
		return new ResponseEntity<List<Student>>(studentService.getTop3ByMarksGreaterThan(marks), HttpStatus.OK);
	}
	
	@GetMapping("/getbycustomersortorders/{fieldOne}/{directionOne}/{fieldTwo}/{directionTwo}")
	public ResponseEntity<List<Student>> getByCustomerSortOrders(@PathVariable String fieldOne, @PathVariable String directionOne, @PathVariable String fieldTwo, @PathVariable String directionTwo){
		return new ResponseEntity<List<Student>>(studentService.getByCustomerSortOrders(fieldOne, directionOne, fieldTwo, directionTwo), HttpStatus.OK);
	}
	
	@GetMapping("/getstudentspagewise/{page}/{size}")
	public ResponseEntity<List<Student>> getStudentsPageWise(@PathVariable int page, @PathVariable int size){
		return new ResponseEntity<List<Student>>(studentService.getStudentsPageWise(page, size), HttpStatus.OK);
	}
	
	@PatchMapping("/updatenameofstudent/{roll}/{name}")
	public ResponseEntity<Integer> updateNameUsingRoll(@PathVariable Integer roll, @PathVariable String name){
		return new ResponseEntity<Integer>(studentService.updateNameUsingRoll(name, roll), HttpStatus.OK);
	}
	
	@PatchMapping("/students/{roll}/{marks}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer roll, @PathVariable Integer marks) {
		return new ResponseEntity<Student>(studentService.updateStudent(roll, marks), HttpStatus.OK);
	}
	
	@DeleteMapping("/students/{roll}")
	public ResponseEntity<String> deleteStudentByRoll(@PathVariable Integer roll){
		String message = studentService.deleteStudentByRoll(roll);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
}
