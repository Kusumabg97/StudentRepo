package com.jsp.springboot.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.springboot.entity.Student;
import com.jsp.springboot.exception.ResourceNotFoundException;
import com.jsp.springboot.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/student")
	public List<Student> getAllStudent()
	{
		return studentRepository.findAll();
	}
	
	@PostMapping("student")
	public Student saveDetails(@RequestBody Student student)
	{
		return studentRepository.save(student);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id)
	{
		Student student = studentRepository.findById(id).
		orElseThrow(() -> new ResourceNotFoundException("student  not exist with id: "+id));
		return ResponseEntity.ok(student);
	}
	
	@GetMapping("/studentname/{name}")
	public List<Student> getStudentByName(@PathVariable String name)
	{
		return studentRepository.findByName(name);
	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer id,@RequestBody Student student) {
		
		Student stu = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student data not found" +id));
		
		stu.setName(student.getName());
		stu.setAge(student.getAge());
		stu.setTotalmarks(student.getTotalmarks());
		
		Student save = studentRepository.save(stu);
		return ResponseEntity.ok(save);
	}
	
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity <Map <String, Boolean>> deleteStudent(@PathVariable Integer id)
	{
		Student stu = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student data not found" +id));
		
		studentRepository.delete(stu);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}

	
}
