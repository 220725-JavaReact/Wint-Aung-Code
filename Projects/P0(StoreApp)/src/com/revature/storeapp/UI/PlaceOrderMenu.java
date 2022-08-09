package com.revature.storeapp.UI;


import java.util.List;
import java.util.Scanner;

import com.revature.storeapp.dl.CustomerDAO;
import com.revature.storeapp.dl.CustomerDBDAO;
import com.revature.storeapp.dl.DAO;
import com.revature.storeapp.dl.PDAO;
import com.revature.storeapp.dl.ProductDAO;
import com.revature.storeapp.dl.ProductDBDAO;
import com.revature.storeapp.models.Customer;
import com.revature.storeapp.models.Product;
import com.revature.storeapps.util.Logger;
import com.revature.storeapps.util.Logger.LogLevel;

public class PlaceOrderMenu {
	//private static DAO<Customer>customerDAO = new CustomerDBDAO();
	private static DAO<Customer>customerDao=new CustomerDAO();
	private static DAO<Customer>customerDao2=new CustomerDBDAO();
	private static PDAO<Product>productDAO2=new ProductDAO();
	private static PDAO<Product>productDAO=new ProductDBDAO();
	
	private static Logger logger=Logger.getLogger();
	public static void PlaceOrder()
	{
		
		Scanner scanner=new Scanner(System.in);
		String userInput="";
		logger .log(LogLevel.info,"User start to login ");
		do {
			System.out.println("Plase choose the option below");
			System.out.println("[1] - Update your information");
			System.out.println("[2] - Shopping\n");
			System.out.println("[3] - Exit");
			userInput=scanner.nextLine().toUpperCase();
			 switch(userInput)
			 {
			 case "1":
				
					
					///// login to validate user info
			
					System.out.println("Plase enter your first Name");
					String FirstName=scanner.nextLine();
					System.out.println("Plase enter your Last Name");			
					String LastName=scanner.nextLine();
					System.out.println("Plase enter your User Name");
					String UserName=scanner.nextLine();
					System.out.println("Plase enter your Password ");
					String Password=scanner.nextLine();
					System.out.println("Plase enter your email address");
					String Email=scanner.nextLine(); 
					Customer customer = new Customer(FirstName,LastName,UserName,Password,Email);
					System.out.println(customer);
					//customerDao2.getByName(UserName);
					customerDao2.UpdateCustInstance(customer);
				//	customerDao2.UpdateInstance(customer);
					
					//customerDao2.setUpdate(FirstName, LastName, UserName, Password, Email);
					
					System.out.println(customer);
					System.out.println("====================================================");
					System.out.println("****************Succssfully Saved !!!*************\n");
					System.out.println("====================================================");				
				    
					
				 break;
			 case "2":
					System.out.println("Welcome from our inventory !!!!!!");
					for(Product product :productDAO2.getAll())
				    {
				    	System.out.println(product);
				    }
				
			 break;
			 case "3":
				 System.out.println("Thanks for your visit");
				 Menu.Open();
			 default:
				 System.out.println("OOOPs !!Invalid Option, please try again with the valid option");
				 break;
			 }
			 
		}
		while (!userInput.equals("X"));
		logger.log(LogLevel.info,"User choose to log out");
	}
	

}
