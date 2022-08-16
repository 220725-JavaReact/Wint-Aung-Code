package com.revature.storeapp.UI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

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


public class PlaceOrderMenu {
	private static DAO<Customer>customerDAO2 = new CustomerDBDAO();/// without array
	private static DAO<Customer>customerDAO=new CustomerDAO();//with array
	private static PDAO<Product>productDAO=new ProductDAO(); // without array storage
	private static DAO<Product>productDAO2=new ProductDBDAO(); // from array
	private static DAO<OrdersHistory> ordershistoryDAO=new OrderHistoryDAO();
	private static DAO<Orders> orderDAO= new OrdersDAO();
	private static PDAO<Store>storeDAO= new StoreDAO();
	private static PDAO<Inventory>inventoryDAO=new InventoryDAO();

	private static Logger logger=Logger.getLogger();

	private static StoreService storeService;
	
	
	

	public PlaceOrderMenu(Customer customer, Orders order, CustomerService customerService, StoreService storeService2,
			ProductService productService, OrderService orderService, InventoryService inventoryService,
			OrderHistoryService orderHistoryService) {
		// TODO Auto-generated constructor stub
	}
	public static void Start()
	{
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String userInput="";
		System.out.println("Please enter user name");
		String UserName1=scan.nextLine();
		System.out.println("Please enter password");
		String Password1=scan.nextLine();
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
	                System.out.println("[4] View Purchase History");
	                System.out.println("[5] Order List");
	                System.out.println("[6] Order List");
	                System.out.println("[7] Customer List");
	                System.out.println("[8] Inventory");
	                System.out.println("[9] Products ");
	                System.out.println("[10] Update  store");
		               
		               
		               
		               
		               
		               
	                System.out.println("[x] Sign out");
	                logger.log(LogLevel.info," admin choose the option");
	                System.out.print("\nEnter: ");

	                switch (scan.nextLine()) {
	                    case "1":
	                        createStore();
	                        logger.log(LogLevel.info," admin create the store");
	                        break;
	                    case "2":
	                        createProduct();
	                        break;
	                    case "3":
	                        createInventory();
	                        logger.log(LogLevel.info," admin choose to create the inventory");
	                        break;
	                    case "4":
	                    	for (OrdersHistory orderHistory:ordershistoryDAO.GetEverything())
	        				{
	        					System.out.println(orderHistory);
	        					System.out.println("====================================================");
	        					System.out.println("UserName          -  ["  + orderHistory.getUserName()+"]" );
	        					System.out.println("HistoryID          -  ["+orderHistory.getOrderHistoryID()+"]");
	    						System.out.println("Date      -    [" +orderHistory.getOrderDate()+"]");
	    						
	    						System.out.println("Amount       -  ["+orderHistory.getTotalAmount()+"]");
	    						System.out.println("====================================================\n");
	    					
	        				}
	                        logger.log(LogLevel.info," admin delete the store");
	                        break;
	                    case "5":

	        				for (Orders order:orderDAO.GetEverything())
	        				{
	        					//System.out.println(order);
	        					//System.out.println(orderHistory);
	        					System.out.println("====================================================");
	        					//System.out.println("OrderID    -    [" +order.getOrderID()+"]");
	    						System.out.println("ProductID    -        [" +order.getProductID()+"]");
	    						//System.out.println("StoreID      -    [" +order.getStoreID()+"]");
	        					   System.out.println("UserName     -  ["  + order.getUserName()+"]" );
	        					System.out.println("Brand       -  ["+order.getBrand()+"]");
	    						//System.out.println("Category    -    [" +order.getCategory()+"]");
	    					
	    						System.out.println("Store       -    [" +order.getStore()+"]");
	    						System.out.println("Location    -    [" +order.getLocation()+"]");
	    						
	    						System.out.println("Quantity    -  ["+order.getQuantity()+"]");
	    						System.out.println("Amount      -    [" +order.getAmount()+"]");
	    						
	    						System.out.println("====================================================\n");
	        				}
	                    	break;
	                    
	                    case "6":
	                    	break;
	                    
	                    case "7":
	                    	break;
	                    
	                    case "8":
	                    	break;
	                    
	                    case "9":
	                    	break;
	                    case "10":
	                    	break;
	                    
	                    case "x":
	                    	Menu.Open();
	                        break exit;
	                    default:
	                        System.out.println("\nInvalid input.");
	                        break;
	                }
	            }
	        }	
	}
	 private static void createProduct(){
	       


	        exit:
	        {
	            while (true) {
	            	
	            	 Scanner scanner = new Scanner(System.in);
	     	        Product product = new Product();
	            	System.out.println("Creating a Product registration");
					
					System.out.println("Plase enter your Brand");			
					String Brand=scanner.nextLine().toUpperCase();
					System.out.println("Plase enter your Category");
					String Category=scanner.nextLine();
					System.out.println("Plase enter your price ");
				   
			     	int price=Integer.parseInt(scanner.nextLine());
					System.out.println("Plase enter your Quantity");
					//Product productToUpdate=productDAO.getByName(userInput);
					int quantity=Integer.parseInt(scanner.nextLine());
					
						
					
					
				
					
				
				
						
				

	                System.out.println("\nPlease confirm updates (y/n)");
	                product=new Product(Brand, Category, price, quantity) 	;		
					productDAO2.addInstance(product);
	                System.out.println("\n" + product);
	                System.out.println("====================================================");
					System.out.println("****************Succssfully Saved !!!*************\n");
					System.out.println("====================================================");	

	                switch (scanner.nextLine()) {
	                    case "y":
	                      
	                    	
	                    	
	                    	
	                    	
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
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

	    private  static void createStore() {
	        Scanner scan = new Scanner(System.in);
	        Store store = new Store();
	        Product product=new Product();

	        store.setStoreID(UUID.randomUUID().toString());

	        exit:
	        {
	            while (true) 
	            {
	            	System.out.println("\n====================================================================");
	                System.out.println("==================     Building a new Store        =================== |");
	                System.out.println("====================================================================\n");
	                logger.log(LogLevel.info," admin buliding the new  store");
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
	                logger.log(LogLevel.info," admin add the product into  the store");
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
	                               
	                logger.log(LogLevel.info," admin add the quantity of the products into the store");
	                System.out.println("How many products would you like to add? ");
	                int quantity = scan.nextInt();
	                inventory.setQuantity(quantity);

	               
	                while(true){
	                	  logger.log(LogLevel.info," admin choose the store to add the products");
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

	                logger.log(LogLevel.info," ask the admin for confirm the inventory");
	                System.out.println("\nPlease confirm updates (y/n)");
	                
	                System.out.println("Product: "+  allProducts.get(prodInput).getBrand());//
	                String Brand= allProducts.get(prodInput).getBrand();
	                
	                System.out.println("Store: "+  allProducts.get(storeInput).getStore());
	                String Store=( allProducts.get(storeInput).getStore());
	                String Category= allProducts.get(storeInput).getCategory();
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
	                    	Inventory inv=new Inventory(Brand,Category,StoreID, Store, Location, Price, qty,productID);
	                    	
	                    	           	
	                    	
	                    	inventoryDAO.save(inv);
	                    	System.out.println( "Brand :"+ProductID + "StoreID:" +StoreID +"Brand :"+Brand +"Store"+ Store+"Lcoaiton:"+Location+"Price"+Price+"Qty"+ qty);
	                    	  logger.log(LogLevel.info," admin create the inventory");
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
	                    System.out.println("[ " + (i + 1) + " ]" + allStores.get(i).getStoreName());
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
