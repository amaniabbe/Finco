package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
                + "	noofemployess int\n"
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
	public List<ICompany> getAllcustomers() {
		String sql = "SELECT * FROM company;";
		try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // get all values a new table
			ResultSet rs = stmt.executeQuery(sql);
			//insert all table data to companies list
			
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
		// TODO Auto-generated method stub
		return false;
	}

}
