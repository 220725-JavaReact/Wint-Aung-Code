package com.revature.storeapp.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
			PreparedStatement preparedStatement=connection.prepareStatement("Insert Into Orders(ProductID,Brand,Price ,Quantity)values(?,?,?,?)");
			preparedStatement.setInt(1, obj.getOrderID());
			preparedStatement.setInt(2, obj.getProductID());
			preparedStatement.setString(3,obj.getBrand());
			preparedStatement.setDouble(4,obj.getPrice());
			preparedStatement.setInt(5,obj.getQuantity());
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
		return null;
	}

}
