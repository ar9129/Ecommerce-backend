package com.aditya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditya.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByEmail(String email);

}
