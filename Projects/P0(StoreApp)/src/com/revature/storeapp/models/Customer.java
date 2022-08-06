package com.revature.storeapp.models;

public class Customer {
	private String CustomerID;
	private String FirstName;
	private String LastName;
	private String UserName;
	private String Password;
	private String Email;
	
	
	
	
	public Customer(String userName)
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
		 
		
	}
	public Customer ()
	{
		this.UserName="admin";
		this.Password="admin";
	}

	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
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
		return "Customer [ FirstName=" + FirstName + ", LastName=" + LastName
				+ ", UserName=" + UserName + ", Password=" + Password + ", Email=" + Email + "]";
	}

	
	
}