package com.revature.storeapps.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static ConnectionFactory connectionFactory;
	static
	{
		try 
		{
			Class.forName("org.postgresql.Driver");
		}
		catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	private ConnectionFactory()
	{
		
	}
	public static ConnectionFactory getInstance()
	{
		//lazy loading
		if(connectionFactory ==null)connectionFactory=new ConnectionFactory();
		return connectionFactory;
	}
	public Connection getConnection()
	{
		Connection connection = null;
		try
		{
			connection=DriverManager.getConnection(SecretClass.url,SecretClass.username,SecretClass.password);
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return connection;
	}

}
