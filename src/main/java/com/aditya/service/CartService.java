package com.aditya.service;

import com.aditya.exception.ProductException;
import com.aditya.model.Cart;
import com.aditya.model.User;
import com.aditya.request.AddItemRequest;

public interface CartService{

	public Cart createCart(User user);
	
	public String addCartItem(Long userId,AddItemRequest req) throws ProductException;
	
	public Cart findUserCart(Long userId);
}
