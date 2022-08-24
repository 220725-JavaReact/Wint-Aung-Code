package com.revature.storeapp.models;

public class OrdersHistory {
	private String OrderHistoryID;
	private String UserName;
	private String OrderDate;
	private int TotalAmount;
	private int InventoryID;
	private String StoreID;
	private String ProductID;
	
	
	
	
	
	
	
	
	public OrdersHistory(String UserName,String OrderDate,int TotalAmount,int InventoryID,String StoreID,String ProductID)
	{
	this.OrderHistoryID=OrderHistoryID;
	this.ProductID=ProductID;
	this.UserName=UserName;
	this.OrderDate=OrderDate;
	this.TotalAmount=TotalAmount;
	this.InventoryID=InventoryID;
	this.StoreID=StoreID;
	}


    public OrdersHistory(String userName1, String strDate, int sum, String storeID2, int inventoryID2,
			String productID2) {
		// TODO Auto-generated constructor stub
	}


	public void OrderHistory(String InventoryID,String StoreID,String ProductID,int Quantity)
    {
    	InventoryID =InventoryID;
    	StoreID=StoreID;
    	ProductID=ProductID;
    	Quantity=Quantity;
    }



	public String getOrderHistoryID() {
		return OrderHistoryID;
	}






	public void setOrderHistoryID(String orderHistoryID) {
		OrderHistoryID = orderHistoryID;
	}






	public String getUserName() {
		return UserName;
	}






	public String getProductID() {
		return ProductID;
	}


	public void setProductID(String productID) {
		ProductID = productID;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}






	public String getOrderDate() {
		return OrderDate;
	}






	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}






	public int getTotalAmount() {
		return TotalAmount;
	}






	public void setTotalAmount(int totalAmount) {
		TotalAmount = totalAmount;
	}


	public int getInventoryID() {
		return InventoryID;
	}


	public void setInventoryID(int inventoryID) {
		InventoryID = inventoryID;
	}


	public String getStoreID() {
		return StoreID;
	}


	public void setStoreID(String storeID) {
		StoreID = storeID;
	}


	}


	
	
	


	





	





	
