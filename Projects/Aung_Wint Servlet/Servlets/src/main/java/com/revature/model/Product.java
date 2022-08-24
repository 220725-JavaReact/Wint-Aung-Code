package com.revature.model;

public class Product {
	  private int ProductID;
	  private String ProductName;
	  private String Category;
	  private double Price;
	  private int Quantity ;
	  
	  public Product()
	  {
		  super();
	  }

	  public Product(String ProductName,String Category, double Price, int Quantity)
	  {
		  this.ProductName=ProductName;
		  this.Category=Category;
		  this.Price=Price;
		  this.Quantity=Quantity;
		
	  }

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [ProductID=" + ProductID + ", ProductName=" + ProductName + ", Category=" + Category
				+ ", Price=" + Price + ", Quantity=" + Quantity + "]";
	}
	  
	  
	  
}
