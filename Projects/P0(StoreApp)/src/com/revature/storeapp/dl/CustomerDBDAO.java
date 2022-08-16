package com.revature.storeapp.dl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.storeapp.Storage.CustomerList;

import com.revature.storeapp.models.Customer;

import com.revature.storeapps.util.ConnectionFactory;

public class CustomerDBDAO  implements DAO<Customer>{

	@Override
	public void addInstance(Customer newInstance) {
		// TODO Auto-generated method stub
		try(Connection connection=ConnectionFactory.getInstance().getConnection())
		{
		  String query= "Insert into Customer(FirstName,LastName,UserName,Password,Email)Values(?,?,?,?,?)";
		  PreparedStatement preparedStatement=connection.prepareStatement(query);
		  preparedStatement.setString(1,newInstance.getFirstName());
		  preparedStatement.setString(2,newInstance.getLastName());
		  preparedStatement.setString(3,newInstance.getUserName());
		  preparedStatement.setString(4,newInstance.getPassword());
		  preparedStatement.setString(5,newInstance.getEmail());
		  preparedStatement.execute();
		  }
		  catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public Customer getByName(String UserName) {
		// TODO Auto-generated method stub
		try(Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query= "Select * From Customer where UserName= ?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, UserName);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next())
			{
				return new Customer(rs.getString("FistName"),rs.getString("LastName"),rs.getString("UserName"),rs.getString("Password"),rs.getString("Email"));
				
			}
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Customer[] getAll() {
		// TODO Auto-generated method stub
		
		CustomerList customerlist=new CustomerList();
		
		try(Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query = "Select * from Product";
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery(query);
			while(rs.next())
			{
				customerlist.add(new Customer(query));
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		return  customerlist.getAllElements();
	}

	@Override
	public void UpdateInstance(Customer updatedInstance) {
		// TODO Auto-generated method stub
		try(Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query="Update Customer set FirstName=? ,LastName =?,UserName=?, Password =?,Email=? where CustomerID=?";
			PreparedStatement preparedStatement =connection.prepareStatement(query);
			
			preparedStatement.setString(1, updatedInstance.getFirstName());
			preparedStatement.setString(2,updatedInstance.getLastName());
			preparedStatement.setString(3, updatedInstance.getUserName());
			preparedStatement.setString(4, updatedInstance.getPassword());
			
			preparedStatement.setString(5, updatedInstance.getEmail());
			//preparedStatement.setInt(6, updatedInstance.getCustomerID());
			preparedStatement.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	public List <String>getAllcustermerbyUserName()
	{
		List<String> username=new ArrayList<>();
		try
		{
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Select UserName From Customer where UserName=?");
			ResultSet rs=preparedstatement.executeQuery();
			while(rs.next())
			{
				username.add(rs.getString("Username"));
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return username;
	}

	@Override
	public Customer getUser(String UserName, String Password) {
		// TODO Auto-generated method stub
		try(Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query= "Select * From Customer where UserName= ? ";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, UserName);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next())
			{
				return new Customer(rs.getString("FirstName"),rs.getString("LastName"),rs.getString("UserName"),rs.getString("Password"),rs.getString("Email"));
				
			}
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer setUpdate(String FirstName, String LastName, String UserName, String Password, String Email) {
		// TODO Auto-generated method stub
		try(Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query="Update Customer set ,FirstName=? ,LastName =?,UserName=?, Password =?,Email=? where CustomerID=?";
			PreparedStatement preparedStatement =connection.prepareStatement(query);
			
			preparedStatement.setString(1, FirstName);
			preparedStatement.setString(2,LastName);
			preparedStatement.setString(3, UserName);
			preparedStatement.setString(4,Password);
			
			preparedStatement.setString(5, Email);
			//preparedStatement.setInt(6, CustomerID);
			preparedStatement.execute();
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void UpdateCustInstance(Customer updatedCusInstance) {
		// TODO Auto-generated method stub
		try(Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query="Update Customer set FirstName=? ,LastName =?,UserName=?, Password =?,Email=? where CustomerID=?";
			PreparedStatement preparedStatement =connection.prepareStatement(query);
			
			preparedStatement.setString(1, updatedCusInstance.getFirstName());
			preparedStatement.setString(2,updatedCusInstance.getLastName());
			preparedStatement.setString(3, updatedCusInstance.getUserName());
			preparedStatement.setString(4, updatedCusInstance.getPassword());
			
			preparedStatement.setString(5, updatedCusInstance.getEmail());
			//preparedStatement.setInt(6, updatedCusInstance.getCustomerID());
			preparedStatement.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public Customer getByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> GetEverything() {
		// TODO Auto-generated method stub
		
		
		
		
		return null;
	}

	@Override
	public void update(Customer obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Customer obj) {
		// TODO Auto-generated method stub
		
	}
	public List <String>getAllUserName()
	{
		List<String> username=new ArrayList<>();
		try
		{
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Select * From Customer where UserName =?");
			ResultSet rs=preparedstatement.executeQuery();
			while(rs.next())
			{
				username.add(rs.getString("Username"));
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return username;
	}
}
