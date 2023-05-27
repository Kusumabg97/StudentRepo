package com.jsp.springboot.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

/**
 * This class provides the Specification to perform filtered queries on the student_info table. 
 * */
public class StudentSpecification {

    
	/**
	 * This method constructs the specification based on the input filters. 
	 * */
    public static Specification<Student> getQuery(Map<String, Object> filter)
	{
		return (root, query, criteriaBuilder) -> {
        List<Predicate> predicates = new ArrayList<>();

				
		// name 
		if (filter.containsKey("name")) {
			predicates.add(criteriaBuilder.like(root.get("name"), "%" + filter.get("name") + "%"));
			
		}
		
		// age
		if ( filter.containsKey("age")) {
			predicates.add(criteriaBuilder.equal(root.get("age"), filter.get("age")));
		}
 		
		// total marks 
		if ( filter.containsKey("totalMarks")) {
			predicates.add(criteriaBuilder.equal(root.get("totalmarks"), filter.get("totalmarks")));
		}
		  return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
 		
	} 
	
}
