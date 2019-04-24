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
                + " accountnumber text,\n"
                + "	description text,\n"
                + " date text \n"
                + ");";
                
		
		
			try (Connection conn = DriverManager.getConnection(url);
	                Statement stmt = conn.createStatement()) {
	            // create a new table
				stmt.execute(sql);
				
	        } catch (SQLException e) {
	            System.out.println("entry init: " + e.getMessage());
	        }
			
		
	}

	@Override
	public List<IEntry> getAllentries() {
		
		IEntry entry;
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
				//entry.getDate().toString()	Tue Apr 23 16:50:30 CDT 2019	

			    Date date1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(date);
				entry = new Entry(date1, description, amount,accountnumber);
				entries.add(entry);

			
			}
			
			
        } catch (Exception e) {
            System.out.println("entry select: " +e.getMessage());
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
                + " accountnumber,"
                + "	description,"
                + " date) "
			    +  "VALUES(?,?,?,?)";

		try ( Connection conn = DriverManager.getConnection(url)) {
				
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//System.out.println("data is " + entry.accountNumber());
		    // Set the values
			pstmt.setDouble(1, entry.amount());
			pstmt.setString(2, entry.accountNumber());
			pstmt.setString(3, entry.getDescription());

			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss") ;
			pstmt.setString(4, f.format(entry.getDate()));
		    
		    // Insert 
		    pstmt.executeUpdate();

		} catch (SQLException e) {
            System.out.println("addEntry: " +e.getMessage());
        }
		return false;
	}
}
