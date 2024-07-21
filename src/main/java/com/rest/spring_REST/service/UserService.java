package com.rest.spring_REST.service;

import java.util.List;
import java.util.Optional;

import com.rest.spring_REST.entites.User;


public interface UserService {
	
	public List<User> getAllUsers();
	public  Optional<User> getUserByID(String userId);
	public User createUser(User user);

}
