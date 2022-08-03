package com.revature.pointsapp.model;

import org.junit.platform.engine.discovery.ClassSelector;

import com.revature.pointsapp.NotJunit.Assert;
import com.revature.pointsapp.NotJunit.Test;
import com.revature.pointsapp.exceptions.InvalidPointException;
import com.revature.pointsapp.model.Team.PointCategories;

public class TeamTest {

	@Test
	public void addPointsShouldAdd()
	{
		//arrange
		Team test = new Team("test");
		//act
		test.addPoints(10);
		//assert
		Assert.equals(10,test.getTotalPoints());
	}
	@Test
	
	public void addPointsShouldAddbyCategory()
	{
		//arrange
		Team test = new Team("test");
		//act
		test.addPoints(PointCategories.DEBUG_TRAINER);
		//assert
		Assert.equals(10,test.getTotalPoints());
	}
@Test
public void addPointShouldNotAddNothing() 
{
//arrange
	Team test=new Team("Test");
	//call a method willthrow that runs test.addpoitns so we can verify that it thrown an exception
	Assert.WillThrow(InvalidPointException.class, ()-> test.addPoints(1));
	
	
}
}
