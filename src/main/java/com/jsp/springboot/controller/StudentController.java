package com.jsp.springboot.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.springboot.entity.Student;
import com.jsp.springboot.exception.ResourceNotFoundException;
import com.jsp.springboot.service.StudentService;

/**
 * StudentController class is responsible for handling incoming HTTP requests and generating appropriate responses
 * @RestController annotation It provides a easy way to annotate a class which is particularly  designed to handle 
      RESTful API requests and return the response in a suitable format like JSON for RESTful APIs.
 * the @Autowired annotation is used to inject an instance of the StudentRepository into a class.
	    StudentRepository interface defined in application, the @Autowired annotation ensures that an
	    appropriate implementation of the StudentRepository is instantiated and injected into the StudentController.
*/
	     
@RestController 
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	/** This getStudentList method will display the student details based on the filter */
	@PostMapping("/getStudentList")
	public Page<Student> getStudentList(@RequestBody Map<String, Object> queryFilters, @RequestParam int pageNumber, @RequestParam int pageSize, @RequestParam String sortBy)
	{
		return studentService.getStudentList(queryFilters, pageNumber, pageSize, sortBy);
	}
	
	
	/**This saveDetails method where we have to provide the data in JASON format in Postman tool it will get stored in database*/
	@PostMapping("student")
	public Student saveDetails(@RequestBody Student student)
	{
		return studentService.saveDetails(student);
	}
	
	/** This updateStudent method is used to update the existing student data  which is present in database for that we have provide ID */
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer id,@RequestBody Student student) {
		try {
			return studentService.updateStudent(id, student);
		} catch (ResourceNotFoundException e) {
			System.err.println(String.format("Update student failed with error: %s", e.getMessage()));
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) { 
			System.err.println(String.format("Update student failed with unknown error: %s", e.getMessage()));
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	/** deleteStudent method is used to delete the existing data from database based on the ID*/
	@DeleteMapping("/student/{id}")
	public ResponseEntity <Map <String,Boolean>> deleteStudent(@PathVariable Integer id)
	{
		try {
			return studentService.deleteStudent(id);
		} catch (ResourceNotFoundException e) {
			System.err.println(String.format("Delete student failed with error: %s", e.getMessage()));
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) { 
			System.err.println(String.format("Delete student failed with unknown error: %s", e.getMessage()));
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
