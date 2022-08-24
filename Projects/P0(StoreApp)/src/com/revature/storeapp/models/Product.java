package com.revature.storeapp.models;



import com.revature.storeapp.exception.InvalidPriceException;

public class Product {
	private int  ProductID;
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
	
	public Product(int ProductID,String brand,String category,int price,int quantity)
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
	


	@Override
	public String toString() {
		return "Product [ProductID=" + ProductID + ", brand=" + brand + ", price=" + price + ", category=" + category
				+ ", quantity=" + quantity + ", Store=" + Store + ", StoreLocation=" + StoreLocation + "]";
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
