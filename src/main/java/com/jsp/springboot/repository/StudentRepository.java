package com.jsp.springboot.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.jsp.springboot.entity.Student;


/**
 *  A repository class provides It acts as an intermediary between your application and the underlying
 *    database and provides a set of methods to perform CRUD operations on the data.
 *     
 * */
@Repository 
public interface  StudentRepository extends JpaRepository<Student, Integer> , JpaSpecificationExecutor<Student>{
	
	/** This method returns a list of students whose name matches with the given input*/
	@Query(nativeQuery=true,value="SELECT * FROM  student_info  WHERE student_name=:name")
	List<Student> findByName(@Param("name") String name);
	
	
	Page<Student> findAll(Specification<Student> spec, Pageable pageable);
	
}
