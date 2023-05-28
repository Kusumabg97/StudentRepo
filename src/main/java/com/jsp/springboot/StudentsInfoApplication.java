package com.jsp.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * This is the main class of the string boot application
 * entry point of the application
 * when we run this class, it starts the Spring Boot application by calling SpringApplication.run()
	
 * @SpringBootApplication
 * this annotation is used for auto-configuration based on 
     classpath,properties and also enables component scanning
 * */

@SpringBootApplication 
public class StudentsInfoApplication { 
	public static void main(String[] args) {
		SpringApplication.run(StudentsInfoApplication.class, args);
	}
}
