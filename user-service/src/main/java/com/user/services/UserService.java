package com.user.services;

import java.util.List;

import com.user.entities.User;

public interface UserService {
	
//	User services
	
//	Create 
	User saveUser(User user);
	
//	Get all user
	List<User> getAllUser();
	
//	Get single user of given UserId
	User getUser(String userId);
	
//	TODO - update
//	TODO - delete

}
