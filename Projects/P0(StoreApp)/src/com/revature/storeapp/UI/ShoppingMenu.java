package com.revature.storeapp.UI;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import java.util.Objects;

import com.revature.storeapp.dl.DAO;
import com.revature.storeapp.dl.InventoryDAO;
import com.revature.storeapp.dl.OrderHistoryDAO;
import com.revature.storeapp.dl.OrdersDAO;
import com.revature.storeapp.dl.PDAO;

import com.revature.storeapp.models.Inventory;
import com.revature.storeapp.models.Orders;
import com.revature.storeapp.models.OrdersHistory;


import com.revature.storeapps.util.Logger;
import com.revature.storeapps.util.Logger.LogLevel;

public class ShoppingMenu 
{
private static DAO<Orders> orderDAO= new OrdersDAO();

private static PDAO <Inventory>inventoryDAO=new InventoryDAO();
private static DAO<OrdersHistory> orderHistoryDAO= new OrderHistoryDAO();


private static Logger logger=Logger.getLogger();

private static Inventory inventory;

	public static void Start()
	{
		
			
				Scanner scanner=new Scanner(System.in);
			
				String userInput="";
				logger.log(LogLevel.info," Member start to shop ");
			      boolean choice= false;
				do 
				{  
					System.out.println("====================================================");
					System.out.println(" ~~~~~~~~~~Welcome to the New York Store!~~~~~~~~~~~");
					System.out.println("====================================================");
				
					System.out.println("Please select form the list of options below:\n");
					System.out.println("================  Customer Menu   ===================");
				
					
					
					System.out.println("[1] - Login");
					System.out.println("[2] - Order History");
					System.out.println("[x] - Exit");
					
					
					System.out.println("====================================================");
				
					userInput =scanner.nextLine().toUpperCase();
					switch(userInput)
					{			
					case"1":
						
						
						
						
						
					ShoppingItem();//looping product list 
										
					break;
					case"2":
						try {
						for (Orders order:orderDAO.getAll())
						{
							System.out.println(order);
						}
							System.out.println("Please choose your pick up store location!");
						}
						catch (Exception e)
						{
							System.out.println("Sorry! you have to log in first");
						}
					break;
					case "x":
						System.out.println("Thank for your visit");
						Menu.Open();
						break;
					
					default :
					System.out.println("Oopps!That wasn't a Valid Choice ");
					System.out.println(" Plase try again and choose the valid option");
					break;
					/// first switch close 
					}
					
					}// do close  
				
				while(!(userInput.equals("x")));
				logger.log(LogLevel.info, "Existing App");

				
				
			}
	
	public static void OrderHistory()
	{
		
		
	}
	
			
			public static void ShoppingItem()
			
			{
				
				Scanner scanner=new Scanner(System.in);
				System.out.println("Please enter user name");
				String UserName1=scanner.nextLine();
				System.out.println("Please enter password");
				String Password1=scanner.nextLine();
				String itemID;
				String proID;
				
				int input =0;
					int currentInventory;
				
						
				//customerDAO.addInstance(customer);
				System.out.println("====================================================");
				System.out.println("****************Succssfully Login !!!*************\n");
				System.out.println("====================================================");	
				logger.log(LogLevel.info," Member start to shop ");
				
				System.out.println("Do you wanna buy this product? ");
				System.out.println("Please enter yes or no !! ");
				
				for (Inventory product:inventoryDAO.GetEverything())
				{
				System.out.println("====================================================");
				System.out.println(product);
				System.out.println("ID         -  [" + product.getProductID()+"]");
				System.out.println("Brand      -  ["  +product.getBrand()+"]");
				System.out.println("Category   -  ["+product.getCategory()+"]");
				System.out.println("Price      -  [" +product.getPrice()+"]");
				System.out.println("Quantity   -  [" +product.getQuantity()+"]");
				int inventoryQuntity=product.getQuantity();
				System.out.println("Store      -  [" +product.getStore()+"]");
				System.out.println("Location   -  [" +product.getLocation()+"]");
				System.out.println("====================================================");
				System.out.println("PRESS YES [OR] NO");
			
				logger.log(LogLevel.info," Member start to shop ");
				String answer =scanner.nextLine();
					switch(answer)
						{
						case "Yes":
						case "yes":
						System.out.println("Please enter the ID of the product what what you like to buy!!!");
						System.out.println("Plase enter ID of your choosen product!! ");
						String ProductID=scanner.nextLine();
					
						System.out.println("Plase enter  Quantity !! ");
						int Quantity =scanner.nextInt();
						int qty =product.getQuantity();
							if (Quantity > qty)
						{
							System.out.println("Pleas enter valid amount ");
						}
							logger.log(LogLevel.info," Member choose the product ");
						System.out.println("This is the list of product you want to buy !!!!!!!");
						String Brand= product.getBrand();
						int Price = product.getPrice();
						String store =product.getStore();
						String StoreID=product.getStoreID();
						String Category=product.getCategory();
						String location =product.getLocation();
						int amount = (product.getPrice() * Quantity);
						System.out.println("ProductID   -      [" +ProductID+"]" );
						System.out.println("Brand       -   [" +Brand +"]");
						System.out.println("Category    -   [" +Category +"]");
						System.out.println("Quantity    -  [" +Quantity +"]");
						System.out.println("store       -  [" +store +"]");
						System.out.println("location    -   [" +location+"]" );
						System.out.println("Amount      -  [" +amount +"]");
						System.out.println("====================================================");
						
						List<Orders>orderList=new ArrayList<>();
						System.out.println("====================================================");
						
						
						//String username=customer.getUserName();
						
						Orders order= new Orders(amount, Brand,Category,UserName1, StoreID,store, location, ProductID, Quantity);
						System.out.println(order);
						orderList.add(order);
						
						
							System.out.println("\n Press Y to coninue  !");
						
							
							String ans=scanner.nextLine().toUpperCase();
							if(Objects.equals(scanner.nextLine(), "Y"))
							{
								int sum=0;
								for(Orders item:orderList)
								{
									System.out.println(item.partialToString()+"\n");
									sum+=item.getAmount() *item.getQuantity();
								}
								System.out.println("Total: $ "+sum);
								System.out.println("Buy (y/n):");
								
								switch(scanner.nextLine().toUpperCase())
								{
									case "y":
									case "Y":
										System.out.println("Date insert");
										java.util.Date date=Calendar.getInstance().getTime();
										//java.util.Date date=Calendar.getInstance().getTime();
										DateFormat dateFormat= new SimpleDateFormat("mm-dd-yyyy");
										String strDate=dateFormat.format(date);
										currentInventory=inventoryQuntity-Quantity;
										
										System.out.println(" order register");
										System.out.println(order);
										orderDAO.save(order);
										OrdersHistory orderHistory=new OrdersHistory(UUID.randomUUID().toString(),UserName1, strDate, sum);
										
										System.out.println(" orderhistory register");
										System.out.println(orderHistory);
										
										orderHistoryDAO.save(orderHistory);
										System.out.println("Inventory update");
										System.out.println(inventory);
										
										inventoryDAO.update(inventory);
										
										break;
									case "n":
									case "N":
										 System.out.println(" you want to choose item y/n");
										String choi= (scanner.nextLine().toUpperCase());
										if (choi == "Y" )
										ShoppingMenu.ShoppingItem();
										else 
										ShoppingMenu.Start();
										break;
										default:
											System.out.println("Invalid Input");
											break;
								}
								
								
							}
							else 
							{
								System.out.println("Invalid product slection");
								//ShoppingMenu.Start();
								break;
							}
						
							
				
						 
						
												
						
						
						
						break;
						
						case "No":
						case "no":
						break;
						
						default:
						System.out.println("Oopps!That wasn't a Valid Choice ");
						System.out.println(" Plase try again and choose the valid option");
						break;
							
						
					    }
					while(!(answer.equals("no")));
					
						
				}
				
			}
			
}



