package com.revature.restrev.models;

import com.revature.restrev.exception.InvalidRatingException;

public class Restaurant {

	public String name;
	public String city;
	public String state;
	public int rating;
	public String description;
	public String Address;
	//how out will print out your object
	//string version of your project
	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", city=" + city + ", state=" + state + ", rating=" + rating
				+ ", description=" + description + "]";
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		
		if (rating < 0 || rating >5) 
		
			throw new InvalidRatingException ("Invalid rating. pls enter between 0 and 5");
	}
	public String getAddress() {
		return this.city+","+this.state;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}
