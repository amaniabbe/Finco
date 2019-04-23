
package DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.IPerson;

public class PersonDAO implements IPersonDAO{
	
	private List<IPerson> persons ;
	String url = "jdbc:sqlite:finco/src/Storage/FincoDatabase.db";
	
	public PersonDAO(List<IPerson> customers) {
	
		this.persons = customers;
	}
	
	public PersonDAO() {
		this.persons = new ArrayList<>();
		
	}
	
	void init() {	
		String sql = "CREATE TABLE IF NOT EXISTS person (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name text NOT NULL,\n"
                + "	dateofbirth text\n"
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
	public List<IPerson> getAllcustomers() {
		
		return persons;
	}

	@Override
	public boolean updateCustomer(IPerson customer) {
		
		return false;
	}

	@Override
	public boolean deleteCustomer(String name) {
		
       
		return false;
	}

	@Override
	public boolean addCustomer(IPerson customer) {
		persons.add(customer);
		return true;
	}

}
