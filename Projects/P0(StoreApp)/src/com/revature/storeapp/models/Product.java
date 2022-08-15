package com.revature.storeapp.models;



import com.revature.storeapp.exception.InvalidPriceException;

public class Product {
	private String  ProductID;
	private String brand;
	private int price;
	private String category;
	private int quantity;
	private String Store;
	private String StoreLocation;
	
	public Product()
	{
		super();
	}
	
	public Product(String ProductID,String brand,String category,int price,int quantity)
	{this.ProductID=ProductID;
		this.brand=brand;
		this.price=price;
		this.category=category;
		this.quantity=quantity;
	
		
		
	}
	public Product(String brand,String category,int price,int quantity)
	{
		this.brand=brand;
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
		this.Store=Store;
		this.StoreLocation=StoreLocation;
		
	}
	public String getProductID() {
		return ProductID;
	}
	public void setProductID(String ProductID) {
		ProductID = ProductID;
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
	
	public String getStore() {
		return Store;
	}

	public void setStore(String store) {
		Store = store;
	}

	public String getStoreLocation() {
		return StoreLocation;
	}

	public void setStoreLocation(String storeLocation) {
		StoreLocation = storeLocation;
	}

	

	@Override
	public String toString() {
		return "Product [ProductID=" + ProductID + ", brand=" + brand + ", price=" + price + ", category=" + category
				+ ", quantity=" + quantity + "]";
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
