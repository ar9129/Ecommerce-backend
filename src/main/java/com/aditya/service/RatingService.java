package com.aditya.service;

import java.util.List;

import com.aditya.exception.ProductException;
import com.aditya.model.Rating;
import com.aditya.model.User;
import com.aditya.request.RatingRequest;


public interface RatingService {

	public Rating createRating(RatingRequest req,User user) throws ProductException;
	
	public List<Rating> getProductsRating(Long productId);

}
