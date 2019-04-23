package DAO;

import model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements IAccountDAO{
	
	List<Account> accounts;
	String url = "jdbc:sqlite:finco/src/Storage/FincoDatabase.db";
	
	
	public AccountDAO(List<Account> accounts) {
		
		this.accounts = accounts;
		this.init();
	}
	
    public AccountDAO() {
		
		this.accounts = new ArrayList<>();
		this.init();
	}
	
	void init() {	
		String sql = "CREATE TABLE IF NOT EXISTS account (\n"
                	 + "id integer PRIMARY KEY AUTOINCREMENT,\n"
                     + "accountnumber text NOT NULL,\n"
                     + "balance float ,\n"
                     + "owner text"
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
	public List<IAccount> getAllcustomers() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean updateCustomer(IAccount costomer) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean deleteCustomer(String name) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addCustomer(IAccount customer) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
