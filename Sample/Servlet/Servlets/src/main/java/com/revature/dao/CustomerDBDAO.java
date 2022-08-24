package com.revature.dao;

import java.sql.Connection;
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
	public Customer addInstance(Customer instance) {
		// TODO Auto-generated method stub
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
	public Customer updateInstance(Customer instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer deleteInstance(Customer instance) {
		// TODO Auto-generated method stub
		return null;
	}

		
	
	
	
	
	
	
}



	
	


