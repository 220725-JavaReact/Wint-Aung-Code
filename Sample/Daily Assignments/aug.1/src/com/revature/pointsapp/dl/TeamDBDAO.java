package com.revature.pointsapp.dl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.revature.pointsapp.model.Team;
import com.revature.pointsapp.storage.TeamList;
import com.revature.pointsapp.util.ConnectionFactory;

public class TeamDBDAO implements DAO<Team> {

	@Override
	public void addInstance(Team newInstance) {
		// TODO Auto-generated method stub
		try (Connection connection=ConnectionFactory.getInstance().getConnection())
		{
			//drop table teams
			String query = "Insert into Customer (TeamName,Points) values(?,?,?,?)";
			PreparedStatement pstatement=connection.prepareStatement(query);
			pstatement.setString(1, newInstance.getTeamName());
			pstatement.setInt(2, newInstance.getTotalPoints());
			pstatement.execute();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public Team getByName(String name) {
		// TODO Auto-generated method stub
		try(Connection connection=ConnectionFactory.getInstance().getConnection())
		{
			String query="Select * from teams where team_name=?";
			PreparedStatement pstatement=connection.prepareStatement(query);
			pstatement.setString(1, name);
			ResultSet rs=pstatement.executeQuery();
			if(rs.next())//something in it and get return
			{
				return new Team(rs.getString("FirstName"),rs.getInt("Points"),rs.getInt("TeamID"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Team[] getAll() {
		// TODO Auto-generated method stub
		//teamlist is array list
		TeamList teamlist=new TeamList();
		try(Connection connection=ConnectionFactory.getInstance().getConnection())
		{
			String query= "Select * from team";
			Statement statement=(Statement) connection.createStatement();
			ResultSet rs=statement.executeQuery(query);
			
			while (rs.next()) {
				teamlist.add(new Team(rs.getString("TeamName"),rs.getInt("Points"),rs.getInt("TeamID")));
				
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return teamlist.getAllElements();
	}
	

	@Override
	public void UpdateInstance(Team UpdateInstnce) {
		// TODO Auto-generated method stub
		try(Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query="Update Team set Points =? where id =?";
			PreparedStatement pStatement=connection.prepareStatement(query);
			pStatement.setInt(1, UpdateInstnce.getTotalPoints());
			pStatement.setInt(2, UpdateInstnce.getTeamID());
			pStatement.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	
		
	}

}
