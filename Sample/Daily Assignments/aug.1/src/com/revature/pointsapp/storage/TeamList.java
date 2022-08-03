package com.revature.pointsapp.storage;

import com.revature.pointsapp.model.Team;

public class TeamList {
	Team[]backingArray;
	int lastIndex;

	//set the initial values of our array list
	public TeamList()
	{
		backingArray=new Team[10];
		lastIndex=0;
		
	}
	public void add (Team newTeam)
	{ 	//what if the arraylist has reached max cap?
		if(lastIndex==backingArray.length) 
		{  int newSize=(int) (lastIndex*1.5); // right click and add cast to int
			Team[]newBacking =new Team[newSize];
//			newBacking=backingArray.clone();
			
		System.arraycopy(backingArray,0,newBacking,0,backingArray.length);
		backingArray=newBacking;
		}
		backingArray[lastIndex]=newTeam;
		lastIndex++;
	}
	public Team[]getAllElements()
	{
		return backingArray; 
	}
}
