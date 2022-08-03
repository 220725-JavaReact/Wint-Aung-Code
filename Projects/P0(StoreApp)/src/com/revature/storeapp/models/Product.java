package com.revature.storeapp.models;

public class Product {

	private String productName;
	private int price;
	private String category;
	private int quantity;
	
	public Product(String productName,int price,String category,int quantity)
	{
		
		
	}
	public Product()
	{
		this.productName=productName;
		this.price=price;
		this.category=category;
		this.quantity=quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", price=" + price + ", category=" + category + ", quantity="
				+ quantity + "]";
	}
	
	
}
