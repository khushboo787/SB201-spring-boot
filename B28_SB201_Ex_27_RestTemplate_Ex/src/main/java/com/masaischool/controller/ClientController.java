package com.masaischool.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.masaischool.model.Student;

@RestController
public class ClientController {
	@GetMapping("/get_student")
	public ResponseEntity<List<Student>> get_student(){
		//Create an object of RestTemplate class
		RestTemplate restTeamplate = new RestTemplate();
		
		//Hit the URL to get list of students
		List<Student> student = restTeamplate.getForObject("http://localhost:9090/students", List.class);
		
		return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
		
		//The above 2 lines can be written in a single statement as follow-
		//return restTeamplate.getForEntity("http://localhost:9090/students", Student.class);
	}
	
	@PostMapping("/save_student")
	public ResponseEntity<Student> post_student(@RequestBody Student student){
		//Create an object of RestTemplate class
		RestTemplate restTeamplate = new RestTemplate();
		
		//Hit the using the Post request
		Student st = restTeamplate.postForObject("http://localhost:9090/students", student, Student.class);
		
		return new ResponseEntity<Student>(st, HttpStatus.OK);
		
		//The above 2 lines can be written in a single statement as follow-
		//return restTeamplate.postForEntity("http://localhost:9090/students", student, Student.class);
	}
	
}
