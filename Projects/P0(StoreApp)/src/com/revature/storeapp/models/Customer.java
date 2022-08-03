package com.revature.storeapp.models;

public class Customer {
	private String userName;
	private String email;
	private String phone;
	private String orderlist;
	
	private boolean valid=false;
	
	
	public Customer(String userName,String email,String phone,String orderlist)
	{
		this.userName=userName;
		this.email=email;
		this.phone=phone;
		this.orderlist=orderlist;
		//valid=valid;
	}
	public Customer (String userName)
	
	{
		this.userName=userName;
		userName="";
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(String orderlist) {
		this.orderlist = orderlist;
	}
	@Override
	public String toString() {
		return "Customer [userName=" + userName + ", email=" + email + ", phone=" + phone + ", orderlist=" + orderlist
				+ "]";
	}
	
	
	
	
	


	
}
