package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Inventory;
import com.revature.model.Order;
import com.revature.model.Purchase;
import com.revature.util.ConnectionFactory;

public class PurchaseDBDAO implements ProductDAO<Purchase> {

	@Override
	public Purchase addInstance(Purchase newinstance) {
		// TODO Auto-generated method stub
		try	 (Connection connection =ConnectionFactory.getInstance().getConnection())
		{

			PreparedStatement preparedStatement=connection.prepareStatement("Insert Into Purchase(OrderHistoryID,ProductID,StoreID,InventoryID,UserName,Brand,Category,Store,Location,Quantity,Amount,OrderDate)values(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			//preparedStatement.setInt(1,newinstance.getPurchaseID());
			preparedStatement.setInt(1,newinstance.getOrderHistoryID());
			preparedStatement.setInt(2,newinstance.getProductID());
			preparedStatement.setInt(3,newinstance.getStoreID());
			preparedStatement.setInt(4,newinstance.getInventoryID());
			
			preparedStatement.setString(5,newinstance.getUserName());
			preparedStatement.setString(6,newinstance.getBrand());
			preparedStatement.setString(7, newinstance.getCategory());
			
			preparedStatement.setString(8,newinstance.getStore());
			preparedStatement.setString(9, newinstance.getLocation());

			preparedStatement.setInt(10, newinstance.getQuantity());

			preparedStatement.setDouble(11, newinstance.getAmount());

			preparedStatement.setString(12, newinstance.getOrderDate());
			preparedStatement.execute();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("An error occured when creat purchase into the database ");
		}

		
		
		
		
		
		
		
		
		return null;
	}

	@Override
	public Inventory getByID(int InventoryID, int ProductID, int StoreID, String Brand, String Category, String Store,
			String Location, int Price, int Quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInstance(Purchase deleteinstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order deleteInstance(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> getAllInstance() {
		// TODO Auto-generated method stub
		
		List<Purchase> chase=new ArrayList<>();
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Select * from Purchase");
			ResultSet rs=preparedstatement.executeQuery();
		while(rs.next())
		{
			chase.add(new Purchase(rs.getInt("OrderHistoryID"),rs.getInt("InventoryID"), rs.getInt("ProductID"), rs.getInt("StoreID"),rs.getString("Brand"),rs.getString("Category"),

			 rs.getString("Store"),
			 rs.getString("Location"),
			 
			 rs.getDouble("Amount"),
			 
			 rs.getInt("Quantity"),
			 rs.getString("OrderDate"),
			rs.getString("UserName")));

		}
		}
	
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return chase;

	}

	@Override
	public List<Purchase> getAllByID(int id) {
		// TODO Auto-generated method stub
		
		
		
		
		
		return null;
	}

	public void getInstance(Purchase updateinstance) {
		// TODO Auto-generated method stub
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Select * from Purchase");
			ResultSet rs=preparedstatement.executeQuery();
		while(rs.next())
		{
			Purchase ch=new Purchase(rs.getInt("OrderHistoryID"),rs.getInt("InventoryID"), rs.getInt("ProductID"), rs.getInt("StoreID"),rs.getString("Brand"),rs.getString("Category"),

			 rs.getString("Store"),
			 rs.getString("Location"),
			 
			 rs.getDouble("Amount"),
			 
			 rs.getInt("Quantity"),
			 rs.getString("OrderDate"),
			rs.getString("UserName"));

		}
		}
	
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
