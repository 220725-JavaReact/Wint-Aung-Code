package com.revature.pointsapp.dl;

import com.revature.pointsapp.model.Team;
import com.revature.pointsapp.storage.TeamStorage;
import com.revature.pointsapp.util.Logger;
import com.revature.pointsapp.util.Logger.LogLevel;

public class TeamDAO implements DAO<Team>{
	
	private static Logger logger =Logger.getLogger();
	@Override
	public void addInstance(Team newInstance) {
		// TODO Auto-generated method stub
		//to add a team somewhere I need a place to store it 
		TeamStorage.teams.add(newInstance);
	//	logger.log(LogLevel.info,"Adding a new team with name " +newInstance.getTeamName());
	logger.log(LogLevel.info,"Adding a new team with name "+ newInstance.getTeamName());
	}

	@Override
	public Team getByName(String name) {
		// TODO Auto-generated method stub
		//for (Team team:TeamStorage.teams.getAllElements()) ** 
		for (Team team: getAll())
		{
			if(team.getTeamName().equals(name)) 
			{
				logger.log(LogLevel.info, "Team" +name+"found!");
				return team;
			}
			logger.log(LogLevel.warning, "Team not found!");
			return null;
			
			
		}
		return null;
	}

	@Override
	public Team[] getAll() {
		// TODO Auto-generated method stub
		logger.log(LogLevel.info,"Getting all teams");
		return TeamStorage.teams.getAllElements();
	}

	@Override
	public void UpdateInstance(Team UpdateInstance) {
		// TODO Auto-generated method stub
		Team []allTeams =getAll();
	for(int i=0; i < allTeams.length;i++)
	{
		if(allTeams[i].getTeamName().equals(UpdateInstance.getTeamName()))
		{
			allTeams[i]=UpdateInstance;
			logger.log(LogLevel.info, "Team"+UpdateInstance.getTeamName()+"Successfully updated!");
			break;
		}
	}
	}
	


}
