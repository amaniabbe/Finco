package DAO;

import model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements IAccountDAO{
	
	List<IAccount> accounts;
	String url = "jdbc:sqlite:finco/src/Storage/FincoDatabase.db";
	
	
<<<<<<< HEAD
	public AccountDAO(List<IAccount> accounts) {
=======
	public AccountDAO(List<IAccount> accounts){
>>>>>>> 359e26a52301ba4fc6f4f05f036957332f3e473f
		
		this.accounts = accounts;
		this.init();
	}
	
<<<<<<< HEAD
    public AccountDAO() {
=======
    public AccountDAO(){
>>>>>>> 359e26a52301ba4fc6f4f05f036957332f3e473f
		
		this.accounts = new ArrayList<>();
		this.init();
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
		String sql = "CREATE TABLE IF NOT EXISTS account (\n"
                	 + "id integer PRIMARY KEY AUTOINCREMENT,\n"
                     + "accountnumber text NOT NULL,\n"
                     + "balance double ,\n"
                     + "owner text"
                     + ");";		
		
			try (Connection conn = DriverManager.getConnection(url);
	                Statement stmt = conn.createStatement()) {
	            // create a new table
				stmt.execute(sql);
				
	        } catch (SQLException e) {
	            System.out.println("account init: " + e.getMessage());
	        }		
	}


	@Override
	public List<IAccount> getAllAccounts() {
<<<<<<< HEAD
=======
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
>>>>>>> 359e26a52301ba4fc6f4f05f036957332f3e473f
		String sql = "SELECT * FROM account;";
		try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // get all values a new table
			ResultSet rs = stmt.executeQuery(sql);
			//insert all table data to companies list
			
			IAccount account;
			String accountnumber;
			Double balance;
			String owner, dateofbirth;
			
			while(rs.next()) {
				accountnumber = rs.getString("accountnumber");
				owner = rs.getString("owner");
				balance = rs.getDouble("balance");
			
				
				
				account = new Account(new Person(owner, null,null,null),accountnumber,balance);
<<<<<<< HEAD
				
=======
				if(!accounts.contains(account))
>>>>>>> 359e26a52301ba4fc6f4f05f036957332f3e473f
				accounts.add(account);				
			}
			
        } catch (SQLException e) {
            System.out.println("account select: " +e.getMessage());
        }
		return accounts;
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
	public boolean addAccount(IAccount account) {
<<<<<<< HEAD
=======
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
>>>>>>> 359e26a52301ba4fc6f4f05f036957332f3e473f
		String sql = "INSERT INTO account("
                + "accountnumber,"
                + "balance,"
                + "owner) "
			    +  "VALUES(?,?,?)";
		try ( Connection conn = DriverManager.getConnection(url)) {
				
			PreparedStatement pstmt = conn.prepareStatement(sql);

		    // Set the values
			pstmt.setString(1, account.getAccountNumber());
			pstmt.setDouble(2, account.getBalance());
			pstmt.setString(3, account.getOwner().getNames());
		    
		    // Insert 
		    pstmt.executeUpdate();

		} catch (SQLException e) {
            System.out.println("addAccount: " + e.getMessage());
        }
		return false;
	}
	
	

}
