package com.aditya.service;

import com.aditya.exception.UserException;
import com.aditya.model.User;

public interface UserService {

	public User findUserById(Long userId) throws UserException;
	
	public User findUserProfileByJWT(String jwt) throws UserException;
}
