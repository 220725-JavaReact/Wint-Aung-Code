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
			String query="Insert into Inventory(ProductID,StoreID,Brand,Category,Store,Location,Price,Quantity)values(?,?,?,?,?,?,?,?) ";
			PreparedStatement preparedStatement =connection.prepareStatement(query);
			
			//preparedStatement.setInt(1,newinstance.getInventoryID());
			preparedStatement.setInt(1,newinstance.getProductID());
			preparedStatement.setInt(2,newinstance.getStoreID());
			preparedStatement.setString(3,newinstance.getBrand());
			preparedStatement.setString(4,newinstance.getCategory());

			preparedStatement.setString(5,newinstance.getStore());
			preparedStatement.setString(6,newinstance.getLocation());
			preparedStatement.setDouble(7,newinstance.getPrice());
			preparedStatement.setInt(8, newinstance.getQuantity());
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
		
		try 
		{
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
	public Inventory getByID(int InventoryID, int ProductID, int StoreID, String Brand, String Category, String Store,
			String Location, int Price, int Quantity) {
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order deleteInstance(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Upinstance(Inventory updateinstance) {
		// TODO Auto-generated method stub
		try (Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query="Update Inventory set Quantity = ? where InventoryID = ? ";
			PreparedStatement preparedStatement =connection.prepareStatement(query);
			
			preparedStatement.setInt(1,updateinstance.getInventoryID());
			preparedStatement.setInt(3,updateinstance.getProductID());
			preparedStatement.setInt(3,updateinstance.getStoreID());
			preparedStatement.setString(4,updateinstance.getBrand());
			preparedStatement.setString(5,updateinstance.getCategory());

			preparedStatement.setString(6,updateinstance.getStore());
			preparedStatement.setString(7,updateinstance.getLocation());
			preparedStatement.setDouble(8,updateinstance.getPrice());
			preparedStatement.setInt(9, updateinstance.getQuantity());
			preparedStatement.executeUpdate();
			
			}
		catch(SQLException e)
		{
			//throw new RuntimeException("Found an error when the inventory update into database"); 
		  e.printStackTrace();
		}
		

		
	
	}

	
	

	
		
		
	
	

	
	
}
