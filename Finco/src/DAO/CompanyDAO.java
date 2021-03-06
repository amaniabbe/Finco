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
<<<<<<< HEAD
=======
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
>>>>>>> 359e26a52301ba4fc6f4f05f036957332f3e473f
		String sql = "CREATE TABLE IF NOT EXISTS company (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name text NOT NULL,\n"
                + "	email text NOT NULL,\n"
                + "	noofemployees int, \n"
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
	            System.out.println("company init: " + e.getMessage());
	        }
			
		
		
	}
	
	@Override
	public List<ICompany> getAllcustomers() {
<<<<<<< HEAD
=======
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
>>>>>>> 359e26a52301ba4fc6f4f05f036957332f3e473f
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
			
			//rs.last();
			
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
<<<<<<< HEAD
=======
				if(!companies.contains(company))
>>>>>>> 359e26a52301ba4fc6f4f05f036957332f3e473f
				companies.add(company);
								
			}
			
        } catch (SQLException e) {
            System.out.println("company select: " + e.getMessage());
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
		
<<<<<<< HEAD
=======
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
>>>>>>> 359e26a52301ba4fc6f4f05f036957332f3e473f
		String sql = "INSERT INTO company("
				+ "	name,"
                + "	email,"
                + "	noofemployees,"
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
            System.out.println("addCompany: " +e.getMessage());
        }

		
		return true;
	}

}
