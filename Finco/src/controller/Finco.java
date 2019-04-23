package controller;

import java.util.*;

import model.Account;
import model.Address;
import model.Entry;
import model.IAccount;
import model.ICustomer;
import model.IEntry;

public class Finco {

	private List<ICustomer> customers = new ArrayList<>();

	public static void main(String args[]) {

	}

	public void createPerson(Address address, String names, String emailAddress) {
		CustomerFactory.getFactory();
		ICustomer customer = CustomerFactory.createPerson(names, emailAddress, address);
		customers.add(customer);
	}

	public void createCompany(Address adress, String names, String emailAddress, Integer numberOfEmployees) {
		CustomerFactory.getFactory();
		ICustomer customer = CustomerFactory.createCompany(names, emailAddress, numberOfEmployees, adress);
		customers.add(customer);
	}

	public void addCompanyAccount(ICustomer customer, String accountNumber) {
		AccountFactory.getFactory();
		IAccount account = AccountFactory.createAccount(customer, accountNumber);
		customer.addAccount(account);
		System.out.println("the current list is :" + customers.size());
	}

	public void addPersonalAccount(ICustomer customer, String accountNumber) {
		AccountFactory.getFactory();
		IAccount account = AccountFactory.createAccount(customer, accountNumber);
		customer.addAccount(account);
	}

	public ICustomer findCustomer(String names) {
		Optional<ICustomer> op = customers.stream().filter(x -> x.getNames().equals(names)).findFirst();
		return op.isPresent() ? op.get() : null;
	}

	public IAccount findAccount(String accountNumber) {
		Optional<IAccount> account = customers.stream().flatMap(x -> x.getListOfAccounts().stream())
				.filter(y -> y.getAccountNumber().equals(accountNumber)).findFirst();
		return account.isPresent() ? account.get() : null;

	}

	public String depositAmountCompany(String accountNumber, double amount) {
		IAccount account = findAccount(accountNumber);
		if (account != null) {
			IEntry entry = new Entry(new Date(), "Deposit made", amount);
			account.depositMoney(amount);
			account.addEntry(entry);
			account.notifyObservers();
			return "Amount is successfully deposed on account for  :" + account.getOwner().getNames();
		}
		return "Unknown Account";
	}

	public String depositAmountPersonal(String accountNumber, double amount) {
		IAccount account = findAccount(accountNumber);
		if (account != null) {
			IEntry entry = new Entry(new Date(), "Deposit made", amount);
			account.depositMoney(amount);
			account.addEntry(entry);
			if (amount > 500) {
				account.notifyObservers();
			}
			return "Amount is successfully deposed on account for  :" + account.getOwner().getNames();
		}
		return "Unknown Account";
	}

	public String withDrwalCompany(String accountNumber, double amount) {
		IAccount account = findAccount(accountNumber);
		if (account != null) {
			IEntry entry = new Entry(new Date(), "Withdraw made", amount);
			account.withdraw(amount);
			account.addEntry(entry);
			account.notifyObservers();
			return "Amount is successfully withdrawen on account for  :" + account.getOwner().getNames();
		}
		return "Unknown Account";
	}

	public String withDrwalPersonal(String accountNumber, double amount) {
		IAccount account = findAccount(accountNumber);
		if (account != null) {
			IEntry entry = new Entry(new Date(), "Withdraw made", amount);
			account.withdraw(amount);
			account.addEntry(entry);
			if (account.getBalance() < 0) {
				account.getOwner().sendEMail();
			}
			return "Amount is successfully withdrawen on account for  :" + account.getOwner().getNames();
		}
		return "Unknown Account";
	}

	public void addInterest() {
		customers.stream().flatMap(x -> x.getListOfAccounts().stream()).forEach(IAccount::addInterest);
	}

	public List<ICustomer> getCustomers() {
		return customers;
	}
	
	

}
