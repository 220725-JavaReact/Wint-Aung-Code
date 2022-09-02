package com.revature.dao;

import java.util.List;
import java.util.Optional;

import com.revature.model.Inventory;

public class CartService {

	private ProductDAO<Inventory>inventoryDAO;
	public CartService(ProductDAO<Inventory>inventoryDao)
	{
		this.inventoryDAO=inventoryDao;
	}
	public List<Inventory>getInventories()
	{
		return inventoryDAO.getAllInstance();
	}
	public Inventory getInventoryBYID(int id)
	{
		List<Inventory>listofInventory=getInventories();
		Optional<Inventory> foundInventory =listofInventory.stream()
				.filter(inventory -> inventory.getInventoryID() == id)
				.findFirst();
		if(foundInventory.isPresent())
		{
		return foundInventory.get();	
		}
		else {
			Inventory noInventory=new Inventory();
			noInventory.setBrand("Out Of Stock");
			return noInventory;
		}
	}
	public Inventory addInventory(Inventory inventory)
	{
		return inventoryDAO.addInstance(inventory);
	}
}
