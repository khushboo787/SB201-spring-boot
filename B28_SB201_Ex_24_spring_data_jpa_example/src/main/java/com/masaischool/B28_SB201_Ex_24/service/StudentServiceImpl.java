package com.masaischool.B28_SB201_Ex_24.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masaischool.B28_SB201_Ex_24.dto.StudentDTO;
import com.masaischool.B28_SB201_Ex_24.entity.Student;
import com.masaischool.B28_SB201_Ex_24.exception.StudentNotFoundException;
import com.masaischool.B28_SB201_Ex_24.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	private StudentRepository studentRepository;
	
	//@Autowired	//optional it is here because
	//If a class has only one constructor with a single parameter then use of @Autowire is optional
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
		System.out.println("The name of implementing class is : " + this.studentRepository.getClass().getName());
		//The name of implementing class is : jdk.proxy4.$Proxy107
		//Proxy class: A class that is generated dynamically
	}

	@Override
	public Student addStudent(Student st) {
		return studentRepository.save(st);
	}

	@Override
	public Student viewStudentByRoll(Integer roll) {
		Optional<Student> optional = studentRepository.findById(roll);
		/*
		 * if(!optional.isPresent()) //you are here means student not exist with the
		 * given roll throw new
		 * StudentNotFoundException("No Student exists for given roll " + roll);
		 * 
		 * //you are here means student with the given roll exists return
		 * optional.get();
		 */
		
		//The above code can be completed in just one line as below
		return optional.orElseThrow(() -> new StudentNotFoundException("No Student exists for given roll " + roll));
		//orElseThrow method
		//1. If non null value is available in the optional object then the non-null object will be returned
		//2. If null value is available in the optional object then exception will be thrown
	}
	
	@Override
	public Student viewStudentByName(String name) {
		Optional<Student> optional = studentRepository.findByName(name);
		return optional.orElseThrow(() -> new StudentNotFoundException("No Student exists for given name " + name));
	}
	
	@Override
	public List<Student> viewStudentByRollGreaterThanOrMarks(Integer roll, Integer marks) {
		return studentRepository.findByRollGreaterThanOrMarksLessThanEqual(roll, marks);
	}

	@Override
	public List<Student> viewAllStudent() {
		return studentRepository.findAll();
	}
	
	@Override
	public List<Student> viewStudentByMarksRange(Integer start, Integer end) {
		return studentRepository.abc(start, end);
	}
	
	@Override
	public List<String> viewStudentByMarks(Integer marks){
		return studentRepository.getNameByMarks(marks);
	}
	
	@Override
	public List<StudentDTO> getDetailsByRollNumberMore(Integer roll){
		return studentRepository.getDetailsByRollNumberMore(roll);
	}
	
	@Override
	public List<String> viewAllStudentByNQ(){
		return studentRepository.getAllStudentByNativeQuery();
	}
	
	@Override
	public List<Student> getTop5ByOrderByNameDesc(){
		return studentRepository.findTop5ByOrderByNameDesc();
	}
	
	@Override
	public List<Student> getTop3ByMarksGreaterThan(Integer marks){
		return studentRepository.findTop3ByMarksGreaterThan(marks);
	}
	
	@Override
	public List<Student> getByCustomerSortOrders(String fieldOne, String directionOne, String fieldTwo, String directionTwo){
		//Create a reference variable of Sort
		Sort sort = null;
		if(directionOne.equalsIgnoreCase("asc"))
			sort = Sort.by(fieldOne);
		else
			sort = Sort.by(Sort.Direction.DESC, fieldOne);
		
		if(directionTwo.equalsIgnoreCase("asc"))
			sort = sort.and(Sort.by(fieldTwo));
		else
			sort = sort.and(Sort.by(Sort.Direction.DESC, fieldTwo));
		
		return studentRepository.findAll(sort);
	}
	
	@Override
	public List<Student> getStudentsPageWise(int page, int size){
		//Create an object of PageRequest
		Pageable pg = PageRequest.of(page, size);
		
		Page<Student> pageStudent = studentRepository.findAll(pg);
		
		if(!pageStudent.hasContent()) {
			throw new StudentNotFoundException("No Student records for page " + page);
		}
		
		return pageStudent.getContent();
	}
	
	@Override
	public int updateNameUsingRoll(String name, Integer roll) {
		return studentRepository.updateNameUsingRoll(name, roll);
	}

	@Override
	public Student updateStudent(Integer roll, Integer marks) {
		Student student = studentRepository.findById(roll).orElseThrow(
				() -> new StudentNotFoundException("No Student exists for given roll " + roll)
			);
		
		//you are here means student exists for given roll number
		//update marks of student in the Entity class object
		student.setMarks(marks);
		//call save method to update marks in the database
		return studentRepository.save(student);
	}

	@Override
	public String deleteStudentByRoll(Integer roll) {
		Student student = studentRepository.findById(roll).orElseThrow(
				() -> new StudentNotFoundException("No Student exists for given roll " + roll)
			);
		//you are here means student exists for given roll number
		studentRepository.delete(student);
		return "Student deleted successfully";
	}
}