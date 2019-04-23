package model;

public interface IAccount {

	double getBalance();

	boolean addEntry(IEntry entry);

	boolean depositMoney(double amount);
	
	boolean withdraw(double amount);

	boolean addOwner(ICustomer customer);

	ICustomer getOwner();

	void notifyObservers();

	boolean deleteAccount();

}
