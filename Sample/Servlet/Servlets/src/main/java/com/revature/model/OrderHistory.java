package com.revature.model;

public class OrderHistory 
{
	
	private int OrderHistoryID;
	private int InventoryID;
	private int StoreID;
	private int ProductID;
	private int OrderID;
	private String OrderDate;
	private String UserName;
	private double TotalAmount;
	
	
	
	public OrderHistory()
	{
		super();
	}
	
	public OrderHistory(String OrderDate,String UserName,double TotalAmount)
	{
		this.InventoryID=InventoryID;
		this.StoreID=StoreID;
		this.ProductID=ProductID;
		this.OrderDate=OrderDate;
		this.UserName=UserName;
		this.TotalAmount=TotalAmount;
	}
	
	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public int getOrderHistoryID() {
		return OrderHistoryID;
	}
	public void setOrderHistoryID(int orderHistoryID) {
		OrderHistoryID = orderHistoryID;
	}
	public int getInventoryID() {
		return InventoryID;
	}
	public void setInventoryID(int inventoryID) {
		InventoryID = inventoryID;
	}
	public int getStoreID() {
		return StoreID;
	}
	public void setStoreID(int storeID) {
		StoreID = storeID;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public double getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "OrderHistory [OrderHistoryID=" + OrderHistoryID + ", InventoryID=" + InventoryID + ", StoreID="
				+ StoreID + ", ProductID=" + ProductID + ", OrderDate=" + OrderDate + ", UserName=" + UserName
				+ ", TotalAmount=" + TotalAmount + "]";
	}
	
	

}


