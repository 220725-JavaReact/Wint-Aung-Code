package com.revature.storeapp.UI;


import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

import com.revature.storeapp.dl.CustomerDAO;
import com.revature.storeapp.dl.CustomerDBDAO;
import com.revature.storeapp.dl.DAO;
import com.revature.storeapp.dl.InventoryDAO;
import com.revature.storeapp.dl.PDAO;
import com.revature.storeapp.dl.ProductDAO;
import com.revature.storeapp.dl.ProductDBDAO;
import com.revature.storeapp.dl.StoreDAO;
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
import com.revature.storeapps.util.annotations.Inject;

public class PlaceOrderMenu  {
	private static DAO<Customer>customerDAO2 = new CustomerDBDAO();
	private static DAO<Customer>customerDAO=new CustomerDAO();
	private static DAO<Customer>customerDao2=new CustomerDBDAO();
	private static PDAO<Product>productDAO2=new ProductDAO();
	private static PDAO<Store>storeDAO= new StoreDAO();
	private static PDAO<Inventory>inventoryDAO=new InventoryDAO();
	private static DAO<Product>productDAO=new ProductDBDAO();
	private static Logger logger=Logger.getLogger();
	private static ProductService productService ;
	private static InventoryService inventoryService;
	private static Customer customer ;
	private static StoreService storeService;
	
	public static void PlaceOrderMenu()
	{   
		Scanner scan=new Scanner(System.in);
		String userInput="";
	  logger.log(LogLevel.info,"Starting APP");
	 
	        exit:
	        {
	            while (true) {
	               // System.out.println("\n" + drawHorizontalLine("| Welcome to admin menu  |", customer.getUserName()));
	              //  System.out.println("| Welcome to admin menu " + customer.getUserName() + " |");
	              //  System.out.println(drawHorizontalLine("| Welcome to admin menu  |", customer.getUserName()));
	                System.out.println("[1] Create store");
	                System.out.println("[2] Create product");
	                System.out.println("[3] Add product to store");
	                System.out.println("[4] Delete store");
	                System.out.println("[x] Sign out");

	                System.out.print("\nEnter: ");

	                switch (scan.nextLine()) {
	                    case "1":
	                        createStore();
	                        break;
	                    case "2":
	                        //createProduct();
	                        break;
	                    case "3":
	                        createInventory();
	                        break;
	                    case "4":
	                        deleteStore();
	                        break;
	                    case "x":
	                        break exit;
	                    default:
	                        System.out.println("\nInvalid input.");
	                        break;
	                }
	            }
	        }
	    }

	    private  static void createStore() {
	        Scanner scan = new Scanner(System.in);
	        Store store = new Store();

	        store.setStoreID(UUID.randomUUID().toString());

	        exit:
	        {
	            while (true) 
	            {
	            	System.out.println("\n====================================================================");
	                System.out.println("==================     Building a new Store        =================== |");
	                System.out.println("====================================================================\n");

	                System.out.print("Store Name    -   ");
	                store.setStoreName(scan.nextLine().toUpperCase());

	                
	                	System.out.print("\nCity/ Location - ");
	                    store. setLocation( scan.nextLine().toUpperCase());
	                    System.out.print("\nCity/ Description  - ");
	                    store.setDescription(scan.nextLine());
	                   // Store store=new Customer(FirstName,LastName,UserName,Password,Email);
	                    
	                   

	                


	                System.out.println("\nPlease confirm new store (y/n)");
	                System.out.println("\n This is the information of your store" + store);
	                
	                String choice=scan.nextLine();
	                switch (choice) {
	                    case "y":
	                      //storeService.register(store);
	                    	StoreDAO storeDAO=new StoreDAO();
		                    storeDAO.addInstance(store);
							System.out.println(store);
							
							//customerDAO.addInstance(customer);
							System.out.println("==================================================================");
							System.out.println("****************Succssfully Saved !!!*************\n");
							System.out.println("==================================================================");		

	                        break exit;
	                    case "n":
	                    	
	                    	
	                        break;
	                    default:
	                        System.out.println("\nInvalid input.");
	                        break;
	                }
	            }
	        }
	    }

	 
	    public static void createInventory(){
	        Scanner scan = new Scanner(System.in);
	        Inventory inventory = new Inventory();


	        exit:
	        {
	            while (true) {
	                System.out.println("\n+-----------------------------+");
	                System.out.println("|  Adding product to store ...  |");
	                System.out.println("+-------------------------------+");

	                //ask admin what product they with to add
	                //provide list of products
	                //ask admin how many products
	                //ask admin what store they wish to add to
	                //provide list of stores
	                //get store id and add to inventory
	                //get product id and add to inventory
	                //add quantity to inventory

	                List<Product> allProducts = new ArrayList<>();
	                int prodInput;

	                while(true)
	                {
	                    System.out.println("What product would you like to add?");
	                    allProducts =productDAO2.GetEverything();
//	                    for (Product product:productDAO.getAll())
//	    				{
//	    					System.out.println(product);
//	    				}
	    					//System.out.println("Please choose your pick up store location!");
	    				

	                    for(int i = 0; i < allProducts.size(); i++){
	                        System.out.println("[ " + (i + 1) + " ]" + allProducts.get(i).getBrand());
	                    }

	                    System.out.println("Enter: ");
	                    prodInput = scan.nextInt() - 1;

	                    if(prodInput < 0 || prodInput >= allProducts.size()){
	                        System.out.println("Invalid input. Try again.");
	                    }else{
	                    	inventory.setProductID(allProducts.get(prodInput).getProductID());
	                     
	                        break;
	                    }
	                }

	                List<Store> allStores=new ArrayList<>();
	                int storeInput;
	                               

	                System.out.println("How many products would you like to add? ");
	                int quantity = scan.nextInt();
	                inventory.setQuantity(quantity);

	               
	                while(true){
	                    System.out.println("What store would you like to add to?");
	                    allStores = storeDAO.GetEverything();
                           // System.out.println(allStores);
	                    for(int i = 0; i < allStores.size(); i++){
	                    	 System.out.println("=======================================================");
	                        System.out.println("[ " + (i + 1) + " ]" + allStores.get(i).getStoreName());
	                        System.out.println("[ " + (i + 1) + " ]" + allStores.get(i).getLocation());
	                        System.out.println("=======================================================");
	                    }
	                    System.out.println("Enter: ");
	                    storeInput = scan.nextInt() - 1;

	                    if(storeInput < 0 || storeInput >= allStores.size()){
	                        System.out.println("Invalid input. Try again.");
	                    }else{
	                    	inventory.setStoreID(allStores.get(storeInput).getStoreID());
	                       
	                        scan.nextLine();
	                        break;
	                    }
	                }


	                System.out.println("\nPlease confirm updates (y/n)");
	                
	                System.out.println("Product: "+  allProducts.get(prodInput).getBrand());//
	                String Brand= allProducts.get(prodInput).getBrand();
	                
	                System.out.println("Store: "+  allProducts.get(storeInput).getStore());
	                String Store=( allProducts.get(storeInput).getStore());
	                System.out.println("Store: "+  allProducts.get(prodInput).getProductID());
	                String productID=allProducts.get(prodInput).getProductID();
	                System.out.println("Store: "+  allStores.get(storeInput).getLocation());
	                String Location =(allStores.get(storeInput).getLocation());
	                System.out.println("Price: "+  allProducts.get(prodInput).getPrice());
	                int Price = allProducts.get(prodInput).getPrice();
	                System.out.println("Quantity: "+  inventory.getQuantity());
	                

	                switch (scan.nextLine()) {
	                    case "y":
	                       // inventoryService.register(inventory);
	                    	
	                    	String ProductID=inventory.getProductID();
	                    	String StoreID=inventory.getStoreID();	 
	                           	int qty=inventory.getQuantity();
	                    	Inventory inv=new Inventory(Brand, Store, Location, Price, qty,productID,StoreID);
	                    	
	                    	           	
	                    	
	                    	inventoryDAO.save(inv);
	                    	System.out.println( "Brand :"+ProductID + "StoreID:" +StoreID +"Brand :"+Brand +"Store"+ Store+"Lcoaiton:"+Location+"Price"+Price+"Qty"+ qty);
	                        break exit;
	                    case "n":
	                        break;
	                    default:
	                        System.out.println("\nInvalid input.");
	                        break;
	                }
	            }
	        }
	    }

	    private static void deleteStore(){
	        Scanner scan = new Scanner(System.in);
	        Store store = new Store();

	        exit:
	        {
	            while (true) {
	                System.out.println("Which store do you want to delete: ");
	                List<Store> allStores = storeService.getAllStores();

	                for (int i = 0; i < allStores.size(); i++) {
	                    System.out.println("[ " + (i + 1) + " ]" + allStores.get(i).getLocation());
	                }
	                System.out.println("Enter: ");
	                int input = scan.nextInt() - 1;
	                scan.nextLine();


	                if (input < 0 || input >= allStores.size()) {
	                    System.out.println("Invalid input. Try again.");
	                } else {
	                    System.out.println("\nPlease confirm updates (y/n)");
	                    System.out.println("\n" + allStores.get(input).getLocation());

	                    switch (scan.nextLine()) {
	                        case "y":
	                        	storeService.delete(allStores.get(input).getStoreID());
	                           
	                            break exit;
	                        case "n":
	                            break;
	                        default:
	                            System.out.println("\nInvalid input.");
	                            break;
	                    }
	                }
	            }
	        }


	    }

	    private static String drawHorizontalLine(String msg, String nameLength) 
	    {
	        int len = msg.length() + nameLength.length();
	        StringBuilder sb = new StringBuilder();

	        for (int i = 0; i < len; i++) {
	            if (i == 0 || i == len - 1) sb.append("+");
	            else sb.append("-");
	        }

	        return sb.toString();
	    }
	
	
	
	

	
	
	
	
	}
