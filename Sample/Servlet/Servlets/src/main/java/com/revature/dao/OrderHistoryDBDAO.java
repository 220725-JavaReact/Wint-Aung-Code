package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
	public List<OrderHistory> getAllInstance() {
		// TODO Auto-generated method stub
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
	public OrderHistory[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getByID(int ProductID) {
		// TODO Auto-generated method stub
		
	}

		
		
		
		
	



}
