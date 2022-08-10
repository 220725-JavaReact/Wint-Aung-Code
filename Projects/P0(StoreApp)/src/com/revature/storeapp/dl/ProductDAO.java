package com.revature.storeapp.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.storeapp.Storage.ProductList;
//import com.revature.storeapp.Storage.ProductList;
import com.revature.storeapp.Storage.ProductStorage;
import com.revature.storeapp.models.Customer;
import com.revature.storeapp.models.Product;
import com.revature.storeapps.util.ConnectionFactory;
import com.revature.storeapps.util.Logger;
import com.revature.storeapps.util.Logger.LogLevel;

public class ProductDAO implements PDAO<Product> {
	
	private static Logger logger=Logger.getLogger();

	@Override
	public void addInstance(Product newInstance) {
		// TODO Auto-generated method stub
		ProductStorage.productList.add(newInstance);
		logger.log(LogLevel.info,"Adding a new customer "+newInstance.getBrand());
	}

	@Override
	public Product getByName(String Brand) {
		// TODO Auto-generated method stub
		for (Product product:getAll())
		{
			if(product.getBrand().equals(Brand)) {
				logger.log(LogLevel.info,"Product" +Brand+ "Found!");
			}
			return product;
		}
		logger.log(LogLevel.warning,"Product" +Brand+"Not Found!");
		return null;
	}

	@Override
	public Product[] getAll() {
		// TODO Auto-generated method stub
		logger.log(LogLevel.info,"Getting all products"
				);
		return ProductStorage.productList.getAllElements();
		
	}

	@Override
	public void UpdateInstance(Product updatedInstance) {
		// TODO Auto-generated method stub
	
		Product[] allProduct=getAll();

		for(int i=0;i< allProduct.length;i++)
		{
			if(allProduct[i].getBrand().equals(updatedInstance.getBrand()));
			allProduct[i]=updatedInstance;
			logger.log(LogLevel.info,"Products" +updatedInstance.getProductID()+"Successfully Updated");
			break;
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
		
		List<Product>product=new ArrayList<>();
		
		
		try(Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement("Select * From Product");
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				product.add(new Product(rs.getString("Brand"),rs.getString("Category"),rs.getInt("Price"),rs.getInt("Quantity")));
				
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		return  product;
		
	}

	
  
	
	
}
