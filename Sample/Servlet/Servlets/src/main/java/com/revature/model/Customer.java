package com.revature.model;


public class Customer {
	
 private int CustomerID;
 private String FirstName;
 private String LastName;
 private String UserName;
 private String Password;
 
 public  Customer()
 { super();
 	}
 public Customer( String firstName, String lastName, String userName, String password) {

		
		FirstName = firstName;
		LastName = lastName;
		UserName = userName;
		Password = password;
	}
 
public Customer(int CustomerID,String UserName,String Password)
{
this.CustomerID=CustomerID;
this.UserName=UserName;
this.Password=Password;
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
	UserName = userName;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
@Override
public String toString() {
	return "Customer [  FirstName=" + FirstName + ", LastName=" + LastName + ", UserName="
			+ UserName + ", Password=" + Password + "]";
}
 
 
 

}
