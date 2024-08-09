package com.aditya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditya.model.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}

