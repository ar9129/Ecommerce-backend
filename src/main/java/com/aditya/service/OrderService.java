package com.aditya.service;

import java.util.List;

import com.aditya.exception.OrderException;
import com.aditya.model.Address;
import com.aditya.model.Order;
import com.aditya.model.User;


public interface OrderService {

public Order createOrder(User user, Address shippingAdress);
	
	public Order findOrderById(Long orderId) throws OrderException;
	
	public List<Order> usersOrderHistory(Long userId);
	
	public Order placeOrder(Long orderId) throws OrderException;
	
	public Order confirmOrder(Long orderId)throws OrderException;
	
	public Order shipOrder(Long orderId) throws OrderException;
	
	public Order deliverOrder(Long orderId) throws OrderException;
	
	public Order cancelOrder(Long orderId) throws OrderException;
	
	public List<Order>getAllOrders();
	
	public void deleteOrder(Long orderId) throws OrderException;
	
}
