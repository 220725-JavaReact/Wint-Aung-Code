package com.revature.storeapp.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.storeapp.models.OrdersHistory;
import com.revature.storeapps.services.OrderHistoryService;
import com.revature.storeapps.util.ConnectionFactory;

public class OrderHistoryDAO implements DAO<OrdersHistory>{
	
	@Override
	public void addInstance(OrdersHistory newInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrdersHistory getByName(String UserName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdersHistory getUser(String UserName, String Password) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public OrdersHistory[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void UpdateInstance(OrdersHistory updatedInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateCustInstance(OrdersHistory updatedCusInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(OrdersHistory obj) {
		// TODO Auto-generated method stub
		try
		{
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("Insert Into OrderHistory(OrderHistoryID,OrderDate,TotalAmount,UserName)values(?,?,?,?)");
			preparedStatement.setString(1, obj.getOrderHistoryID());		
			preparedStatement.setString(2, obj.getOrderDate());			
			preparedStatement.setInt(3,obj.getTotalAmount());
			preparedStatement.setString(4, obj.getUserName());
			preparedStatement.execute();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("An error occured when creat an Order detail  into the database ");
		}
	}

	@Override
	public void update(OrdersHistory obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrdersHistory getByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersHistory> GetEverything() {
		// TODO Auto-generated method stub
		List<OrdersHistory> orderHistories= new ArrayList<>();
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Select * from OrderHistory");
			ResultSet rs=preparedstatement.executeQuery();
			
			while(rs.next())
			{
				orderHistories.add(new OrdersHistory(rs.getString("OrderHistoryID"), rs.getString("UserName"),rs.getString("OrderDate"),rs.getInt("TotalAmount")));
			
			}
		}
		catch(SQLException e)
		{
			throw new RuntimeException("An error  occured to inject the data into the database.");
		}
		
		return orderHistories;
	}

	@Override
	public OrdersHistory setUpdate(String FirstName, String LastName, String UserName, String Password, String Email) {
		// TODO Auto-generated method stub
		return null;
	}

}
