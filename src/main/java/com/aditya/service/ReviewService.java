package com.aditya.service;

import java.util.List;

import com.aditya.exception.ProductException;
import com.aditya.model.Review;
import com.aditya.model.User;
import com.aditya.request.ReviewRequest;


public interface ReviewService {

public Review createReview(ReviewRequest req, User user) throws ProductException;
	
	public List<Review> getAllReview(Long productId);
}
