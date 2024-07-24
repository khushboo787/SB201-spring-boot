package com.masaischool.B28_SB201_Ex_24.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masaischool.B28_SB201_Ex_24.dto.StudentDTO;
import com.masaischool.B28_SB201_Ex_24.entity.Student;

import jakarta.transaction.Transactional;

@Repository	//It is here optional 
public interface StudentRepository extends JpaRepository<Student, Integer> {
	//we can define method by our own demand also
	Optional<Student> findByName(String name);	//SELECT S FROM Student S WHERE S.name = :name
	
	List<Student> findByRollGreaterThanOrMarksLessThanEqual(Integer roll, Integer marks);
	//WHERE S FROM Student S WHERE S.roll > :roll OR S.marks <= :marks
	
	//The above approach is suitable for the simple query generation
	//To create method with complex queries, we have to use @Query annotation, now method name is significants
	
	@Query("SELECT S FROM Student S WHERE S.marks BETWEEN :begin AND :end")	//named parameter
	List<Student> abc(@Param("begin") Integer begin, @Param("end") Integer end);
	
	@Query("SELECT S.name FROM Student S WHERE S.marks > ?1")	//positional parameter
	List<String> getNameByMarks(Integer marks);
	
	//An example of executing the native query
	@Query(value = "SELECT * FROM st", nativeQuery = true)
	List<String> getAllStudentByNativeQuery();
	
	@Query("SELECT new com.masaischool.B28_SB201_Ex_24.dto.StudentDTO(S.name, S.marks) FROM Student S WHERE S.roll > ?1")	//positional parameter
	List<StudentDTO> getDetailsByRollNumberMore(Integer roll);
	
	@Transactional
	@Modifying
	@Query("UPDATE Student S SET S.name = :name WHERE S.roll = :roll")	//named parameter
	int updateNameUsingRoll(@Param("name") String name, @Param("roll") Integer roll);
	
	public List<Student> findTop5ByOrderByNameDesc();
	
	public List<Student> findTop3ByMarksGreaterThan(Integer marks);
}

//No need to write implementing class of StudentRepository interface
//because Spring data JPA will create implementing class of this interface by itself
//The object of implementing class will be registered to the Spring container so it can be used with auto-wiring