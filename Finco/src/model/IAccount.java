package model;

import java.util.List;

public interface IAccount {

	double getBalance();

	boolean addEntry(IEntry entry);

	boolean depositMoney(double amount);
	
	boolean withdraw(double amount);

	boolean addOwner(ICustomer customer);

	ICustomer getOwner();

	void notifyObservers();

	boolean deleteAccount();
	
	void addInterest();
	
	String getAccountNumber();
	
	List<IEntry> entries();
	
	void setInterest(double percentage);
	
	void setBalance(double balance);

}
