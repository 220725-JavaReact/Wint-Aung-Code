package com.revature.model;

public class OrderHistory 
{
	
	private int OrderHistoryID;
	private int InventoryID;
	private int StoreID;
	private int ProductID;
	private String OrderDate;
	private String UserName;
	private int TotalAmount;
	
	public OrderHistory()
	{
		super();
	}
	
	public OrderHistory(int InventoryID,int StoreID,int ProductID, String OrderDate,String UserName,int TotalAmount)
	{
		this.InventoryID=InventoryID;
		this.StoreID=StoreID;
		this.ProductID=ProductID;
		this.OrderDate=OrderDate;
		this.UserName=UserName;
		this.TotalAmount=TotalAmount;
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
	public int getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		TotalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "OrderHistory [OrderHistoryID=" + OrderHistoryID + ", InventoryID=" + InventoryID + ", StoreID="
				+ StoreID + ", ProductID=" + ProductID + ", OrderDate=" + OrderDate + ", UserName=" + UserName
				+ ", TotalAmount=" + TotalAmount + "]";
	}
	
	

}


