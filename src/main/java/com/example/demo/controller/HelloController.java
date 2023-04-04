package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;

@RestController
public class HelloController {

	@Value("${message}") //spel
	private String message;
	
	@GetMapping("/hello")
	public String greetings() throws ResourceNotFoundException {
		return message;
	}
	
}
