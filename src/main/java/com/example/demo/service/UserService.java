package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;

public interface UserService {

	Object saveUser(User user);
	
	List<User> getAllUsers();
	
	Optional<User> findById(long id);
	
}
