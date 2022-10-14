package com.knimbus.service;

import java.util.HashMap;
import java.util.List;

import com.knimbus.model.User;

public interface IUserService {
	
	 void createUser(User user);
	 User updateUser(User user);
	 User getUser(int userId);
	 User getUserByEmailId(String email);
	 void deleteUser(int userId);
	 List<User> getAllUser();
	 String loginUser(User user);
     String resetPassword(User user);
	HashMap<String, Object> isDefaultPassword(User user);

	

}
