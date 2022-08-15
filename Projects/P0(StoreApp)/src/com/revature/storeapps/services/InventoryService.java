package com.revature.storeapps.services;

import java.util.List;

import com.revature.storeapp.dl.InventoryDAO;
import com.revature.storeapp.dl.OrderHistoryDAO;
import com.revature.storeapp.models.Inventory;
import com.revature.storeapp.models.OrdersHistory;

public class InventoryService {

	private final InventoryDAO inventoryDAO;
	
	public  InventoryService(InventoryDAO inventoryDAO) {
		
		// TODO Auto-generated constructor stub
		this.inventoryDAO=inventoryDAO;
	}
	
	
	public void register(Inventory inventory)
	{
		inventoryDAO.save(inventory);
		
	}
	public List<Inventory> getAllInventory()
	
	{
	return inventoryDAO.GetEverything();	
	}
	public boolean InventoryExit(String StoreID)
	{
		List<String> inventories=inventoryDAO.getAllStoreID();
		return inventories.contains(StoreID);
	}
	public void Update( int Quantity)
	{
		inventoryDAO.UpdateQuantity( Quantity);
	}
}
