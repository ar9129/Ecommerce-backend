package com.aditya.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aditya.config.JwtProvider;
import com.aditya.exception.UserException;
import com.aditya.model.User;
import com.aditya.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	
	private UserRepository userRepository;
	private JwtProvider jwtProvider;
	
	public UserServiceImplementation(UserRepository userRepository, JwtProvider jwtProvider) {
		this.userRepository=userRepository;
		this.jwtProvider=jwtProvider;
		
	}

	@Override
	public User findUserById(Long userId) throws UserException {
		
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
		
		throw new UserException("User not found with ID: "+userId);
	}

	@Override
	public User findUserProfileByJWT(String jwt) throws UserException {
		
		String email = jwtProvider.getEmailFromToken(jwt);
		User user = userRepository.findByEmail(email);
		if(user==null) {
			throw new UserException("User not found with Email: "+email);
		}
		return user;
	}

}