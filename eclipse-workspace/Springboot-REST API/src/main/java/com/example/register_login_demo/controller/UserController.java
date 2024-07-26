package com.example.register_login_demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.register_login_demo.entity.User;
import com.example.register_login_demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllusers(){
		
		List<User> user = userService.getAllusers();
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@GetMapping("/{userID}")
	public ResponseEntity<Optional<User>> getUserByID(@PathVariable Long userID){
		
		Optional<User> user = userService.getUserByID(userID);
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@GetMapping("/usr")
	public Page<User> getUsers(@RequestParam(defaultValue = "0") int page,
							   @RequestParam(defaultValue = "10") int size,
							   @RequestParam(defaultValue = "id") String sortUser){
		return userService.getUsers(page,size,sortUser);
	}
	
	@PostMapping("/")
	public ResponseEntity<User> addUser(@RequestBody User user ){
		
		User users = userService.addUser(user);
		
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@PutMapping("/{userID}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long userID ){
		
		User users = userService.updateUser(user,userID);
		
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@DeleteMapping("/{userID}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userID){
		boolean isDeleted=userService.deleteUser(userID);
		if(isDeleted)
			return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
		
	}

}
