package com.rest.spring_REST.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.spring_REST.entites.User;
import com.rest.spring_REST.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// Get all users
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users=userService.getAllUsers();
		return ResponseEntity.ok(users);
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<Optional<User>> getUserByID(@PathVariable String userId){
		
		return ResponseEntity.ok(userService.getUserByID(userId));
	}
	
	// Save user
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User user1=userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1); 
		
	}

}
