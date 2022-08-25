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

public class ProductDBDAO implements PDAO<Product> {

	@Override
	public void addInstance(Product newInstance) {
		// TODO Auto-generated method stub
		try(Connection connection=ConnectionFactory.getInstance().getConnection())
		{
		  String query= "Insert into Product(Brand,Category,Price,Quantity)Values(?,?,?,?)";
		  PreparedStatement preparedStatement=connection.prepareStatement(query);
		  preparedStatement.setString(1,newInstance.getBrand());
		  preparedStatement.setString(2,newInstance.getCategory());
		  preparedStatement.setInt(3,newInstance.getPrice());
		  preparedStatement.setInt(4,newInstance.getQuantity());
		 
		  		 
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
				return new Product(rs.getString("Brand"),rs.getString("Category"),rs.getInt("Price"),rs.getInt("Quantity"));
				
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
	public void save(Product obj) {
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
	public Product getByInvID(String InventoryID) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void update(int currentInventory, int ProductID) {
		// TODO Auto-generated method stub
		
	}


	
	
	

}
