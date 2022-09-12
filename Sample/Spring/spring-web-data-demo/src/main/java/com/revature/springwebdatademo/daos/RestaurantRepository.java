package com.revature.springwebdatademo.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.springwebdatademo.models.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	//spring data automaticatlly generates the DAO impl class all curd methods 
	//save,delete,update
	
	
	/** 
	 *Property expression in spring  
	 *spring data JJPA will examine all the properties of the    to this repository and Inner SQL  Statements 
	 ***/
	
	public Optional<Restaurant> findByName(String name); /// select by name
}
