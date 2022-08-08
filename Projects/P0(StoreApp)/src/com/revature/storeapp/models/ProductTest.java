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
		product.addPrice(10);
		//assert
		Assert.equal(1000,product.getPrice());
	}
	
	@Test
	public void addPriceShouldAddByPrice()
	{
		//arrange
		Product product=new Product("Test");
		//act
		product.addPrice(PriceCategories.Debug_Trainer);
		//assert
		Assert.equal(10,product.getPrice());
	}
	@Test
	public void addPriceShouldnotAddNothing()
	{
		//arrange
		Product product=new Product("Test");
		//act
		product.addPrice(10);
		//assert
		Assert.willThrow(InvalidPriceException.class, () -> product.addPrice(0));
	}
}
