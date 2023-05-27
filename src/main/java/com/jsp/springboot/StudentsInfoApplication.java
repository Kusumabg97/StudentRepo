package com.jsp.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication /*this annotation is used for auto-configuration based on 
classpath,properties and also enables component scanning*/


public class StudentsInfoApplication {  // it is the main class of the string boot application

	public static void main(String[] args) { // it is the entry point of the application
		SpringApplication.run(StudentsInfoApplication.class, args);//when we run this class, it starts the Spring Boot application by calling SpringApplication.run()
	}

}
// After that it will start scanning the component