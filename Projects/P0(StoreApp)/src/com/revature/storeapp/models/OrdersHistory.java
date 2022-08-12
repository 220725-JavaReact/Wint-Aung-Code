package com.revature.storeapp.models;

public class OrdersHistory {
	private int OrderHistoryID;
	private String CustomerID;
	private String OrderDate;
	private double TotalAmount;
	
	public OrdersHistory(int OrderHistoryID,int CustomerID,String OrderDate,double TotalAmount)
	{ this.OrderHistoryID =OrderHistoryID;
	this.CustomerID=CustomerID;
	this.OrderDate=OrderDate;
	this.TotalAmount=TotalAmount;
		
	}

	public int getOrderHistoryID() {
		return OrderHistoryID;
	}

	public void setOrderHistoryID(int orderHistoryID) {
		OrderHistoryID = orderHistoryID;
	}

	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}

	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}

	public double getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "OrdersHistory [OrderHistoryID=" + OrderHistoryID + ", CustomerID=" + CustomerID + ", OrderDate="
				+ OrderDate + ", TotalAmount=" + TotalAmount + "]";
	}
	

}
