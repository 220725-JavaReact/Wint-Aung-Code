package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.revature.model.Inventory;
import com.revature.model.Order;


import com.revature.util.ConnectionFactory;

public  class InventoryDBDAO implements ProductDAO<Inventory>{
	
	private static ProductDAO<Inventory> productDAO= new InventoryDBDAO();
	
	@Override
	public Inventory addInstance(Inventory newinstance) {
		// TODO Auto-generated method stub
		try (Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query="Update Inventory set Quantity = ? where InventoryID = ? ";
			PreparedStatement preparedStatement =connection.prepareStatement(query);
			
			preparedStatement.setInt(1,newinstance.getInventoryID());
			preparedStatement.setInt(3,newinstance.getProductID());
			preparedStatement.setInt(3,newinstance.getStoreID());
			preparedStatement.setString(4,newinstance.getBrand());
			preparedStatement.setString(5,newinstance.getCategory());

			preparedStatement.setString(6,newinstance.getStore());
			preparedStatement.setString(7,newinstance.getLocation());
			preparedStatement.setDouble(8,newinstance.getPrice());
			preparedStatement.setInt(9, newinstance.getQuantity());
			preparedStatement.executeUpdate();
			
			}
		catch(SQLException e)
		{
			//throw new RuntimeException("Found an error when the inventory update into database"); 
		  e.printStackTrace();
		}
		

		
		return null;
	}

	@Override
	public List<Inventory> getAllInstance() {
		// TODO Auto-generated method stub
		
		
		String q="Select * from Inventory";
		List<Inventory> inventory=new ArrayList<>();
		
		try (Connection connection = ConnectionFactory.getInstance().getConnection())
			{
			Statement stmt=connection.createStatement();
			
			ResultSet rs=stmt.executeQuery(q);
			
			while(rs.next())
			{
				inventory.add(new Inventory(rs.getInt("InventoryID"),rs.getInt("ProductID"), rs.getInt("StoreID"),rs.getString("Brand"),rs.getString("Category"),rs.getString("Store"),rs.getString("Location"), rs.getInt("Price"), rs.getInt("Quantity")));
				}
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		
		return inventory;
	}

	
	
		
		
		
		
	

	@Override
	public void deleteInstance(Inventory deleteinstance) {
		// TODO Auto-generated method stub
		
	}

	
	
	@Override
	public List<Inventory> getAllByID(int id) {
		// TODO Auto-generated method stub
List<Inventory> inventory=new ArrayList<>();
		
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement ps=connection.prepareStatement("Select InventoryID, ProductID,StoreID,Brand ,Category,Store,Location,Price,Quantity from Inventory where InventoryID=?");
			ResultSet rs=ps.executeQuery();
			
			
			
			while(rs.next())
			{
			  ps.setInt(1, id);	
			}
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		
		return inventory;
	}
	@Override
	public void getInstance(Inventory updateinstance) {
		// TODO Auto-generated method stub
	

		try (Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query="Select InventoryID, ProductID,StoreID,Brand ,Category,Store,Location,Price,Quantity from Inventory where InventoryID=?";
				
			PreparedStatement preparedStatement =connection.prepareStatement(query);
			
			preparedStatement.setInt(1,updateinstance.getInventoryID());
			preparedStatement.setInt(1,updateinstance.getProductID());
			preparedStatement.setInt(1,updateinstance.getInventoryID());
			preparedStatement.setString(1,updateinstance.getBrand());
			preparedStatement.setString(1,updateinstance.getCategory());
			preparedStatement.setString(1,updateinstance.getStore());
			preparedStatement.setString(1,updateinstance.getLocation());
			preparedStatement.setDouble(1,updateinstance.getPrice());
			
			preparedStatement.setInt(1,updateinstance.getQuantity());
			preparedStatement.executeUpdate();
			
			}
		catch(SQLException e)
		{
			//throw new RuntimeException("Found an error when the inventory update into database"); 
		  e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public Inventory getByID(int InventoryID, int ProductID, int StoreID, String Brand, String Category, String Store,
			String Location, int Price, int Quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	
		
		
	
	

	
	
}
