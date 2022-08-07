package com.revature.storeapp.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	public Product getByName(String FirstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public SelectProductList(String Brand,String Category,int price,int quanity)
	{
		
	}
	@Override
	public void UpdateInstance(Product updatedInstance) {
		// TODO Auto-generated method stub
		
	}

}
