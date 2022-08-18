package com.revature.storeapp.models;

public class OrdersHistory {
	private String OrderHistoryID;
	private String UserName;
	private String OrderDate;
	private int TotalAmount;
	private String InventoryID;
	private String StoreID;
	private String ProductID;
	
	
	
	
	
	
	
	
	public OrdersHistory(String UserName,String OrderDate,int TotalAmount,String InventoryID,String StoreID,String ProductID)
	{
	this.OrderHistoryID=OrderHistoryID;
	this.ProductID=ProductID;
	this.UserName=UserName;
	this.OrderDate=OrderDate;
	this.TotalAmount=TotalAmount;
	this.InventoryID=InventoryID;
	this.StoreID=StoreID;
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


	public String getInventoryID() {
		return InventoryID;
	}


	public void setInventoryID(String inventoryID) {
		InventoryID = inventoryID;
	}


	public String getStoreID() {
		return StoreID;
	}


	public void setStoreID(String storeID) {
		StoreID = storeID;
	}


	
	
	


	





	





	
}