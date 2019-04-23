
package DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Address;
import model.Company;
import model.ICompany;
import model.IPerson;
import model.Person;

public class PersonDAO implements IPersonDAO{
	
	private List<IPerson> persons ;
	String url = "jdbc:sqlite:finco/src/Storage/FincoDatabase.db";
	
	public PersonDAO(List<IPerson> customers) {
	
		this.persons = customers;
	}
	
	public PersonDAO() {
		this.persons = new ArrayList<>();
		this.init();
		
	}
	
	void init() {	
		String sql = "CREATE TABLE IF NOT EXISTS person (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name text NOT NULL,\n"
                + "	dateofbirth text,\n"
                + "	email text,\n"
                + "	state text,\n"
                + "	city text,\n"
                + "	street text,\n"
                + "	zipcode text\n"
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
		
		String sql = "SELECT * FROM person;";
		try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // get all values a new table
			ResultSet rs = stmt.executeQuery(sql);
			
			//insert all table data to companies list
			IPerson person;
			String name;
			String dateofbirth, state ,  city , street, zipcode;
			String emailAddress;
			Address address;
			
			while(!rs.next()) {
				name = rs.getString("name");
				emailAddress = rs.getString("email");
				dateofbirth = rs.getString("dateofbirth");
				state = rs.getString("state");
				city = rs.getString("city");
				street = rs.getString("street");
				zipcode = rs.getString("zipcode");
				address = new Address();
				address.setCity(city);
				address.setState(state);
				address.setStreet(street);
				address.setZipCode(zipcode);
				
				
				person = new Person(name,emailAddress,address);
				persons.add(person);
				
				
			}
			
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		
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
		String sql = "INSERT INTO person("
				+ "	name,"
                + "	dateofbirth,"
                + "	email,"
                + "	state,"
                + "	city,"
                + "	street,"
                + "	zipcode) "
			    +  "VALUES(?,?,?,?,?,?,?)";
		try ( Connection conn = DriverManager.getConnection(url)) {
				
			PreparedStatement pstmt = conn.prepareStatement(sql);

		    // Set the values
		    pstmt.setString(1, customer.getNames());
		    pstmt.setString(2, customer.getDateofBirth().toString());
		    pstmt.setString(3, customer.getEMail());	    
		    pstmt.setString(4, customer.getAddress().getState());
		    pstmt.setString(5, customer.getAddress().getCity());
		    pstmt.setString(6, customer.getAddress().getStreet());
		    pstmt.setString(7, customer.getAddress().getZipCode());
		    
		    // Insert 
		    pstmt.executeUpdate();

		} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return true;
	}

}
