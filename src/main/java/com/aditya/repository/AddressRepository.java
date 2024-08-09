package com.aditya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditya.model.Address;


public interface AddressRepository extends JpaRepository<Address, Long>{

}
