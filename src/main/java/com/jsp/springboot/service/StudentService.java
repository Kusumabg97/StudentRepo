package com.jsp.springboot.service;

import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.jsp.springboot.entity.Student;
import com.jsp.springboot.entity.StudentSpecification;
import com.jsp.springboot.exception.ResourceNotFoundException;
import com.jsp.springboot.repository.StudentRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * This class implements the business logic of the StudentsInfoApplication. 
 * */
@AllArgsConstructor
@Service
public class StudentService {
	
	@Autowired
	private final StudentRepository studentRepository;
    
    public Student saveDetails(Student student) {
		return studentRepository.save(student);
	}
    
    public ResponseEntity<Student> updateStudent(Integer id, Student updatedStudentDetails) {
		
		Student studentDetails = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student data not found" + updatedStudentDetails.getId()));
	
		studentDetails.update(updatedStudentDetails);
		return ResponseEntity.ok(studentRepository.save(studentDetails));
	}
    
    
    public ResponseEntity <Map <String, Boolean>> deleteStudent(Integer id)
	{
		Student stu = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student data not found" +id));
		
		studentRepository.delete(stu);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
    public Page<Student> getStudentList(Map<String, Object> queryFilters, int pageNumber, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));

      return studentRepository.findAll(StudentSpecification.getQuery(queryFilters), pageable); 
    	
    }

    public Page<Student> getAllStudents(int pageNumber, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return studentRepository.findAll(pageable);
    }
    
    

}

