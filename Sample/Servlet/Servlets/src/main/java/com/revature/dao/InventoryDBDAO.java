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

public class InventoryDBDAO implements ProductDAO<Inventory>{
	private static ProductDAO<Inventory> productDAO= new InventoryDBDAO();
	
	@Override
	public Inventory addInstance(Inventory newinstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inventory> getAllInstance() {
		// TODO Auto-generated method stub
		
		
		List<Inventory> inventory=new ArrayList<>();
		
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Select * from Inventory");
			ResultSet rs=preparedstatement.executeQuery();
			
			while(rs.next())
			{
				
				inventory.add(new Inventory(rs.getInt("InventoryID"),rs.getString("Brand"), rs.getString("Category"),rs.getInt("StoreID"),rs.getString("Store"),rs.getString("Location"),rs.getInt("Price"), rs.getInt("Quantity"), rs.getInt("ProductID")));
				}
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		
		return inventory;
	}

	@Override
	public void getByID(int ProductID) {
		// TODO Auto-generated method stub
		try (Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query="Update Inventory set Quantity = ? where InventoryID = ? ";
			PreparedStatement preparedStatement =connection.prepareStatement(query);
			
			preparedStatement.setInt(1,ProductID);
			preparedStatement.setInt(2,1);
			//preparedStatement.setString(3,newInstance.getInventoryID());
			//preparedStatement.setString(4,newInstance.getStore());
			//preparedStatement.setString(5,newInstance.getLocation());
			//preparedStatement.setString(6,newInstance.getCategory());
			//preparedStatement.setString(7,newInstance.getBrand());
			//preparedStatement.setInt(8,newInstance.getPrice());
			//preparedStatement.setInt(6, updatedInstance.getCustomerID());
			preparedStatement.executeUpdate();
			
			}
		catch(SQLException e)
		{
			//throw new RuntimeException("Found an error when the inventory update into database"); 
		  e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void updateInstance(Inventory updatinstance) {
		// TODO Auto-generated method stub
		
		try (Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query="Update Inventory set Quantity = ? where InventoryID = ? ";
			PreparedStatement preparedStatement =connection.prepareStatement(query);
			
			preparedStatement.setInt(1,updatinstance.getQuantity());
			preparedStatement.setInt(2,1);
			//preparedStatement.setString(3,newInstance.getInventoryID());
			//preparedStatement.setString(4,newInstance.getStore());
			//preparedStatement.setString(5,newInstance.getLocation());
			//preparedStatement.setString(6,newInstance.getCategory());
			//preparedStatement.setString(7,newInstance.getBrand());
			//preparedStatement.setInt(8,newInstance.getPrice());
			//preparedStatement.setInt(6, updatedInstance.getCustomerID());
			preparedStatement.executeUpdate();
			
			}
		catch(SQLException e)
		{
			//throw new RuntimeException("Found an error when the inventory update into database"); 
		  e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteInstance(Inventory deleteinstance) {
		// TODO Auto-generated method stub
		
	}



}
