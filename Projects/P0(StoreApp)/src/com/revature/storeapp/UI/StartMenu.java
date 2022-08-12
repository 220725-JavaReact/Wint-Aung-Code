package com.revature.storeapp.UI;

import java.util.Scanner;
import java.util.UUID;

import com.revature.storeapp.dl.CustomerDAO;
import com.revature.storeapp.dl.CustomerDBDAO;
import com.revature.storeapp.dl.InventoryDAO;
import com.revature.storeapp.dl.OrderHistoryDAO;
import com.revature.storeapp.dl.OrdersDAO;
import com.revature.storeapp.dl.ProductDAO;
import com.revature.storeapp.dl.StoreDAO;
import com.revature.storeapp.exception.InvalidUerException;
import com.revature.storeapp.models.Customer;
import com.revature.storeapp.models.Inventory;
import com.revature.storeapp.models.Orders;
import com.revature.storeapp.models.OrdersHistory;
import com.revature.storeapps.services.CustomerService;
import com.revature.storeapps.services.InventoryService;
import com.revature.storeapps.services.OrderHistoryService;
import com.revature.storeapps.services.OrderService;
import com.revature.storeapps.services.ProductService;
import com.revature.storeapps.services.StoreService;
import com.revature.storeapps.util.annotations.Inject;

/**
 * @author wintk
 *
 */
public class StartMenu implements IMenu{

	@Inject
	private final CustomerService customerService;
	
	@Inject
	public StartMenu (CustomerService custoemrService)
	{
		this.customerService=custoemrService;
	}
	




	@Override
	public void Start() {
		// TODO Auto-generated method stub
		Scanner scanner =new Scanner(System.in);
		
		exit:
		{
			while(true)
			{
				Introduction();
				
				System.out.println("\nEnter : ");
				String userInput =scanner.nextLine();
				
				switch(userInput)
				{
				case "1": 
					LogIn();
					break;
				case "2":
					SignUp();
					break;
				case "x":
					System.out.println("Thanks for your visit");
					break exit;
				default:
					System.out.println("Ooops! Invalide Input . Plase choose the invalid option");
					break;
				}
			}
		}
		
		
		
	}
	
	private void Introduction()
	{
		System.out.println("=================================================================");
		System.out.println("============  Welcome form our New York Application==============");
		System.out.println("==================================================================\n");
		System.out.println("=============     Please choose the Option Below ==================");
		System.out.println("[1]  - Member Login ");
		System.out.println("[2]  - Member Register ");
		System.out.println("[x]  - Exit ");
		System.out.println("==================================================================\n");
		
	}
	private void LogIn()
	{
		String UserName;
		String Password;
		Customer customer;
		Orders order=null;
		OrdersHistory orderHistory=null;
		
		Scanner scanner=new Scanner(System.in);
				
			while (true)
			{
				System.out.println("======================================================");
				System.out.println("Welcome member!");
				System.out.println("======================================================");
				System.out.print("Please enter your username");
				UserName=scanner.nextLine();
				System.out.print("Please enter your password");
				Password=scanner.nextLine();
				
				try 
				{
					customer=customerService.Login(UserName, Password);
				if(customer.getRole().equals("admin"))
					new AdminMenu(customer,new StoreService(new StoreDAO()),new ProductService(new ProductDAO()),new InventoryService(new InventoryDAO())).Start();
					
				
				else 
					new PlaceOrderMenu(customer,order,orderHistory,new CustomerService(new CustomerDBDAO()),new StoreService(new StoreDAO()),new ProductService(new ProductDAO()),new OrderService(new OrdersDAO()),new InventoryService(new InventoryDAO()),new OrderHistoryService(new OrderHistoryDAO())).Start();
				break;
				}
				catch(InvalidUerException e)
				{
					e.printStackTrace();
				}
			}
		
	}
	private void SignUp()
	{
		String UserName;
		String Password;
		Customer customer;
		OrdersHistory orderHistory;
		Scanner scanner=new Scanner(System.in);
		
		completeExit:
		{
			while(true)
			{
				System.out.println("================================================================");
				System.out.println("=============  Creating Account     =====================");
				System.out.println("================================================================");
				System.out.println("Please enter username");
				UserName=scanner.nextLine();
				try {
					if(customerService.isValidUserName(UserName))
					{
			 			if(customerService.isNotDuplicateUserName(UserName))break;
					}
				}
				catch(InvalidUerException e)
				{
					System.out.println(e.getMessage());
				}
				
			}
			while(true)
			{
				System.out.println("Plaes enter your password");
				Password=scanner.nextLine();
				try {
					if(customerService.isValidPassword(Password))
					{
						System.out.println("please enter your password again");
						String confirm =scanner.nextLine();
						if(Password.equals(confirm)) break;
						else System.out.println("Password doesn't match");
					}
				}
				catch(InvalidUerException e)
				{
					e.printStackTrace();
				}
			}
		}
		confirmExit:
		{
			while(true)
			{
				System.out.println("Please enter your credential (y/n");
				System.out.println("UserName : "  + UserName);
				System.out.println("UserName : "  + Password);
				System.out.println("\nEnter:");
				String input =scanner.nextLine();
				
				switch(input)
				{
				case "y":
					customer=new Customer( UUID.randomUUID().toString(),UserName,Password,"DEFAULT");
					
					
				}
				
				
				
			}
		}
	}
	
	

}
