package com.revature.storeapp.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.storeapp.models.Inventory;
import com.revature.storeapp.models.OrdersHistory;
import com.revature.storeapps.util.ConnectionFactory;

public class InventoryDAO implements PDAO <Inventory>{

	@Override
	public void addInstance(Inventory newInstance) {
		// TODO Auto-generated method stub
		
		try (Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query="Update Inventory set Quantity = ? where InventoryID = ? and where ProductID =? ";
			PreparedStatement preparedStatement =connection.prepareStatement(query);
			
			preparedStatement.setInt(1,newInstance.getQuantity());
			
			
//			preparedStatement.setString(2,newInstance.getBrand());
//			preparedStatement.setString(3,newInstance.getStore());
//			preparedStatement.setString(4,newInstance.getStoreID());
//			preparedStatement.setString(5,newInstance.getLocation());
//			preparedStatement.setInt(6,newInstance.getPrice());
//			preparedStatement.setString(7,newInstance.getProductID());
//			preparedStatement.setString(8,newInstance.getCategory());
			
			
			//preparedStatement.setInt(6, updatedInstance.getCustomerID());
			preparedStatement.executeUpdate();
			
			}
		catch(SQLException e)
		{
			throw new RuntimeException("Found an error when the inventory update into database"); 
		}
		
	}

	@Override
	public Inventory getByName(String UserName) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Inventory[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void UpdateInstance(Inventory newInstance) {
		// TODO Auto-generated method stub\
		
		try (Connection connection =ConnectionFactory.getInstance().getConnection())
		{
			String query="Update Inventory set Quantity = ? where InventoryID = ? ";
			PreparedStatement preparedStatement =connection.prepareStatement(query);
			
			preparedStatement.setInt(1,newInstance.getQuantity());
			preparedStatement.setInt(2,1);
			//preparedStatement.setString(3,newInstance.getInventoryID());
			//preparedStatement.setString(4,newInstance.getStore());
			//preparedStatement.setString(5,newInstance.getLocation());
			//preparedStatement.setString(6,newInstance.getCategory());
			//preparedStatement.setString(7,newInstance.getBrand());
			//preparedStatement.setInt(8,newInstance.getPrice());
			//preparedStatement.setInt(6, updatedInstance.getCustomerID());
			preparedStatement.executeUpdate();
			
			}
		catch(SQLException e)
		{
			//throw new RuntimeException("Found an error when the inventory update into database"); 
		  e.printStackTrace();
		}
		
	}

	

	@Override
	public void save(Inventory obj) {
		// TODO Auto-generated method stub
		
		try(Connection connection = ConnectionFactory.getInstance().getConnection())
		{
			
			PreparedStatement preparedStatement=connection.prepareStatement("Insert Into Inventory(Brand,Store,Location,Price,Quantity,ProductID,StoreID,Category)values(?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, obj.getBrand());
			preparedStatement.setString(2, obj.getStore());	
			preparedStatement.setString(3,obj.getLocation());
			preparedStatement.setInt(4,obj.getPrice());
			preparedStatement.setInt(5,obj.getQuantity());
			preparedStatement.setString(6, obj.getProductID());
			preparedStatement.setString(7, obj.getStoreID());
			preparedStatement.setString(8, obj.getCategory());
			preparedStatement.execute();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("An error occured when creat an order into the database ");
		}
		
	}

	public void update(Inventory obj) {
		// TODO Auto-generated method stub
		

		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("Update  Inventory  set  Quantity = ? where InventoryID=? ");
			preparedstatement.setInt(1,obj.getQuantity());
			
			preparedstatement.executeUpdate();
			
			}
		catch(SQLException e)
		{
			throw new RuntimeException("Found an error when the inventory update into database"); 
		}
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Inventory getByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inventory> GetEverything() {
		// TODO Auto-generated method stub
		List<Inventory> inventories=new ArrayList<>();
		try (Connection connection = ConnectionFactory.getInstance().getConnection()){
			PreparedStatement preparedstatement=connection.prepareStatement("Select * from Inventory");
			ResultSet rs=preparedstatement.executeQuery();
			
			while(rs.next())
			{
				inventories.add(new Inventory(rs.getInt("InventoryID"),rs.getString("Brand"),rs.getString("Category"),rs.getString("StoreID"),rs.getString("Store"),rs.getString("Location"),rs.getInt("Price"),rs.getInt("Quantity"),rs.getString("ProductID")));
				
			}
		}
		catch(SQLException e)
		{
			throw new RuntimeException("An error  occured to inject the data into the database.");
		}
		
		return inventories;

		
		
		
	}
	public List<String> getAllStoreID()
	{ List<String>storeID=new ArrayList<>();
		try (Connection connection = ConnectionFactory.getInstance().getConnection())
		{
			
			PreparedStatement preparedstatement=connection.prepareStatement("Select StoreID From Inventory");
			ResultSet rs=preparedstatement.executeQuery();
			
			while(rs.next())
			{
				storeID.add(rs.getString("StoreID"));
			}
		}
		catch(SQLException e)
		{
			throw new RuntimeException("An error  occured to inject the data into the database.");
		}
		
		return storeID;
	}
	public  static void UpdateQuantity(int Quantity,int InventoryID)
	{
		
		try (Connection connection = ConnectionFactory.getInstance().getConnection())
		{
			PreparedStatement preparedstatement=connection.prepareStatement("Update Inventory set Quantity=? where InventoryID=?");
			preparedstatement.setInt(1, Quantity);
			
			preparedstatement.setInt(2, InventoryID);
			
			preparedstatement.executeUpdate();
			
			}
		catch(SQLException e)
		{
			e.printStackTrace();
			//throw new RuntimeException("Found an error when the inventory update into database"); 
		}
	}

	@Override
	public Inventory getByInvID(String InventoryID) {
		// TODO Auto-generated method stub
		try 
		(Connection connection = ConnectionFactory.getInstance().getConnection())
		{
			
			PreparedStatement preparedstatement=connection.prepareStatement("Select * from  Inventory where InventoryID=? ");
			preparedstatement.setString(1,InventoryID);
			
			preparedstatement.executeUpdate();
			
			}
		catch(SQLException e)
		{
 
		}
		return null;
	}

	@Override
	public void update(int currentInventory, int ProductID) {
		// TODO Auto-generated method stub
		
	}

	

	
	
	

}
