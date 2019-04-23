package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
                + " amount DOUBLE,\n"
                + " accountnumber DOUBLE,\n"
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
		String accountnumber;
		String description;
		String date;
		
		String sql = "SELECT * FROM entry;";
		try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // get all values a new table
			
			ResultSet rs = stmt.executeQuery(sql);
			//insert all table data to list
			
			while(rs.next()) {
				amount = rs.getDouble("amount");
				description = rs.getString("description");
				date = rs.getString("date");
				accountnumber = rs.getString("accountnumber");
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
	public boolean addEntry(IEntry entry) {
		String sql = "INSERT INTO entry("
                + " amount,"
                + "	description,"
                + " date) "
			    +  "VALUES(?,?,?,?)";
		try ( Connection conn = DriverManager.getConnection(url)) {
				
			PreparedStatement pstmt = conn.prepareStatement(sql);

		    // Set the values
			pstmt.setDouble(1, entry.amount());
			pstmt.setString(2, entry.getDescription());
			pstmt.setString(3, entry.getDate().toString());
		    
		    // Insert 
		    pstmt.executeUpdate();

		} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return false;
	}
}
