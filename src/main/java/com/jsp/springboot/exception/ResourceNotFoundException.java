package com.jsp.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class which provides the  custom exception class named ResourceNotFoundException */


@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

private static final long serialVersionUID = 1L;
	
/**
 * By creating this custom exception class, we can throw and handle
 *     ResourceNotFoundException in this application,*/
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}
