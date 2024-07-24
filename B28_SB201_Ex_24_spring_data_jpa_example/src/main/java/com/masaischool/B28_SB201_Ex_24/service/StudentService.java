package com.masaischool.B28_SB201_Ex_24.service;

import java.util.List;

import com.masaischool.B28_SB201_Ex_24.dto.StudentDTO;
import com.masaischool.B28_SB201_Ex_24.entity.Student;

public interface StudentService {
	/**
	 * This method is to add a Student
	 * @param st Student object containing details of the Student to be saved
	 * @return: Student object that contains the saved details (It will have value for roll also)
	 */
	public Student addStudent(Student st); 
	
	/**
	 * This method is to get Student details by roll
	 * @param roll: Integer value for the roll number
	 * @return: Student object for this roll number
	 */
	public Student viewStudentByRoll(Integer roll);
	
	/**
	 * This method is to get Student details by name
	 * @param name: String value for the name
	 * @return: Student object for this name
	 */
	public Student viewStudentByName(String name);
	
	public List<Student> viewStudentByMarksRange(Integer start, Integer end);
	
	public List<String> viewStudentByMarks(Integer marks);
	
	public List<String> viewAllStudentByNQ();
	
	/**
	 * 
	 * @param roll
	 * @param marks
	 * @return
	 */
	public List<Student> viewStudentByRollGreaterThanOrMarks(Integer roll, Integer marks);
	
	/**
	 * This method is to get list of all students
	 * @return: List of Students
	 */
	public List<Student> viewAllStudent();
	
	public List<StudentDTO> getDetailsByRollNumberMore(Integer roll);
	
	public List<Student> getTop5ByOrderByNameDesc();
	
	public List<Student> getTop3ByMarksGreaterThan(Integer marks);
	
	public List<Student> getByCustomerSortOrders(String fieldOne, String directionOne, String fieldTwo, String directionTwo);
	
	public List<Student> getStudentsPageWise(int page, int size);
	
	int updateNameUsingRoll(String name, Integer roll);
	/**
	 * This method is to update the marks of student based on the roll
	 * @param roll: Integer value for the roll number
	 * @param marks: Integer value for the updated marks
	 * @return: Student object that is updated one
	 */
	public Student updateStudent(Integer roll, Integer marks);
	
	/**
	 * This method is to delete a student by roll number
	 * @param roll: Integer value, roll number of the Student to be deleted
	 * @return: String value which is a success message
	 */
	public String deleteStudentByRoll(Integer roll);
}
