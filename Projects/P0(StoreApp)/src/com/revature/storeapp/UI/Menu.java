package com.revature.storeapp.UI;

import java.awt.PageAttributes;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import com.revature.storeapp.models.Customer;

public class Menu {
	public static void Open() 
	{
		Scanner scanner=new Scanner(System.in);
		String userInput="";
		do 
		{
			System.out.println("Welcome to the New York Store"); 
			System.out.println("Please choose the option to proceed ");
			System.out.println("[1] - Create Customer");
			System.out.println("[2] - Place Order");
			System.out.println("[x] - Exit ");
			
			userInput=scanner.nextLine();
			switch(userInput)
			{
			case "1":
				
				System.out.println("----------------------------------------------------------");
				System.out.println("Please enter your  name");
				String userName=scanner.nextLine();
				System.out.println("Please enter your  email");
				String email=scanner.nextLine();
				System.out.println("Please enter your  order list");
				String orderlist =scanner.nextLine();
				System.out.println("Please enter your  phone number");
				String phone =scanner.nextLine();
				System.out.println("----------------------------------------------------------");
				Customer customer=new Customer(userName, email,  phone,orderlist);
				System.out.println(customer);
			
				
			break;
			case "2":

				
				System.out.println("----------------------------------------------------------");
				System.out.println("Please login first  !!!");
				System.out.println("Please enter your user name");
				String oldusername=scanner.nextLine();
				System.out.println("Please enter your password");
				String oldpassword=scanner.nextLine();
				
				
			break;
			case "x":
				System.out.println("You choose to exit");
			break;
			default:
				System.out.println("Invalid Input");
			break;
			
			}
			
			
		}
		while (!userInput.equals("x"));
	}
}
