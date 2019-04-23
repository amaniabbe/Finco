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
	
	List<Entry> entries;
	String url = "jdbc:sqlite:finco/src/Storage/FincoDatabase.db";
	
	
	public EntryDAO(List<Entry> entries) {
		this.entries = entries;
	}
	
	public EntryDAO() {
		this.entries = new ArrayList<>();
	}
	
	void init() {
		
		String sql = "CREATE TABLE IF NOT EXISTS person (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name text NOT NULL,\n"
                + "	description text\n"
                + ");";
                
		
		try {
			try (Connection conn = DriverManager.getConnection(url);
	                Statement stmt = conn.createStatement()) {
	            // create a new table
				stmt.execute(sql);
				
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<IEntry> getAllcustomers() {
		// TODO Auto-generated method stub
		return null;
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
