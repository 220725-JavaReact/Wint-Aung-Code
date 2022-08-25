package com.revature.storeapp.UI;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.Objects;

import com.revature.storeapp.dl.CustomerDAO;
import com.revature.storeapp.dl.CustomerDBDAO;
import com.revature.storeapp.dl.DAO;
import com.revature.storeapp.dl.InventoryDAO;
import com.revature.storeapp.dl.OrderHistoryDAO;
import com.revature.storeapp.dl.OrdersDAO;
import com.revature.storeapp.dl.PDAO;
import com.revature.storeapp.dl.StoreDAO;
import com.revature.storeapp.exception.InvalidUerException;
import com.revature.storeapp.models.Customer;
import com.revature.storeapp.models.Inventory;
import com.revature.storeapp.models.Orders;
import com.revature.storeapp.models.OrdersHistory;
import com.revature.storeapp.models.Store;
import com.revature.storeapps.services.CustomerService;
import com.revature.storeapps.services.InventoryService;
import com.revature.storeapps.util.Logger;
import com.revature.storeapps.util.Logger.LogLevel;

public class ShoppingMenu 
{
private static final int InventoryID = 0;
private static DAO<Orders> orderDAO= new OrdersDAO();
private static DAO<Customer>customerDAO2 = new CustomerDBDAO();/// without array
private static DAO<Customer>customerDAO=new CustomerDAO();//with array
private static PDAO<Store>storeDAO= new StoreDAO();

private static Customer customer;
private static PDAO <Inventory>inventoryDAO=new InventoryDAO();
private static DAO<OrdersHistory> orderHistoryDAO= new OrderHistoryDAO();
private static CustomerService customerService;

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
					//System.out.println("[2] - Order History");
					//System.out.println("[2] - Order History");
					System.out.println("[3] - Exit");
					
					
					System.out.println("====================================================");
				
					userInput =scanner.nextLine().toUpperCase();
					switch(userInput)
					{			
					case"1":
//						System.out.println("Plase enter your User Name");
//						String UserName=scanner.nextLine();
//						
//						System.out.println("Plase enter your Password ");
//						String Password=scanner.nextLine();
//						try {
//												}
//						catch(InvalidUerException e)
//						{
//							System.out.println(e.getMessage());
//						}
						ShoppingItem();
						
					
										
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
						customerorderhistory();
						break;
					case "3":
						
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
	
	private  static void customerorderhistory()
	{
		System.out.println("Retrieving the list of member!!");
		Scanner scanner =new Scanner (System.in);
		List<Customer>custlist=customerDAO.GetEverything();
		List<OrdersHistory> allorderHisroty=orderHistoryDAO.GetEverything();
		
		System.out.println(custlist);
		System.out.println("/////////");
		System.out.println(allorderHisroty);
		

			
			
	
		
		
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
				
				for (Inventory inv:inventoryDAO.GetEverything())
				{
				System.out.println("====================================================");
				System.out.println(inv);
				System.out.println("ID         -  [" + inv.getProductID()+"]");
				System.out.println("Brand      -  ["  +inv.getBrand()+"]");
				System.out.println("Category   -  ["+inv.getCategory()+"]");
				System.out.println("Price      -  [" +inv.getPrice()+"]");
				System.out.println("Quantity   -  [" +inv.getQuantity()+"]");
				int inventoryQuntity=inv.getQuantity();
				System.out.println("Store      -  [" +inv.getStore()+"]");
				System.out.println("Location   -  [" +inv.getLocation()+"]");
				System.out.println("InventoryID   -  [" +inv.getInventoryID()+"]");
				
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
						int ProductID=scanner.nextInt();
					
						System.out.println("Plase enter  Quantity !! ");
						int Quantity =scanner.nextInt();
						int qty =inv.getQuantity();
							if (Quantity > qty)
						{
							System.out.println("Pleas enter valid amount ");
						}
							logger.log(LogLevel.info," Member choose the product ");
						System.out.println("This is the list of product you want to buy !!!!!!!");
						String Brand= inv.getBrand();
						int Price = inv.getPrice();
						String store =inv.getStore();
						int StoreID= Integer.valueOf(inv.getStoreID());
						String Category=inv.getCategory();
						String location =inv.getLocation();
						int inventoryID=inv.getInventoryID();
						
						int amount = (inv.getPrice() * Quantity);
						System.out.println("ProductID     -    [" +ProductID+"]" );
						System.out.println("InventoryID   -    [" +inventoryID+"]" );
						System.out.println("StoreID       -     [" +StoreID +"]");
						System.out.println("Brand         -   [" +Brand +"]");
						System.out.println("Category      -   [" +Category +"]");
						System.out.println("Quantity      -     [" +Quantity +"]");
						System.out.println("store         -  [" +store +"]");
						System.out.println("location      -   [" +location+"]" );
						System.out.println("Amount        -    [" +amount +"]");
						
						
						System.out.println("====================================================");
						
					
						
						List<Orders>orderList=new ArrayList<>();
						System.out.println("====================================================");
						
						
						//String username=customer.getUserName();
						System.out.println("==========================================================================");
						System.out.println("Hi" +UserName1+" You create the order!!!!");
						
						Orders order= new Orders(amount, Brand,Category,UserName1, StoreID,store, location, ProductID, Quantity,inventoryID);
						
						System.out.println(order);
						orderList.add(order);
						
						
							System.out.println("\n Press *** [ Y ]*** to coninue  !");
						
							
							String ans=scanner.nextLine().toUpperCase();
							if(Objects.equals(scanner.nextLine(), "Y"))
							{	System.out.println("==========================================================================");
							System.out.println(order);
							orderDAO.save(order);
								int sum=0;
								for(Orders item:orderList)
								{
									System.out.println(item.partialToString()+"\n");
									sum+=item.getAmount() *item.getQuantity();
								}
								System.out.println("Total: $ "+sum);
								System.out.println("Buy (y/n):");
								System.out.println("==========================================================================");
								
								switch(scanner.nextLine().toUpperCase())
								{
									case "y":
									case "Y":
										//System.out.println("Date insert");
										java.util.Date date=Calendar.getInstance().getTime();
										//java.util.Date date=Calendar.getInstance().getTime();
										DateFormat dateFormat= new SimpleDateFormat("mm-dd-yyyy");
										String strDate=dateFormat.format(date);
										currentInventory=inventoryQuntity-Quantity;
										int StoreId=inv.getStoreID();
										int InventoryID=inv.getInventoryID();
										
										//System.out.println(" order register");
										
										System.out.println("==========================================================================");
										System.out.println("Order History Of  " +UserName1);
										
										System.out.println(" You bought this item");
										System.out.println("====================================================================");
										System.out.println("[1]UserName      :  " +UserName1);
										System.out.println("[2]Date          :  "+ strDate);
										System.out.println("[3]StoreID       :  "+StoreID);
										System.out.println("[4]InventoryID   :  "+inventoryID);
									
										OrdersHistory orderHistory=new OrdersHistory(UserName1, strDate, sum ,StoreID,inventoryID,ProductID);
										System.out.println(orderHistory);
										orderHistoryDAO.save(orderHistory);
										System.out.println("====================================================================");
										System.out.println("Successfullly save and we will let you know for shippment update");
										
										System.out.println("====================================================================");
									   //  int productid=Integer.valueOf(ProductID);
									   
										InventoryDAO.UpdateQuantity( currentInventory,inventoryID);
										
										
									
										ShoppingMenu.Start();
								      
									
								 
									
										
										break;
									case "n":
									case "N":
										 System.out.println(" you want to shop again y/n");
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



