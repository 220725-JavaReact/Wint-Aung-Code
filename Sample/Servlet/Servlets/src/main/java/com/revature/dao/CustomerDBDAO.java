package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Customer;
import com.revature.util.ConnectionFactory;
import com.revature.util.ConnectionUtil;

public class CustomerDBDAO implements CustomerDAO<Customer> {

	@Override
	public  Customer addInstance(Customer instance) {
		// TODO Auto-generated method stub
		try(Connection con=ConnectionFactory.getInstance().getConnection())
		{
			String query="Insert into Customer(FirstName,LastName,UserName,Password)values (?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			//ps.setInt(1, instance.getCustomerID());
			ps.setString(1, instance.getFirstName());
			ps.setString(2, instance.getLastName());
			ps.setString(3, instance.getUserName());
			ps.setString(4, instance.getPassword());
			ps.execute();
		}
		
		catch(SQLException e) 
		{e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Customer> getAllInstance() {
		// TODO Auto-generated method stub
		String Query = "Select * from Customer";
		List<Customer> listofCustomer= new ArrayList<>();
		
		try (Connection con=ConnectionFactory.getInstance().getConnection())
		{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(Query);
			
			while(rs.next())
			{
				listofCustomer.add(new Customer(rs.getString("FirstName"),rs.getString("LastName"),
						rs.getString("UserName"),rs.getString("Password")));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listofCustomer;
	}

	@Override
	public void getByID(int CustomerID,String UserName,String Password) {
		// TODO Auto-generated method stub
		Customer customer=new Customer();
		try(Connection con=ConnectionFactory.getInstance().getConnection())
		{
			PreparedStatement ps=con.prepareStatement("Select * from Customer where CustomerID=?");
			ps.setInt(1, CustomerID);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				customer=new Customer(rs.getInt("CustomerID"),rs.getString("UserName"),rs.getString("Password"));
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateInstance(Customer updatinstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInstance(Customer deleteinstance) {
		// TODO Auto-generated method stub
		
	}

	
	

	


	
	
	
	
	
	
}



	
	


