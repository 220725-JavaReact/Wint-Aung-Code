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
import com.revature.model.Product;
import com.revature.util.ConnectionFactory;

public class ProductDBDAO implements ProductDAO<Product>{

	@Override
	public Product addInstance(Product newinstance) {
		// TODO Auto-generated method stub
		try(Connection con=ConnectionFactory.getInstance().getConnection())
		{
			String query="Insert into Customer(ProductID,Brand,Category,Price,Quantity)values (?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, newinstance.getProductID());
			ps.setString(2, newinstance.getProductName());
			ps.setString(3, newinstance.getCategory());
			ps.setDouble(4, newinstance.getPrice());
			ps.setInt(5, newinstance.getQuantity());
			ps.execute();
		}
		
		catch(SQLException e) 
		{e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Product> getAllInstance() {
		// TODO Auto-generated method stub
		
		String Query = "Select * from Inventory";
		List<Product> listofProduct= new ArrayList<>();
		
		try (Connection con=ConnectionFactory.getInstance().getConnection())
		{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(Query);
			
			while(rs.next())
			{
				listofProduct.add(new Product(rs.getInt("ProductID"),rs.getString("Brand"),rs.getString("Category"),
						
						rs.getInt("Price"),rs.getInt("Quantity")));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listofProduct;
		
	}

		@Override
	public void deleteInstance(Product deleteinstance) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Product> getAllByID(int id) {
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}

	
	@Override
	public void Upinstance(int intentoryqty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Upinstance(Inventory updateinstance) {
		// TODO Auto-generated method stub
		
	}

	


	
	

}
