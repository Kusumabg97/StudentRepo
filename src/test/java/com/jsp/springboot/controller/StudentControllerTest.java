package com.jsp.springboot.controller;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.jsp.springboot.service.StudentService;
import com.jsp.springboot.entity.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@SpringBootTest
public class StudentControllerTest {
	
	@MockBean StudentService mockStudentService; 
	
	@InjectMocks private StudentController studentController; 
	
	@BeforeEach
	public void setup() {
	     MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void GIVEN_valid_student_details_WHEN_save_THEN_add_student() {
		//GIVEN 
		Student newStudent = new Student(1, "test", 20, 99); 
		when(mockStudentService.saveDetails(newStudent)).thenReturn(newStudent); 
		
		//WHEN 
		Student result = studentController.saveDetails(newStudent); 
		
		//THEN
		assertEquals(result.getName(), "test");
		assertEquals(result.getAge(), 20); 

	}
	
	@Test
	public void GIVEN_valid_student_details_WHEN_updateStudent_THEN_update_studentDetails()
	{
		//Given
		
		Student student = new Student();
		student.setName("testdata");
		student.setAge(22);
		student.setTotalmarks(50);
		
		Student expectedResponse = new Student(1, "testdata", 22, 50);
		when(mockStudentService.updateStudent(1, student)).thenReturn(ResponseEntity.ok(expectedResponse));
		
		//When
		
		ResponseEntity<Student> result = studentController.updateStudent(1,student);
		
		//THEN
		
		assertEquals(result.getBody(), expectedResponse);

	}
}
