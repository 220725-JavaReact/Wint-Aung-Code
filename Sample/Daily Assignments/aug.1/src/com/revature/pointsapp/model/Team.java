package com.revature.pointsapp.model;

import com.revature.pointsapp.exceptions.InvalidPointException;

public class Team {
	private String teamName;
	private int totalPoints;
	private int TeamID;
	//constructor used for defining default values of fields
	// multiple constructors =constructor overloading =method overloading =polymorphism 
	public Team(String teamName)
	{//this keyword refers to the instance's field 
		this.teamName=teamName;
		totalPoints=0;
		
	}
	public Team(String teamName,int initialPoints)
	{
		this.teamName=teamName;
		totalPoints=initialPoints;
		
	}
	
	public Team()
	{// calling another constructor of the class using the this()constuctor
		//this is an example of constructor chaining 
		this.teamName ="Wint";  // (this.("Wint"); // this("wint",100);
		totalPoints=100;
	}

	public Team(String teamName,int initialPoints,int TeamID)
	{
		this.teamName=teamName;
		totalPoints=initialPoints;
		this.setTeamID(TeamID);
		
	}
	
	// getters for the teamName and totalPoints becase we want them to be readOnly
	public String getTeamName() {
		return teamName;
	}
	public int getTotalPoints() {
		return totalPoints;
	}
	// add points to total
	public int addPoints( int points)
	{
		if(points == 0 )throw new InvalidPointException("You can't add nothing .You either give points or you take em away");
		 this.totalPoints+=points;
		 return this.totalPoints;
	}
	public int addPoinst(PointCategories category)
	{
		this.totalPoints += category.value;
		return this.totalPoints;
	}
public int addPoints(PointCategories category)
{
	this.totalPoints += category.value;
	return this.totalPoints;
	}
	
	//method overriding the Object class' toString method
	@Override
	public String toString() {
		return "Team [teamName=" + teamName + ", totalPoints=" + totalPoints + "]";
	}
	
	public int getTeamID() {
		return TeamID;
	}
	public void setTeamID(int teamID) {
		TeamID = teamID;
	}

	public enum PointCategories
	{
		DEBUG_TRAINER(10),ANSWER_QUESTION(5),FINISH_ACTIVITY(20),DEBUG_ASSOC(15),LAUGH_A_Trainer_JOKE(3),LAUGHS_AT_TRANINER(Integer.MIN_VALUE);
		
		public final int value;
		
		private PointCategories(int value)
		{
			this.value=value;
		}
	}
}
