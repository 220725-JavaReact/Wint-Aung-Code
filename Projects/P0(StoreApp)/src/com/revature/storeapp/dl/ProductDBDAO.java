package com.revature.storeapp.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.storeapp.Storage.ProductList;
import com.revature.storeapp.models.Product;
import com.revature.storeapps.util.ConnectionFactory;

public class ProductDBDAO implements DAO<Product> {

	@Override
	public void addInstance(Product newInstance) {
		// TODO Auto-generated method stub
		try(Connection connection=ConnectionFactory.getInstance().getConnection())
		{
		  String query= "Insert into Product(Brand,Category,Price,Quantity,Store,StoreLocation)Values(?,?,?,?,?,?)";
		  PreparedStatement preparedStatement=connection.prepareStatement(query);
		  preparedStatement.setString(1,newInstance.getBrand());
		  preparedStatement.setString(2,newInstance.getCategory());
		  preparedStatement.setInt(3,newInstance.getPrice());
		  preparedStatement.setInt(4,newInstance.getQuantity());
		  preparedStatement.setString(5,newInstance.getStore());
		  preparedStatement.setString(6,newInstance.getStoreLocation());
		  		 
		  preparedStatement.execute();
		  }
		  catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public Product getByName(String Brand) {
		// TODO Auto-generated method stub
		try(Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query= "Select * From Product where ProductID= ?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, Brand);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next())
			{
				return new Product(rs.getString("Brand"),rs.getString("Category"),rs.getInt("Price"),rs.getInt("Quantity"),rs.getString("Store"),rs.getString("StoreLocation"));
				
			}
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Product[] getAll() {
		// TODO Auto-generated method stub
		ProductList productlist=new ProductList();
		try(Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query = "Select * from Product";
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				productlist.add(new Product(query));
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		return  productlist.getAllElements();
	}

	@Override
	public void UpdateInstance(Product updatedInstance) {
		// TODO Auto-generated method stub
	
		try(Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query="Update Product set Brand=? ,Category =?,Price=?, Quantity =?";
			PreparedStatement preparedStatement =connection.prepareStatement(query);
			preparedStatement.setString(1, updatedInstance.getBrand());
			preparedStatement.setString(2,updatedInstance.getCategory());
			preparedStatement.setInt(3, updatedInstance.getPrice());
			preparedStatement.setInt(4, updatedInstance.getQuantity());
			preparedStatement.setString(5, updatedInstance.getProductID());
			preparedStatement.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}




	



	@Override
	public void save(Product obj) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void update(Product obj) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Product getByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Product> GetEverything() {
		// TODO Auto-generated method stub
		
		
		
		
		return null;
	}



	@Override
	public Product getUser(String UserName, String Password) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Product setUpdate(String FirstName, String LastName, String UserName, String Password, String Email) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void UpdateCustInstance(Product updatedCusInstance) {
		// TODO Auto-generated method stub
		
	}


	
	
	

}
