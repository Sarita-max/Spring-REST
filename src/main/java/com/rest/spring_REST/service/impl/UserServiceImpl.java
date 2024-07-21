package com.rest.spring_REST.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rest.spring_REST.entites.User;
import com.rest.spring_REST.repository.UserRepository;
import com.rest.spring_REST.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	//@Autowired
	//private RestTemplate restTemplate;
	
	private Logger logger=LoggerFactory.getLogger(UserService.class);
	
	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public  Optional<User> getUserByID(String userId) {
		
		 Optional<User> user=userRepository.findById(userId);
				//.orElseThrow(()-> new ResourceNotFoundException("User with given ID is not found on server! :" + userId));
		 
		 /*String ratingurl="http://RATING_MICROSERVICE/rating/users/" + user.getUserId();
		 Rating[] ratings=restTemplate.getForObject(ratingurl, Rating[].class);
		 
		 logger.info("{} ", ratings);
		 
		 List<Rating> ratingList=Arrays.stream(ratings).collect(Collectors.toList());
		 ratingList.stream().forEach(rating->{
			 Hotel hotel=restTemplate.getForObject("http://HOTEL_MICROSERVICE/hotels/" + rating.getHotelId(), Hotel.class);
			 rating.setHotel(hotel);
		 });
		 
		 user.setRating(ratingList);*/
		 
		 
		 
		 return user;
	}

	@Override
	public User createUser(User user) {
		String randomId=UUID.randomUUID().toString();
		user.setUserId(randomId);
		return userRepository.save(user);
	}




}

