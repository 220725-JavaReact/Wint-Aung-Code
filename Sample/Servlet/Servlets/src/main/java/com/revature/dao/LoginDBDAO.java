package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.model.Inventory;
import com.revature.model.Product;
import com.revature.util.ConnectionFactory;

public class LoginDBDAO  {
	
	
	public static boolean validate(String name, String password) {
		// TODO Auto-generated method stub
		boolean status=false;
		try (Connection con=ConnectionFactory.getInstance().getConnection())
		{
			PreparedStatement ps=con.prepareStatement("Select * from Customer where UserName = ? and Password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
			
			
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		return status;
	}
	public static  boolean InventoryValidate(int InventoryID) {
		// TODO Auto-generated method stub
		boolean status=false;
		try (Connection con=ConnectionFactory.getInstance().getConnection())
		{
			PreparedStatement ps=con.prepareStatement("Select * from InventoryID where InventoryID = ? ");
			ps.setInt(1, InventoryID);
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		return status;
		
	}
	
	
	
	
	

}
