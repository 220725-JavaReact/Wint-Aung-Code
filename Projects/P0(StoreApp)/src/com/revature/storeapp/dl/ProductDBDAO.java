package com.revature.storeapp.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
//	public List<Product>ProdctList()
//	{
//		// TODO Auto-generated method stub
//		try(Connection connection=ConnectionFactory.getInstance().getConnection())
//		{
//		  String query= "Select * From Product";
//		  PreparedStatement preparedStatement=connection.prepareStatement(query);
//		 
//		 
//		  preparedStatement.execute();
//		  }
//		  catch(SQLException e)
//		{
//			e.printStackTrace();
//		}
//		List<Product>m1=new List() ;
//		
//		return 
//	}
	
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

	@Override
	public void UpdateInstance(Product updatedInstance) {
		// TODO Auto-generated method stub
		
	}

}
