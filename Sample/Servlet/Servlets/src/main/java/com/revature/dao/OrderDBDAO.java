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
import com.revature.storage.CartStorage;
import com.revature.util.ConnectionFactory;


public class OrderDBDAO implements ProductDAO<Order>{

	@Override
	public Order addInstance(Order newinstance) {
		// TODO Auto-generated method stub
		try	 (Connection connection =ConnectionFactory.getInstance().getConnection())
		{

			PreparedStatement preparedStatement=connection.prepareStatement("Insert Into Orders(TotalAmount,Brand,UserName,Store,StoreLocation,ProductID,Quantity,Category,StoreID,InventoryID)values(?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setDouble(1,newinstance.getAmount());
			preparedStatement.setString(2,newinstance.getBrand());
			preparedStatement.setString(3,newinstance.getUserName());
			preparedStatement.setString(4,newinstance.getStore());
			preparedStatement.setString(5,newinstance.getLocation());
			
			preparedStatement.setInt(6,newinstance.getProductID());
			preparedStatement.setInt(7,newinstance.getQuantity());
			preparedStatement.setString(8, newinstance.getCategory());
			preparedStatement.setInt(9, newinstance.getStoreID());
			preparedStatement.setInt(10, newinstance.getInventoryID());
			//preparedStatement.setInt(11, newinstance.getOrderID());
			
			preparedStatement.execute();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("An error occured when creat an order into the database ");
		}
		return null;
	}

	@Override
	public List<Order> getAllInstance() {
		// TODO Auto-generated method stub
		List<Order> order=new ArrayList<>();
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Select * from Orders");
			ResultSet rs=preparedstatement.executeQuery();
			
			while(rs.next())
			{//(double Amount,String ProductName, String Category,String userName,int StoreID,String Store,String Location,int productID ,int Quantity ,int InventoryID)
				
			
				order.add(new Order(rs.getDouble("TotalAmount"), rs.getString("Brand"),rs.getString("Category"), rs.getString("UserName"), rs.getInt("StoreID"), rs.getString("Store"), rs.getString("StoreLocation"), rs.getInt("ProductID"),rs.getInt("Quantity"),rs.getInt("InventoryID")));
				
			}
			}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return order;
		
		
		
		
	}


	@Override
	public void updateInstance(Order updatinstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInstance(Order deleteinstance) {
		// TODO Auto-generated method stub
		CartStorage.teams.add(deleteinstance);
	}

	@Override
	public Order[] getAll() {
		// TODO Auto-generated method stub
		return CartStorage.teams.getAllElements();
	}

	@Override
	public Inventory getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	



		
	

	
	

}
