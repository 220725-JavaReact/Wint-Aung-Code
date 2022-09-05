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

			PreparedStatement preparedStatement=connection.prepareStatement("Insert Into Orders(Price,Brand,Category,UserName,StoreID,Store,StoreLocation,ProductID,Quantity,InventoryID)values(?,?,?,?,?,?,?,?,?,?)");
			
			preparedStatement.setDouble(1,newinstance.getAmount());
			preparedStatement.setString(2,newinstance.getBrand());
			preparedStatement.setString(3,newinstance.getCategory());
			preparedStatement.setString(4,newinstance.getUserName());
			preparedStatement.setInt(5,newinstance.getStoreID());
			
			preparedStatement.setString(6,newinstance.getStore());
			preparedStatement.setString(7,newinstance.getLocation());
			preparedStatement.setInt(8, newinstance.getProductID());
			
			preparedStatement.setInt(9,newinstance.getQuantity());
			preparedStatement.setInt(10, newinstance.getInventoryID());
			
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
				
			
				order.add(new Order(rs.getDouble("Price"), rs.getString("Brand"),rs.getString("Category"), rs.getString("UserName"), rs.getInt("StoreID"), rs.getString("Store"), rs.getString("StoreLocation"), rs.getInt("ProductID"),rs.getInt("Quantity"),rs.getInt("InventoryID"),rs.getInt("OrderID")));
				
			}
			}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return order;
		
		
		
		
	}



	@Override
	public void deleteInstance(Order deleteinstance) {
		// TODO Auto-generated method stub
		try (Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query="Delete from orders where OrderID=? ";
				
			PreparedStatement preparedStatement =connection.prepareStatement(query);
			

			
			
			
			preparedStatement.setInt(8,deleteinstance.getProductID());
			preparedStatement.setString(2,deleteinstance.getBrand());
			preparedStatement.setString(7,deleteinstance.getCategory());
			preparedStatement.setDouble(11,deleteinstance.getAmount());
			preparedStatement.setInt(6,deleteinstance.getQuantity());
			preparedStatement.setString(3,deleteinstance.getUserName());
			preparedStatement.setString(4,deleteinstance.getStore());
			preparedStatement.setString(5,deleteinstance.getLocation());
			preparedStatement.setInt(9,deleteinstance.getStoreID());
			preparedStatement.setInt(10,deleteinstance.getInventoryID());
			preparedStatement.setInt(1,deleteinstance.getOrderID());
			
			
			preparedStatement.executeUpdate();
			
			}
		catch(SQLException e)
		{
			//throw new RuntimeException("Found an error when the inventory update into database"); 
		  e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public List<Order> getAllByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getInstance(Order updateinstance) {
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
		
		
		try (Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query="Delete from orders where OrderID=? ";
				
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

	



		
	

	
	

}
