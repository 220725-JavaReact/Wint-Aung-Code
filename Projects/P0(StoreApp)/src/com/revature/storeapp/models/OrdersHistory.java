package com.revature.storeapp.models;

public class OrdersHistory {
	private String OrderHistoryID;
	private String UserName;
	private String OrderDate;
	private int TotalAmount;
	
	
	
	
	
	
	public OrdersHistory(String OrderHistoryID,String UserName,String OrderDate,int TotalAmount)
	{
	this.OrderHistoryID=OrderHistoryID;
	this.UserName=UserName;
	this.OrderDate=OrderDate;
	this.TotalAmount=TotalAmount;
		
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






	@Override
	public String toString() {
		return "OrdersHistory [UserName=" + UserName + ", OrderDate=" + OrderDate + ", TotalAmount=" + TotalAmount
				+ "]";
	}

}