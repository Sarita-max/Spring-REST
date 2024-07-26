package com.example.register_login_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.register_login_demo.entity.User;

public interface UserService {
	public List<User> getAllusers();
	public User addUser(User user);
	public Optional<User> getUserByID(Long userID);
	public User updateUser(User user,Long userID);
	public boolean deleteUser(Long userID);
	public Page<User> getUsers(int page, int size, String sortUser);
}
