package com.revature.storeapp.models;

import com.revature.storeapp.notjunit.Assert;

public class ProductTest {
	@Test
	public void addPriceShouldAdd()
	{
		//arrange
		Product product=new Product("Test");
		//act
		product.addPrice(10);
		//assert
		Assert.equal(product.getPrice(), 10);
	}

}
