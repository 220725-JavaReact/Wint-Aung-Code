package com.revature.storeapp.UI;

import java.awt.PageAttributes;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import com.revature.storeapp.dl.CustomerDAO;
import com.revature.storeapp.dl.CustomerDBDAO;
import com.revature.storeapp.dl.DAO;
import com.revature.storeapp.models.Customer;

//import dev.tinajero.app.AnonymousReport;

public class Menu {
	private static DAO<Customer>customerDAO = new CustomerDBDAO();
	private static DAO<Customer>customerDao2=new CustomerDAO();
	
	
	public static void Open()
	{   
		Scanner scanner=new Scanner(System.in);
		String userInput="";
	  
	
		do 
		{  
			System.out.println("====================================================");
			System.out.println("Welcome to the New York Store!!!");
			System.out.println("====================================================");
		
			System.out.println("Please select form the list of options below:\n");
			System.out.println("================  Customer Menu   ===================");
		
			System.out.println("[1] - Enroll a new customer");
			System.out.println("[2] - View customer List\n");
			System.out.println("[3] - Place Order");
			System.out.println("================   Admin Memu   ======================");
		
		
			System.out.println("[3] - Add New Product");
			System.out.println("[4] - Update the inventory");
			System.out.println("[5] - View Customer List");
			System.out.println("[6] - View Order Detail List\n");
			System.out.println("=================  other options  ====================");
		
			System.out.println("[7] - View the Inventory");
			System.out.println("[8] - Search for the customer");
			System.out.println("[9] - Exit");
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
					customerDao2.addInstance(customer);
					customerDAO.addInstance(customer);
					
					
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
				
				break;
				case"4":
			    break;
				case"5":
				break;
				case"6":
				break;
				case"7":
				break;
				case"8":
				break;
				case"9":
					System.out.println("Thank you for your visiting!!!!");
				break;
				default :
					System.out.println("Oopps!That wasn't a Valid Choice ");
					System.out.println(" Plase try again and choose the valid option");
					
					break;
				}
			    
			
			} 
		while (!userInput.equals("x"));
	}
public void PlaceOrder() 
{
	
	
	}
	


}