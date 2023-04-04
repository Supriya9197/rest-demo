package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepo; 
	
	@Override
	@Transactional
	public Object saveUser(User user) {
		return userRepo.save(user);
	}

	@Transactional(readOnly = true)
	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findById(long id) {
		return userRepo.findById(id);
	}

}
