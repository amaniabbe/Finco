package DAO;

import java.util.List;

import model.IAccount;

public interface IAccountDAO {
	
	List<IAccount> getAllcustomers();
	boolean updateCustomer(IAccount costomer);
	boolean deleteCustomer(String name);
	boolean addCustomer(IAccount customer);

}
