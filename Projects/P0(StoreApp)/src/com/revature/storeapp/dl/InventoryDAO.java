package com.revature.storeapp.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.storeapp.models.Inventory;
import com.revature.storeapp.models.OrdersHistory;
import com.revature.storeapps.util.ConnectionFactory;

public class InventoryDAO implements DAO <Inventory>{

	@Override
	public void addInstance(Inventory newInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Inventory getByName(String UserName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory getUser(String UserName, String Password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory setUpdate(String FirstName, String LastName, String UserName, String Password, String Email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void UpdateInstance(Inventory updatedInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateCustInstance(Inventory updatedCusInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Inventory obj) {
		// TODO Auto-generated method stub
		
		try
		{
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("Insert Into Orders(StoreID,ProductID,Quantity)values(?,?,?)");
			preparedStatement.setInt(1, obj.getStoreID());
			preparedStatement.setInt(2, obj.getProductID());		
			preparedStatement.setInt(3,obj.getQuantity());
			preparedStatement.execute();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("An error occured when creat an order into the database ");
		}
		
	}

	@Override
	public void update(Inventory obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Inventory getByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inventory> GetEverything() {
		// TODO Auto-generated method stub
		List<Inventory> inventories=new ArrayList<>();
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Select * from Inventory");
			ResultSet rs=preparedstatement.executeQuery();
			
			while(rs.next())
			{
				inventories.add(new Inventory(rs.getInt("StoreID"),rs.getInt("ProductID"),rs.getInt("Quantity")));
			}
		}
		catch(SQLException e)
		{
			throw new RuntimeException("An error  occured to inject the data into the database.");
		}
		
		return inventories;

		
		
		
	}
	public List<String> getAllStoreID()
	{ List<String>storeID=new ArrayList<>();
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Select StoreID From Inventory");
			ResultSet rs=preparedstatement.executeQuery();
			
			while(rs.next())
			{
				storeID.add(rs.getString("StoreID"));
			}
		}
		catch(SQLException e)
		{
			throw new RuntimeException("An error  occured to inject the data into the database.");
		}
		
		return storeID;
	}
	public void UpdateQuantity(int StoreID,int ProductID,int Quantity)
	{
		
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Update Inventory set Quantity=? where ProductID=? and StoreID=?");
			preparedstatement.setInt(1, Quantity);
			preparedstatement.setInt(2, ProductID);
			preparedstatement.setInt(3, StoreID);
			preparedstatement.executeUpdate();
			
			}
		catch(SQLException e)
		{
			throw new RuntimeException("Found an error when the inventory update into database"); 
		}
	}
	

}
