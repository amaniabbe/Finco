package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import model.*;

public class EntryDAO implements IEntryDAO{
	
	List<IEntry> entries;
	String url = "jdbc:sqlite:finco/src/Storage/FincoDatabase.db";
	
	
	public EntryDAO(List<IEntry> entries) {
		this.entries = entries;
		this.init();
	}
	
	public EntryDAO() {
		this.entries = new ArrayList<>();
	    this.init();
	}
	
	void init() {
		
		String sql = "CREATE TABLE IF NOT EXISTS entry (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name text NOT NULL,\n"
                + "	description text\n"
                + ");";
                
		
		
			try (Connection conn = DriverManager.getConnection(url);
	                Statement stmt = conn.createStatement()) {
	            // create a new table
				stmt.execute(sql);
				
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
			
		
	}

	@Override
	public List<IEntry> getAllcustomers() {
		
		String sql = "SELECT * FROM entry;";
		try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // get all values a new table
			ResultSet rs = stmt.executeQuery(sql);
			//insert all table data to list
			
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		
		return entries;
	}

	@Override
	public boolean updateCustomer(IEntry costomer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomer(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCustomer(IEntry customer) {
		// TODO Auto-generated method stub
		return false;
	}
}
