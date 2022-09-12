package com.revature.springwebdatademo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.springwebdatademo.daos.RestaurantRepository;
import com.revature.springwebdatademo.models.Restaurant;
import com.revature.springwebdatademo.models.Review;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
    public Optional<Restaurant>getRestaurantById(int id)
	{
		Optional<Restaurant>restaurantFromDB= restaurantRepository.findById(id);
		if(restaurantFromDB.isPresent())
		{
			//calculate average if restaurant was found
			List<Review>reviews=restaurantFromDB.get().getReviews();
			Double averageRating =reviews.stream().collect(Collectors.averagingDouble(Review::getRating));
			restaurantFromDB.get().setAverageRating(averageRating);
			
		}
		return restaurantFromDB;
	}
    public Optional <Restaurant>getRestaurantByName(String name)
    {
    	Optional<Restaurant>restaurantFromDB= restaurantRepository.findByName(name);
		if(restaurantFromDB.isPresent())
		{
			//calculate average if restaurant was found
		Double averageRating=restaurantFromDB.get().getReviews().stream()
					.collect(Collectors.averagingDouble(Review::getRating));
		restaurantFromDB.get().setAverageRating(averageRating);
			
			
		}
		return restaurantFromDB;

    }
    public Restaurant addRestaurant(Restaurant  newRestaurant)
    {
    	return restaurantRepository.save(newRestaurant);
    }
}
