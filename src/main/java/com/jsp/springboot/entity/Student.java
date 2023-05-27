package com.jsp.springboot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity //  an entity class represents a persistent data entity used to map to a database table.
@Table(name="student_info") // table name 
public class Student implements Serializable {
	
	@Id// used for primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // automatically generate the id from 1
	private Integer id;
	
	
	@Column(name="Student_Name") //@Column annotation we can provide the name for the table columns
	private String name;
	
	@Column(name="S_age")
	private Integer age;
	
	@Column(name="Total_marks")
	private Integer totalmarks;
	
	
	public boolean update(Student updatedStudentDetails) {
		
		if (updatedStudentDetails.getName() != null) {
			name = updatedStudentDetails.getName();
		}
		
		if(updatedStudentDetails.getAge() !=null)
		{
			age=updatedStudentDetails.getAge();
		}
		
		if (updatedStudentDetails.getTotalmarks() !=null)
		{
			totalmarks=updatedStudentDetails.getTotalmarks();
		}
		return true;
	}

	
}
