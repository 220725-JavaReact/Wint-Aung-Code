package com.revature.storeapps.services;

import java.util.List;

import com.revature.storeapp.dl.ProductDAO;
import com.revature.storeapp.models.Product;

public class ProductService {

	private final ProductDAO productDAO2;
	public ProductService(ProductDAO productDao2)
	{
		this.productDAO2=productDao2;
	}
	public void register(Product product)
	{
		productDAO2.save(product);
		
	}
	public List<Product> getAllProducts()
	{
		return productDAO2.GetEverything();
	}
}
