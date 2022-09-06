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

public class OrderHistoryDBDAO implements DAO<OrderHistory> {

	public OrderHistory addInstance(OrderHistory newinstance) {
		// TODO Auto-generated method stub
			
		try	 (Connection connection =ConnectionFactory.getInstance().getConnection())
		{

			PreparedStatement preparedStatement=connection.prepareStatement("Insert Into OrderHistory(OrderDate,UserName,TotalAmount)values(?,?,?)");
			preparedStatement.setDouble(3,newinstance.getTotalAmount());
			preparedStatement.setString(2,newinstance.getUserName());
			preparedStatement.setString(1,newinstance.getOrderDate());
		
//			preparedStatement.setInt(3,newinstance.getProductID());
//		//	preparedStatement.setInt(4, newinstance.getOrderID());
//			preparedStatement.setInt(2, newinstance.getStoreID());
//			preparedStatement.setInt(1, newinstance.getInventoryID());
//			
			preparedStatement.execute();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			//throw new RuntimeException("An error occured when creat an order into the database ");
		}
		return null;

		
		
		
	}
	public List<OrderHistory> getAllInstance() 
	{
		
		
		// TODO Auto-generated method stub
		List<OrderHistory> order=new ArrayList<>();
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Select *from OrderHistory");
			ResultSet rs=preparedstatement.executeQuery();
			
			while(rs.next())
			{
				order.add(new OrderHistory( rs.getString("OrderHistoryID"), rs.getString("UserName"), rs.getDouble("TotalAmount")));
				
			}
		}
			
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return order;
		
		}
	

	
	public List<OrderHistory> getAllByID(int id) {
		// TODO Auto-generated method stub
		
		
		try (Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query="Select OrderHistoryID from OrderHistory ";
				
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
	public void updateInstance(OrderHistory updatinstance) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteInstance(OrderHistory deleteinstance) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getByID(int id) {
		// TODO Auto-generated method stub

		
		try (Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query="Select OrderHistoryID from OrderHistory ";
				
			PreparedStatement preparedStatement =connection.prepareStatement(query);
			
			
			
			preparedStatement.setInt(1,id);
			
			preparedStatement.executeUpdate();
			
			}
		catch(SQLException e)
		{
			//throw new RuntimeException("Found an error when the inventory update into database"); 
		e.printStackTrace();	
		}

	}
		
	
	
	}

		
		
		
		
	




