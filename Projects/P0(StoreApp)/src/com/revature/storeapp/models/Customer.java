package com.revature.storeapp.models;

public class Customer {
	private int CustomerID;
	private String FirstName;
	private String LastName;
	private String UserName;
	private String Password;
	private String Email;
	
	
	
	
	public Customer(String UserName)
	{   this.FirstName=FirstName;
		this.LastName=LastName;
		this.UserName=UserName;
		this.Password=Password;
		this.Email=Email;
		 
		
		
		//valid=valid;
	}
	
	public Customer(String FirstName,String LastName,String UserName,String Password,String Email)
	{
		this.FirstName=FirstName;
		this.LastName=LastName;
		this.UserName=UserName;
		this.Password=Password;
		this.Email=Email;
		this.CustomerID=CustomerID;
		 
		
	}
	public Customer ()
	{
		this.UserName="admin";
		this.Password="admin";
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		this.UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return " [Your first Name is ----" + FirstName + "]\n [Your Last Name is----" + LastName
				+ "]\n [Your UserName is:" + UserName + "]\n [Your Password is:" + Password + "]\n [Your Email is:" + Email + "]";
		
	}

	
	
}