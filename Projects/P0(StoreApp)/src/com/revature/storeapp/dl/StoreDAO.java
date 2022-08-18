package com.revature.storeapp.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.storeapp.models.Product;
import com.revature.storeapp.models.Store;
import com.revature.storeapps.util.ConnectionFactory;

public class StoreDAO implements PDAO <Store>{

	@Override
	public void addInstance(Store newInstance) {
		// TODO Auto-generated method stub
		try(Connection connection=ConnectionFactory.getInstance().getConnection())
		{
		  String query= "Insert into Store(StoreName,Location,Description)Values(?,?,?)";
		  PreparedStatement preparedStatement=connection.prepareStatement(query);
		  preparedStatement.setString(1,newInstance.getStoreName());
		  preparedStatement.setString(2,newInstance.getLocation());
		  preparedStatement.setString(3,newInstance.getDescription());
		 
		  		 
		  preparedStatement.execute();
		  }
		  catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public Store getByName(String UserName) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	

	@Override
	public void UpdateInstance(Store updatedInstance) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void save(Store obj) {
		// TODO Auto-generated method stub
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("insert into Store(StoreName,Location)Values(?,?)");
			preparedstatement.setString(1,obj.getStoreName());
			preparedstatement.setString(2,obj.getLocation());
		}
		catch(SQLException e)
		{
			throw new RuntimeException("Error found to inject the data into database store table");
		}
		
	}

	@Override
	public void update(Store obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String i) {
		// TODO Auto-generated method stub
		try 
		{
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Delete from Store where StoreID=?");
			preparedstatement.setString(1, i);
			preparedstatement.executeUpdate();
			
			
		}
		catch (SQLException e)
		{
			throw new RuntimeException("Found error to delete from store table");
		}
		
	}

	@Override
	public Store getByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Store> GetEverything() {
		// TODO Auto-generated method stub
		List<Store>store=new ArrayList<>();
	
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Select * from Store");
			ResultSet rs=preparedstatement.executeQuery();
			
			while(rs.next())
			{
				store.add(new Store(rs.getString("StoreID"),rs.getString("StoreName"),rs.getString("Location"), rs.getString("Description")));
			}
			
		}
		catch(SQLException e)
		{
			throw new RuntimeException("Found error to get everything from store table DB");
		}
		return store;
	}
	public List <String>getAllLocation()
	{
		List<String>location = new ArrayList();
		try 
		{
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Select StoreLocation from Store");
			ResultSet rs=preparedstatement.executeQuery();
			while(rs.next())
			{
				location.add(rs.getString("StoreLocationLocation"));
			}
		}
		catch (SQLException e)
		{
			throw new RuntimeException("Found arrow to get the location from store table");
		}
		return location;
	}
	public void updateStoreInventory()
	{
		
	}

	@Override
	public Store[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
