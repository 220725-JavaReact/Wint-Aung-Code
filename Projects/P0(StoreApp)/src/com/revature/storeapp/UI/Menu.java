package com.revature.storeapp.UI;

import java.awt.PageAttributes;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import javax.sound.sampled.Port;

import com.revature.storeapp.Storage.CustomerList;
import com.revature.storeapp.dl.CustomerDAO;
import com.revature.storeapp.dl.CustomerDBDAO;
import com.revature.storeapp.dl.DAO;
import com.revature.storeapp.dl.PDAO;
import com.revature.storeapp.dl.ProductDAO;
import com.revature.storeapp.dl.ProductDBDAO;
import com.revature.storeapp.exception.InvalidPriceException;
import com.revature.storeapp.models.Customer;
import com.revature.storeapp.models.Product;
import com.revature.storeapps.util.Logger;
import com.revature.storeapps.util.Logger.LogLevel;

//import dev.tinajero.app.AnonymousReport;

public class Menu {
	
	 // if i want o use array use DAO 
	private static DAO<Customer>customerDAO = new CustomerDBDAO();/// with array
	private static PDAO<Customer>customerDao2=new CustomerDAO();//without array
	private static PDAO<Product>productDAO2=new ProductDAO();
	private static PDAO<Product>productDAO=new ProductDBDAO();
		private static Logger logger=Logger.getLogger();
	public static void Open()
	{   
		Scanner scanner=new Scanner(System.in);
		String userInput="";
	  logger.log(LogLevel.info,"Starting APP");
	
		do 
		{  
			System.out.println("====================================================");
			System.out.println(" ~~~~~~~~~~Welcome to the New York Store!~~~~~~~~~~~");
			System.out.println("====================================================");
		
			System.out.println("Please select form the list of options below:\n");
			System.out.println("================  Customer Menu   ===================");
		
			System.out.println("[1] - Enroll a new customer");
			System.out.println("[2] - View customer List\n");
			System.out.println("[3] - Place Order");
			System.out.println("================   Admin Memu   ======================");
			System.out.println("[4] - Add New Product");
			System.out.println("[5] - Update the inventory");
			System.out.println("[6] - search Customer List");
			System.out.println("[7] - View Order Detail List\n");
			System.out.println("=================  other options  ====================");
		
			System.out.println("[8] - View the Inventory");
			System.out.println("[9] - Search for the customer");
			System.out.println("[x] - Exit");
			System.out.println("====================================================");
		
			userInput =scanner.nextLine().toUpperCase();
			switch(userInput)
				{
				case"1":
					System.out.println("Creating a Customer registration");
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
					customerDAO.addInstance(customer);
					//customerDAO.addInstance(customer);
					System.out.println("====================================================");
					System.out.println("****************Succssfully Saved !!!*************\n");
					System.out.println("====================================================");				
				break;
				case"2":
					//get all teams
					
					
					
				
				for (Customer customer1:customerDao2.getAll())
				{
					System.out.println(customer1);
				}
					System.out.println("Please choose your pick up store location!");
				
				break;
				case"3":
				System.out.println("Please enter user name");
				String UserName1=scanner.nextLine();
				System.out.println("Please enter password");
				String Password1=scanner.nextLine();
				customer=customerDAO.getUser(UserName1,Password1);			
				PlaceOrderMenu.PlaceOrder();
				break;
				case"4":
					
					System.out.println("Creating a Product registration");
					
					System.out.println("Plase enter your Brand");			
					String Brand=scanner.nextLine();
					System.out.println("Plase enter your Category");
					String Category=scanner.nextLine();
					System.out.println("Plase enter your price ");
				   
			     	int price=Integer.parseInt(scanner.nextLine());
					System.out.println("Plase enter your Quantity");
					//Product productToUpdate=productDAO.getByName(userInput);
					int quantity=Integer.parseInt(scanner.nextLine());
					Product product1=new Product(Brand,  Category,price,quantity);
					productDAO.addInstance(product1);
					////////// can add double times
					System.out.println(product1);
				
					System.out.println("====================================================");
					System.out.println("****************Succssfully Saved !!!*************\n");
					System.out.println("====================================================");		
				
					
					
			    break;
				case"5":
					
					/////update inventory
					
				break;
				case"6":
					for(Product product2:productDAO.getAll())
					{
						System.out.println(product2);
					}
				break;
				case"7":///// view order detail
					
				break;
				case"8":
					for (Product product:productDAO2.GetEverything())
					{
						System.out.println(product);
					}
						System.out.println("Please choose your pick up store location!");
					
					
				break;
				case"9":
					System.out.println("Thank you for your visit!!!!");
					
				break;
				default :
					System.out.println("Oopps!That wasn't a Valid Choice ");
					System.out.println(" Plase try again and choose the valid option");
					
					break;
				}
			    
			
			} 
		while (!userInput.equals("x"));
		logger.log(LogLevel.info, "Existing App");
	}
	
	


}