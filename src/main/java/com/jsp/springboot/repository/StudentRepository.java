package com.jsp.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jsp.springboot.entity.Student;

@Repository
public interface  StudentRepository extends JpaRepository<Student, Integer>{
	List<Student> findByName(String name);
	//@Query(" select  from Student  where name=:name")
	
	
	
	
	

}
