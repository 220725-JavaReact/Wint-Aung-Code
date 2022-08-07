package com.revature.storeapp.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	public Customer getByName(String FirstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer[] getAll() {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public void UpdateInstance(Customer updatedInstance) {
		// TODO Auto-generated method stub
		
	}

}
