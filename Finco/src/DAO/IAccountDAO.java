package DAO;

import java.util.List;

import model.IAccount;

public interface IAccountDAO {
	
	List<IAccount> getAllAccounts();
	boolean updateCustomer(IAccount account);
	boolean deleteCustomer(String name);
	boolean addAccount(IAccount account);

}
