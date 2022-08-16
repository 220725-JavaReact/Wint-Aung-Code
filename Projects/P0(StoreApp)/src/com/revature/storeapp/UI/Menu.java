package com.revature.storeapp.UI;

import java.awt.PageAttributes;
import java.util.List;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import javax.sound.sampled.Port;

import com.revature.storeapp.Storage.CustomerList;
import com.revature.storeapp.dl.CustomerDAO;
import com.revature.storeapp.dl.CustomerDBDAO;
import com.revature.storeapp.dl.DAO;
import com.revature.storeapp.dl.InventoryDAO;
import com.revature.storeapp.dl.OrderHistoryDAO;
import com.revature.storeapp.dl.OrdersDAO;
import com.revature.storeapp.dl.PDAO;
import com.revature.storeapp.dl.ProductDAO;
import com.revature.storeapp.dl.ProductDBDAO;
import com.revature.storeapp.dl.StoreDAO;
import com.revature.storeapp.exception.InvalidPriceException;
import com.revature.storeapp.exception.InvalidUerException;
import com.revature.storeapp.models.Customer;
import com.revature.storeapp.models.Inventory;
import com.revature.storeapp.models.Orders;
import com.revature.storeapp.models.OrdersHistory;
import com.revature.storeapp.models.Product;
import com.revature.storeapp.models.Store;
import com.revature.storeapps.services.CustomerService;
import com.revature.storeapps.services.InventoryService;
import com.revature.storeapps.services.OrderHistoryService;
import com.revature.storeapps.services.OrderService;
import com.revature.storeapps.services.ProductService;
import com.revature.storeapps.services.StoreService;
import com.revature.storeapps.util.Logger;
import com.revature.storeapps.util.Logger.LogLevel;

//import dev.tinajero.app.AnonymousReport;

public class Menu {
	
	 // if i want o use array use DAO 
	private static DAO<Customer>customerDAO2 = new CustomerDBDAO();/// without array
	private static DAO<Customer>customerDAO=new CustomerDAO();//with array
	private static PDAO<Product>productDAO=new ProductDAO(); // without array storage
	private static DAO<Product>productDAO2=new ProductDBDAO(); // from array
	private static PDAO<Inventory>inventoryDAO=new InventoryDAO();
	private static PDAO<Store>storeDAO=new StoreDAO();
		private static Logger logger=Logger.getLogger();
		private static ProductService productService ;
		private static InventoryService inventoryService;
		private static CustomerService customerService;
		private static StoreService storeService;
		private static Orders order;
		private static OrdersHistory orderHistory;
		
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
			System.out.println("================  Customer Menu   ===================\n");
		
			System.out.println("[1] - Sign up ?");
			System.out.println("[2] - View your profile ?");
			System.out.println("[3] - Shop Now ?   \n");
			System.out.println("==================  Admin Menu  ======================\n");
			
			System.out.println("[4] - admin login\n");
			
			System.out.println("=================  other options  ====================");
		
			System.out.println("[5] - View all Products ?");
			System.out.println("[6] - View all inventory?");
			System.out.println("[7] - View all store? ");
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
					new PlaceOrderMenu(customer,order,new CustomerService(new CustomerDBDAO()),new StoreService(new StoreDAO()),new ProductService(new ProductDAO()),new OrderService(new OrdersDAO()),new InventoryService(new InventoryDAO()) ,new OrderHistoryService(new OrderHistoryDAO())).toString();
					System.out.println("====================================================");
					System.out.println("****************Succssfully Saved !!!*************\n");
					System.out.println("====================================================");				
				break;
				case"2":
					//get all teams
					
					
					
				
				for (Customer customer1:customerDAO.getAll())
				{
					System.out.println(customer1);
				}
					
				
				break;
				case"3":
//					System.out.println("Please enter user name");
//					String UserName1=scanner.nextLine();
//					System.out.println("Please enter password");
//					String Password1=scanner.nextLine();
//					try 
//					{
//					
//					 ShoppingMenu.Start();
//					}
//					catch(InvalidUerException e)
//					{
//						System.out.println(e.getMessage());
//					}
					
					ShoppingMenu.Start();
				break;
				
				case"4":
					
					
//					System.out.println("Please enter user name");
//					String UserName1=scanner.nextLine();
//					System.out.println("Please enter password");
//					String Password1=scanner.nextLine();
//					
//					  if ( UserName1.equals("admin"))
//					  {
					  PlaceOrderMenu.Start();
//					}
					
			    break;
				case"5":
					
					for (Product product1:productDAO.GetEverything())
					{
						//System.out.println(product1);
						System.out.println("====================================================");
						System.out.println("ProductID      -    [" +product1.getProductID()+"]");
						System.out.println("Brand          -  ["+product1.getBrand()+"]");
						System.out.println("Category       -  ["+product1.getCategory()+"]");
						System.out.println("Price          -  ["  + product1.getPrice()+"]" );
						System.out.println("Quantity       -  ["+product1.getQuantity()+"]");
						System.out.println("====================================================");
						
					}
					
				
				break;
				
				case"6":
//					for(Product product2:productDAO2.getAll())
//					{
//						System.out.println(product2);
//					}
					for (Inventory inv:inventoryDAO.GetEverything())
					{
						//System.out.println(product1);
						System.out.println("====================================================");
						System.out.println("ProductID      -    [" +inv.getProductID()+"]");
						System.out.println("Brand          -  ["+inv.getBrand()+"]");
						System.out.println("Category       -  ["+inv.getCategory()+"]");
						System.out.println("Price          -  ["  + inv.getPrice()+"]" );
						System.out.println("Quantity       -  ["+inv.getQuantity()+"]");
						System.out.println("Store         -  ["+inv.getStore()+"]");
						System.out.println("Location       -  ["+inv.getLocation()+"]");
						
						System.out.println("====================================================");
						
					}
				break;
				case "7":
					for (Store store:storeDAO.GetEverything())
					{
						//System.out.println(product1);
						System.out.println("====================================================");
						
						System.out.println("ID       -    ["+store.getStoreID()+"]");
						System.out.println("Store     -  ["+store.getStoreName()+"]");
						System.out.println("Location  -  ["+store.getLocation()+"]");
						System.out.println("Des      -  ["+store.getDescription()+"]");
						
						
						System.out.println("====================================================");
						
					}
					
					
					break;
					
				
				case"x":
				
					System.out.println("Thanks for your visit!!!!");
					
				break;
				default :
					System.out.println("Oopps!That wasn't a Valid Choice ");
					System.out.println(" Plase try again and choose the valid option");
					
					break;
				}
			    
			
			} 
		while (!(userInput.equals("X")));
		logger.log(LogLevel.info, "Existing App");
	}
	
	
	


}