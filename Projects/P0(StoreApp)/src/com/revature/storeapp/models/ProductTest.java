package com.revature.storeapp.models;


import com.revature.storeapp.exception.InvalidPriceException;
import com.revature.storeapp.models.Product.PriceCategories;
import com.revature.storeapp.notjunit.Assert;
import com.revature.storeapp.notjunit.annotation.Test;

public class ProductTest {
	@Test
	public void addPriceShouldAdd()
	{
		//arrange
		Product product=new Product("Test");
		//act
		product.addPrice(100);
		//assert
		Assert.equal(1000,product.getPrice());
	}
	
	@Test
	public void addPriceShouldAddByPrice()
	{
		//arrange
		Product product=new Product("Test");
		//act
		product.addPrice(PriceCategories.COmputer);
		//assert
		Assert.equal(1000,product.getPrice());
	}
	@Test
	public void addPriceShouldnotAddNothing()
	{
		//arrange
		Product product=new Product("Test");
		//act
		product.addPrice(100);
		//assert
		Assert.willThrow(InvalidPriceException.class, () -> product.addPrice(100));
	}
	
}
