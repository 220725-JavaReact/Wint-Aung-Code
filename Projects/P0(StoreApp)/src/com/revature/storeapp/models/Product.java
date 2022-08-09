package com.revature.storeapp.models;

import com.revature.pointsapp.exceptions.InvalidPointException;
import com.revature.restrev.exception.InvalidRatingException;
import com.revature.storeapp.exception.InvalidPriceException;

public class Product {
	private int ProductID;
	private String brand;
	private int price;
	private String category;
	private int quantity;
	
	public Product(String brand,String category,int price,int quantity)
	{
		this.brand=brand;
		this.price=price;
		this.category=category;
		this.quantity=quantity;
	
		
		
	}
	public Product(String brand,String category,int price,int quantity,int productID)
	{
		this.brand=brand;
		this.ProductID=ProductID;
		this.price=price;
		this.category=category;
		this.quantity=quantity;
	
		
		
	}
	public Product(String Brand)
	{
		this.brand=brand;
		this.ProductID=ProductID;
		this.price=price;
		this.category=category;
		this.quantity=quantity;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
//		if (price < 0 || price >1000) 
//			
//			throw new InvalidPriceException ("Invalid Price . pls enter between 0 and 1000");
//	
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
	public int addPrice( int Price)
	{
		if(Price == 0 )throw new InvalidPriceException("You can't add nothing .You either give points or you take em away");
		 this.price+=price;
		 return this.price;
	}
	public int addPrice(PriceCategories category)
	{
		this.price += category.value;
		return this.price;
	}
	@Override
	public String toString() {
		return "Product [brand=" + brand + ", price=" + price + ", category=" + category + ", quantity=" + quantity
				+ "]";
	}
	public enum PriceCategories
	{
		COmputer(1000),Desktop(1000),Monitor(500),Camera(3000),Accessories(300),Laptop(Integer.MIN_VALUE);
		public final int value;
		private PriceCategories(int value)
		{
			this.value=value;
		}
	}
	
	
	
}
