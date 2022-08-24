package com.revature.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtil {
	
	private static Connection con;

	private ConnectionUtil()
	{
		con=null;
		}

	public static Connection getConnection()
	{
		try
		{
			if(con !=null && !con.isClosed()) 
			{return con;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		String url,user,pass;
		Properties prop=new Properties();
		try 
		{
			prop.load(new FileReader("C:\\Users\\wintk\\Desktop\\Retraining\\Wint-Aung-Code\\Sample\\Servlet\\Servlets\\src\\main\\java\\resource\\database.properties"));
			url=prop.getProperty("url");
			user=prop.getProperty("user");
			pass=prop.getProperty("pass");
			con =DriverManager.getConnection(url,user,pass);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
		}

}
