package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ExceptionResponse handleResourceNotFound(final ResourceNotFoundException exception,final HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(exception.getMessage());
		System.out.println(exception.getMessage());
		response.callerURL(request.getRequestURI());
		return response;
	}
}
