package com.itpm.service;

import java.util.ArrayList;

import com.itpm.model.User;
import java.util.logging.Logger;

public interface IUserService {
	
		public static final Logger log = Logger.getLogger(IUserService.class.getName());
		
		public void addUser(User user);
		
		public User getUserByID(String UserId);
		
		public ArrayList<User> getUsers();
		
		public User updateUser(String UserId, User user);
		
		public void removeUser(String UserId);
		
}
