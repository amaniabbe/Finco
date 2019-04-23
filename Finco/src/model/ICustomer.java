package model;

import java.util.List;


public interface ICustomer {
	
	
	boolean addAccount(IAccount account);
	
	boolean removeAccount(IAccount account);
	
	void sendEMail();

	List<IAccount> getListOfAccounts();
	
	String getNames();
	
	Address getAddress();

}
