package com.example.register_login_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.register_login_demo.entity.User;
import com.example.register_login_demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllusers()
	{	
		return userRepository.findAll();
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public Optional<User> getUserByID(Long userID) {
		return userRepository.findById(userID);
	}

	@Override
	public User updateUser(User user, Long userID) {
		Optional<User> oldUser=userRepository.findById(userID);
		if(oldUser.get().getUserId().equals(userID)) {
			user.setUserId(userID);
			userRepository.save(user);
		}
		return user;
	}

	@Override
	public boolean deleteUser(Long userID) {
		Optional<User> oldUser=userRepository.findById(userID);
		if(oldUser.get().getUserId().equals(userID)) {
			userRepository.deleteById(userID);
			return true;
		}
		return false;
	}

	@Override
	public Page<User> getUsers(int page, int size, String sortUser) {
		Pageable paging = PageRequest.of(page,size,Sort.by(sortUser));
		return userRepository.findAll(paging);
	}

}
