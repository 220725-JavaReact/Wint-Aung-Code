package com.revature.dao;

import java.util.List;
import java.util.Optional;

import com.revature.model.Inventory;

public class InventoryService {

	private ProductDAO<Inventory>inventoryDAO;
	public InventoryService (ProductDAO<Inventory>inventoryDAO)
	{
		this.inventoryDAO=inventoryDAO;
	}
	public List<Inventory> getAllIventory()
	
	{
		return inventoryDAO.getAllInstance();
	}

	public Inventory getInventoryByPID(int id) {
		// TODO Auto-generated method stub
		List<Inventory>listofInventory=getAllIventory();
		Optional<Inventory>foundInventory=listofInventory.stream()
				.filter(inventroy -> inventroy.getInventoryID()==id)
				.findFirst();
		if(foundInventory.isPresent())
		{
			return foundInventory.get();
		}
		
		else {
			Inventory inv=new Inventory();
			return null;}
	}
	public Inventory getInventoryByStoreId(int pid) {
		// TODO Auto-generated method stub
		List<Inventory>listofInventory=getAllIventory();
		Optional<Inventory>foundInventory=listofInventory.stream()
				.filter(inventroy -> inventroy.getInventoryID()==pid)
				.findFirst();
		if(foundInventory.isPresent())
		{
			return foundInventory.get();
		}
		
		else {
			Inventory inv=new Inventory();
			return null;}
		
	}
	public Inventory getInventoryByCategory(String Category) {
		// TODO Auto-generated method stub
		List<Inventory>listofInventory=getAllIventory();
		Optional<Inventory>foundInventory=listofInventory.stream()
				.filter(inventroy -> inventroy.getCategory()==Category)
				.findFirst();
		if(foundInventory.isPresent())
		{
			return foundInventory.get();
		}
		
		else {
			Inventory inv=new Inventory();
			return null;}
	}public Inventory getInventoryByBrand(String Brand) {
		// TODO Auto-generated method stub
		List<Inventory>listofInventory=getAllIventory();
		Optional<Inventory>foundInventory=listofInventory.stream()
				.filter(inventroy -> inventroy.getBrand()==Brand)
				.findFirst();
		if(foundInventory.isPresent())
		{
			return foundInventory.get();
		}
		
		else {
			Inventory inv=new Inventory();
			return null;}
	}
	public Inventory getInventoryByPrice(int Price) {
		// TODO Auto-generated method stub
		List<Inventory>listofInventory=getAllIventory();
		Optional<Inventory>foundInventory=listofInventory.stream()
				.filter(inventroy -> inventroy.getPrice()==Price)
				.findFirst();
		if(foundInventory.isPresent())
		{
			return foundInventory.get();
		}
		
		else {
			Inventory inv=new Inventory();
			return null;}
	}public Inventory getInventoryByLocation(String Location) {
		// TODO Auto-generated method stub
		List<Inventory>listofInventory=getAllIventory();
		Optional<Inventory>foundInventory=listofInventory.stream()
				.filter(inventroy -> inventroy.getLocation()==Location)
				.findFirst();
		if(foundInventory.isPresent())
		{
			return foundInventory.get();
		}
		
		else {
			Inventory inv=new Inventory();
			return null;}
	}public Inventory getInventoryById(String Store) {
		// TODO Auto-generated method stub
		List<Inventory>listofInventory=getAllIventory();
		Optional<Inventory>foundInventory=listofInventory.stream()
				.filter(inventroy -> inventroy.getStore()==Store)
				.findFirst();
		if(foundInventory.isPresent())
		{
			return foundInventory.get();
		}
		
		else {
			Inventory inv=new Inventory();
			return null;}
	}public Inventory getInventoryById(int id) {
		// TODO Auto-generated method stub
		List<Inventory>listofInventory=getAllIventory();
		Optional<Inventory>foundInventory=listofInventory.stream()
				.filter(inventroy -> inventroy.getInventoryID()==id)
				.findFirst();
		if(foundInventory.isPresent())
		{
			return foundInventory.get();
		}
		
		else {
			Inventory inv=new Inventory();
			return null;}
	}
	
}
