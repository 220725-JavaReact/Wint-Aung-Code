package com.revature.storeapp.models;

public class Orders {
	
	int OrderID;
	int ProductID;
	String Brand;
	double Price;
	int Quantity;
	public Orders()
	{
		
	}
	
	public Orders(int OrderID,int ProductID,String Brand,double Price,int Quantity)
	{
		this.OrderID=OrderID;
		this.ProductID=ProductID;
		this.Brand=Brand;
		this.Price=Price;
		this.Quantity=Quantity;
		
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
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
		return "Orders [OrderID=" + OrderID + ", ProductID=" + ProductID + ", Brand=" + Brand + ", Price=" + Price
				+ ", Quantity=" + Quantity + "]";
	}
	public String partialToString()
	{
		return "Brand:"+Brand+"\n Price:"+Price+"\n Quantity:" +Quantity;
	}

}
