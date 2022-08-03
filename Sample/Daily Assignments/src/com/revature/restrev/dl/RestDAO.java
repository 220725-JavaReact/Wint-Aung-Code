package com.revature.restrev.dl;

import java.util.ArrayList;

import com.revature.restrev.models.Restaurant;

public class RestDAO implements DAO<Restaurant>{
//method overriding 
	@Override
	public void addInstance(Restaurant newInstance) {
		// TODO Auto-generated method stub
		TemporaryStorage.restaurants.add(newInstance)
	}

	@Override
	public ArrayList<Restaurant> getAllInstances() {
		// TODO Auto-generated method stub
		return TemporaryStorage.restaurants;
	}
	
	

}
