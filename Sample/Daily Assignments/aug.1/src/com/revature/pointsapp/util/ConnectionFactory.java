package com.revature.pointsapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static ConnectionFactory connectionFactory;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		}
		
	catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}
	}
	private ConnectionFactory() 
	{
		
	}
	public static ConnectionFactory getInstance() 
	{
		//lasy loading -create instance when its needed 
	 if(connectionFactory== null)connectionFactory=new ConnectionFactory();
	 return connectionFactory;
	 }
	//factory are charactorized by some method that contains logic for object creation
	public Connection getConnection()
	{
		Connection connection= null;
	
		try
		{
			connection=DriverManager.getConnection(SecretClass.url, SecretClass.username, SecretClass.password));

		}

		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return connection;
	}
	
}
