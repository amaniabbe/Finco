package model;

public interface IAccount {

	double getBalance();

	boolean addEntry(IEntry entry);

	boolean depositMoney();

	boolean addOwner(ICustomer customer);

	ICustomer getOwner();

	void notifyObservers();

	boolean deleteAccount();

}
