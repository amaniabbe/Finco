package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Address;
import model.Company;
import model.Entry;
import model.ICompany;

public class CompanyDAO  implements ICompanyDAO{

	
	
	private List<ICompany> companies ;
	String url = "jdbc:sqlite:finco/src/Storage/FincoDatabase.db";
	
	public CompanyDAO(List<ICompany> customers) {
	
		this.companies = customers;
	}
	
	public CompanyDAO() {
		this.companies = new ArrayList<>();
		init();
		
	}
	
	void init() {	
		String sql = "CREATE TABLE IF NOT EXISTS company (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name text NOT NULL,\n"
                + "	email text NOT NULL,\n"
                + "	noofemployess int\n"
                + "	state text,\n"
                + "	city text,\n"
                + "	street text,\n"
                + "	zipcode text\n"
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
	public List<ICompany> getAllcustomers() {
		String sql = "SELECT * FROM company;";
		try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // get all values a new table
			ResultSet rs = stmt.executeQuery(sql);
			
			//insert all table data to companies list
			ICompany company;
			String name;
			int numberofemployees;
			String emailAddress,state ,  city , street, zipcode;
			Address address;
			
			while(rs.next()) {
				name = rs.getString("name");
				emailAddress = rs.getString("email");
				numberofemployees = rs.getInt("noofemployees");
				state = rs.getString("state");
				city = rs.getString("city");
				street = rs.getString("street");
				zipcode = rs.getString("zipcode");
				address = new Address();
				address.setCity(city);
				address.setState(state);
				address.setStreet(street);
				address.setZipCode(zipcode);
				
				company = new Company(name,emailAddress,numberofemployees,address);
				companies.add(company);
				
				rs.next();
			}
			
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return companies;
	}

	@Override
	public boolean updateCustomer(ICompany costomer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomer(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCustomer(ICompany customer) {
		
		String sql = "INSERT INTO company("
				+ "	name,"
                + "	email,"
                + "	noofemployess,"
                + "	state,"
                + "	city,"
                + "	street,"
                + "	zipcode) "
			    +  "VALUES(?,?,?,?,?,?,?)";
		try ( Connection conn = DriverManager.getConnection(url)) {
				
			PreparedStatement pstmt = conn.prepareStatement(sql);

		    // Set the values
		    pstmt.setString(1, customer.getNames());
		    pstmt.setString(2, customer.getEMail());
		    pstmt.setInt(3, customer.getNumberOfEmployees());
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
