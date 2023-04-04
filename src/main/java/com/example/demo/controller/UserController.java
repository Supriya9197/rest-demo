package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(@RequestHeader("x-api-version")String version){
		List<User> userList = userService.getAllUsers();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	
	@GetMapping("/v1/users/{id}")
	public ResponseEntity<?>getUserById(@PathVariable("id")long id) throws ResourceNotFoundException {
		 Optional<User> user =userService.findById(id);
		 if(!user.isPresent()) {
			 throw new ResourceNotFoundException("user with given id not found");
		 }
		 return new ResponseEntity<>(user,HttpStatus.OK);
	}

	@PostMapping("/v1/users")
	public ResponseEntity<?> saveUser(@RequestBody User user){
		Object userDetails =  userService.saveUser(user);
		return new ResponseEntity<String>("user added successfully",HttpStatus.CREATED);
	}
}
