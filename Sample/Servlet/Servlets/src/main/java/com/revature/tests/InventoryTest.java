package com.revature.tests;

import javax.management.relation.InvalidRoleValueException;

import org.junit.Test;

import com.revature.model.Inventory;
import com.revature.model.Inventory.PriceCategories;

public class InventoryTest {
	
	@Test 
	public void add_price_should_Add ()
	{
		Inventory test=new Inventory("test");
		test.addPrice(10);
		Assert.equal(10.1, test.getPrice());
		
	}
	@Test
	public void add_price_shouldaddBycategory()
	{
		Inventory test=new Inventory("test");
		test.addPrice(PriceCategories.Debug_trainer);
		//ASSERT
		
		Assert.equal(2.2, test.getPrice());
		
	}
	@Test
	public void add_priceshoudnotaddNothing()
	{
		Inventory test=new Inventory("test");
		Assert.willThrow(InvalidRoleValueException.class, () ->test.addPrice(0));
	}
}
