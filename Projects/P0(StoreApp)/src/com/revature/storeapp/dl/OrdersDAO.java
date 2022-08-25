package com.revature.storeapp.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.storeapp.models.Customer;
import com.revature.storeapp.models.Inventory;
import com.revature.storeapp.models.Orders;
import com.revature.storeapp.models.Product;
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
		try		(Connection connection = ConnectionFactory.getInstance().getConnection())
		{

			PreparedStatement preparedStatement=connection.prepareStatement("Insert Into Orders(TotalAmount,Brand,UserName,Store,StoreLocation,ProductID,Quantity,Category,StoreID,InventoryID)values(?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1,obj.getAmount());
			preparedStatement.setString(2,obj.getBrand());
			preparedStatement.setString(3,obj.getUserName());
			preparedStatement.setString(4,obj.getStore());
			preparedStatement.setString(5,obj.getLocation());
			
			preparedStatement.setInt(6,obj.getProductID());
			preparedStatement.setInt(7,obj.getQuantity());
			preparedStatement.setString(8, obj.getCategory());
			preparedStatement.setInt(9, obj.getStoreID());
			preparedStatement.setInt(10, obj.getInventoryID());
					
			
			
			
			
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
				order.add(new Orders(rs.getInt("TotalAmount"),rs.getString("Brand"),rs.getString("Category"),rs.getString("UserName"),rs.getInt("StoreID"),rs.getString("Store"),rs.getString("StoreLocation"),rs.getInt("ProductID"),rs.getInt("Quantity"),rs.getInt("InventoryID")));
			}
		}
		catch(SQLException e)
		{
			throw new RuntimeException("An error  occured to inject the data into the database.");
		}
		return order;
	}

	@Override
	public void UpDateInstance(Orders updatedInstance) {
		// TODO Auto-generated method stub
		
	}


	

}
