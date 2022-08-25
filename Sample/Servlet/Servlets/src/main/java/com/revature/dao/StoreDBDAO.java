package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Store;
import com.revature.util.ConnectionFactory;


public class StoreDBDAO implements CustomerDAO<Store>{

	@Override
	public Store addInstance(Store newinstance) {
		// TODO Auto-generated method stub
		
		try(Connection connection=ConnectionFactory.getInstance().getConnection())
		{
		  String query= "Insert into Store(StoreName,Location,Description)Values(?,?,?)";
		  PreparedStatement preparedStatement=connection.prepareStatement(query);
		  preparedStatement.setString(1,newinstance.getStoreName());
		  preparedStatement.setString(2,newinstance.getCity());
		  preparedStatement.setString(3,newinstance.getState());
		 
		  		 
		  preparedStatement.execute();
		  }
		  catch(SQLException e)
		{
			e.printStackTrace();
		}
		return newinstance;
		
	}

	@Override
	public List<Store> getAllInstance() {
		// TODO Auto-generated method stub
		List<Store>store=new ArrayList<>();
		
		try (Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			
			PreparedStatement preparedstatement=connection.prepareStatement("Select * from Store");
			ResultSet rs=preparedstatement.executeQuery();
			
			while(rs.next())
			{
				store.add(new Store(rs.getInt("StoreID"),rs.getString("StoreName"),rs.getString("City"),rs.getString("State")));
			}
			
		}
		catch(SQLException e)
		{
			throw new RuntimeException("Found error to get everything from store table DB");
		}
		return store;
	}

	@Override
	public void getByID(int CustomerID, String UserName, String Password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInstance(Store updatinstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInstance(Store deleteinstance) {
		// TODO Auto-generated method stub
		
	}

}
