package com.revature.storeapp.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.storeapp.models.Inventory;
import com.revature.storeapp.models.Orders;
import com.revature.storeapps.util.ConnectionFactory;

public class OrdersDAO implements DAO<Orders>{

	@Override
	public void addInstance(Orders newInstance) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public Orders getByName(String Brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void UpdateInstance(Orders updatedInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Orders getUser(String UserName, String Password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders setUpdate(String FirstName, String LastName, String UserName, String Password, String Email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void UpdateCustInstance(Orders updatedCusInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Orders obj) {
		// TODO Auto-generated method stub
		try
		{
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("Insert Into Orders(TotalAmount,Brand,UserName,Store,StoreLocation,ProductID,Quantity,Category,StoreID)values(?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1,obj.getAmount());
			preparedStatement.setString(2,obj.getBrand());
			preparedStatement.setString(3,obj.getUserName());
			preparedStatement.setString(4,obj.getStore());
			preparedStatement.setString(5,obj.getLocation());
			
			preparedStatement.setString(6,obj.getProductID());
			preparedStatement.setInt(7,obj.getQuantity());
			preparedStatement.setString(8, obj.getStoreID());
			preparedStatement.setString(9, obj.getCategory());
			
			
			
			
			preparedStatement.execute();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("An error occured when creat an order into the database ");
		}
		
	}

	@Override
	public void update(Orders obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Orders getByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> GetEverything() {
		// TODO Auto-generated method stub
		List<Orders> order=new ArrayList<>();
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Select * from Orders");
			ResultSet rs=preparedstatement.executeQuery();
			
			while(rs.next())
			{
				order.add(new Orders(rs.getInt("TotalAmount"),rs.getString("Brand"),rs.getString("Category"),rs.getString("UserName"),rs.getString("StoreID"),rs.getString("Store"),rs.getString("StoreLocation"),rs.getString("ProductID"),rs.getInt("Quantity")));
			}
		}
		catch(SQLException e)
		{
			throw new RuntimeException("An error  occured to inject the data into the database.");
		}
		return order;
	}

}
