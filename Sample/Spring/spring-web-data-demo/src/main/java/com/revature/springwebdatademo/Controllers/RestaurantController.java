package com.revature.springwebdatademo.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.springwebdatademo.models.Restaurant;
import com.revature.springwebdatademo.services.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping // get request to http://localhost:5000 /restaurant
	public List<Restaurant>AllRestaurants(){
		return restaurantService.getAllRestaurants();
	}
@GetMapping("/{id}")
public Restaurant sendRestaurantwithID(@PathVariable String id)
{ Optional<Restaurant> roptional=restaurantService.getRestaurantById(Integer.parseInt(id));
if(roptional.isPresent())
{
	return roptional.get();
	}
else {
	return new Restaurant("no restaurant found with id "+ id);
}
	}
@PostMapping
public Restaurant createRestaurant(@RequestBody Restaurant newRestaurant)
{return restaurantService.addRestaurant(newRestaurant);
	}

}
