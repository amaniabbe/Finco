package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

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
                + " amount DOUBLE,\n"
                + "	description text\n"
                + " date text, \n"
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
		
		IEntry entry;
		String name;
		double amount;
		String description;
		String date;
		
		String sql = "SELECT * FROM entry;";
		try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // get all values a new table
			
			ResultSet rs = stmt.executeQuery(sql);
			//insert all table data to list
			
			while(rs.next()) {
				name = rs.getString("name");
				amount = rs.getDouble("amount");
				description = rs.getString("description");
				date = rs.getString("date");
			    Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
				entry = new Entry(date1, description, amount);
				entries.add(entry);
				
				rs.next();
			}
			
			
        } catch (Exception e) {
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
