package com.revature.pointsapp.UI;

import java.util.Scanner;

import com.revature.pointsapp.dl.DAO;
import com.revature.pointsapp.dl.TeamDAO;
import com.revature.pointsapp.model.Team;
import com.revature.pointsapp.util.Logger;
import com.revature.pointsapp.util.Logger.LogLevel;

public class Menu {
	private static DAO<Team>teamDao=new TeamDAO() ;
	private static Logger logger=Logger.getLogger();
	public static void open()
	{
		// for getting our user input
		
		Scanner scanner=new Scanner (System.in);
		String userInput="";
	logger.log(LogLevel.info, "String app");
		do {
			System.out.println("Welcome to the ppints app,not at all realted to the point");
			System.out.println("Where you can earn revapints for your team to accomplish infinite loop");
			System.out.println("[1] Create a team");
			System.out.println("[2] Add point to a team");
			System.out.println("[3] View the leader board");
		    System.out.println("[x]Exit");
			
			
			userInput=scanner.nextLine();
			switch (userInput)			
			{
			case "1":
				//create team
				System.out.println("Enter team name :");
				String teamName=scanner.nextLine();
				Team newTeam=new Team(teamName);
				System.out.println(newTeam);
				teamDao.addInstance(newTeam);				
			break;
			case "2":
				for (Team team:teamDao.getAll())
				{
					System.out.println(team);
				}
				System.out.println("Choose team to add point to (type in name):");
				userInput=scanner.nextLine();
				Team teamToUpdate=teamDao.getByName(userInput);
				System.out.println("Enter number of points to add:");
				teamToUpdate.addPoints(scanner.nextInt());
				teamDao.UpdateInstance(teamToUpdate);
				scanner.nextLine();
				
				
				break;
			case "3":
				//print t teams and their points
				for (Team team :teamDao.getAll())
				{
					System.out.println(team);
				}
				break;
			case "x":
				System.out.println("Happy point tracking!");
			break;
			default:
				System.out.println("Invalid Input");
				break;
			
			}
		}
		while(!userInput.equals("x"));// ! means not , .equal returns a boolen, negates boolean
	logger.log(LogLevel.info, "Starting App");
	}

}
