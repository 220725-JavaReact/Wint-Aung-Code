package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Inventory;
import com.revature.model.Order;
import com.revature.model.OrderHistory;

import com.revature.util.ConnectionFactory;

public class OrderHistoryDBDAO implements ProductDAO<OrderHistory> {

	@Override
	public OrderHistory addInstance(OrderHistory newinstance) {
		// TODO Auto-generated method stub
			
		try	 (Connection connection =ConnectionFactory.getInstance().getConnection())
		{

			PreparedStatement preparedStatement=connection.prepareStatement("Insert Into OrderHistory(InventoryID,StoreID,ProductID,OrderDate,UserName,TotalAmount)values(?,?,?,?,?,?)");
			preparedStatement.setDouble(6,newinstance.getTotalAmount());
			preparedStatement.setString(5,newinstance.getUserName());
			preparedStatement.setString(4,newinstance.getOrderDate());
		
			preparedStatement.setInt(3,newinstance.getProductID());
		//	preparedStatement.setInt(4, newinstance.getOrderID());
			preparedStatement.setInt(2, newinstance.getStoreID());
			preparedStatement.setInt(1, newinstance.getInventoryID());
			
			preparedStatement.execute();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			//throw new RuntimeException("An error occured when creat an order into the database ");
		}
		return null;

		
		
		
	}

	@Override
	public List<OrderHistory> getAllInstance() 
	{
		
		
		// TODO Auto-generated method stub
		List<OrderHistory> order=new ArrayList<>();
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Select Sum(Price) from orders");
			ResultSet rs=preparedstatement.executeQuery();
			
			while(rs.next())
			{
				order.add(new OrderHistory(rs.getInt("InventoryID"), rs.getInt("StoreID"),rs.getInt("ProductID"), rs.getString("OrderDate"), rs.getString("UserName"), rs.getDouble("TotalAmount")));
				
			}
		}
			
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return order;
		
		}
	

	

	@Override
	public void deleteInstance(OrderHistory deleteinstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderHistory> getAllByID(int id) {
		// TODO Auto-generated method stub
		
		
		try (Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query="Select Sum(Price) from orders ";
				
			PreparedStatement preparedStatement =connection.prepareStatement(query);
			

			
			
			
			preparedStatement.setInt(1,id);
			
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
	public void getInstance(OrderHistory updateinstance) {
		// TODO Auto-generated method stub
		
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


	
	}

		
		
		
		
	




