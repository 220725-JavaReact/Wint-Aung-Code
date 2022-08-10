package com.revature.storeapp.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.storeapp.models.Store;
import com.revature.storeapps.util.ConnectionFactory;

public class StoreDAO implements DAO <Store>{

	@Override
	public void addInstance(Store newInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Store getByName(String UserName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Store getUser(String UserName, String Password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Store setUpdate(String FirstName, String LastName, String UserName, String Password, String Email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Store[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void UpdateInstance(Store updatedInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateCustInstance(Store updatedCusInstance) {
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
	public void delete(String id) {
		// TODO Auto-generated method stub
		try 
		{
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Delete from Store where StoreID=?");
			preparedstatement.setString(1, id);
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
		List<Store> store=new ArrayList();
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Select * from Store");
			ResultSet rs=preparedstatement.executeQuery();
			
			while(rs.next())
			{
				store.add(new Store(rs.getInt("StoreID"),rs.getString("StoreName"),rs.getString("Location"), rs.getString("Description")));
			}
			
		}
		catch(SQLException e)
		{
			throw new RuntimeException("Found error to get everything from store table DB");
		}
		return null;
	}
	public List <String>getAllLocation()
	{
		List<String>location = new ArrayList();
		try 
		{
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Select Location from Store");
			ResultSet rs=preparedstatement.executeQuery();
			while(rs.next())
			{
				location.add(rs.getString("Location"));
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

}
