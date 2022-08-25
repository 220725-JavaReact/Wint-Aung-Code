package com.revature.storeapp.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.storeapp.models.Customer;
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
	public void UpdateCustInstance(OrdersHistory updatedCusInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(OrdersHistory obj) {
		// TODO Auto-generated method stub
		try
		
		(	Connection connection = ConnectionFactory.getInstance().getConnection())
				{	PreparedStatement preparedStatement=connection.prepareStatement("Insert Into OrderHistory(OrderDate,TotalAmount,UserName,InventoryID,StoreID,ProductID)values(?,?,?,?,?,?)");
			//preparedStatement.setString(1, obj.getOrderHistoryID());		
			preparedStatement.setString(1, obj.getOrderDate());			
			preparedStatement.setInt(2,obj.getTotalAmount());
			preparedStatement.setString(3, obj.getUserName());
			preparedStatement.setInt(4, obj.getInventoryID());
			preparedStatement.setInt(5, obj.getStoreID());
			preparedStatement.setInt(6, obj.getProductID());
			preparedStatement.execute();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
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
				orderHistories.add(new OrdersHistory(rs.getString("UserName"),rs.getString("OrderDate"),rs.getInt("TotalAmount"),rs.getInt("StoreID"),rs.getInt("InventoryID"),rs.getInt("ProductID")));
				
			
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

	@Override
	public void UpDateInstance(OrdersHistory updatedInstance) {
		// TODO Auto-generated method stub
		
	}

	

}
