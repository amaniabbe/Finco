package controller;

import java.util.*;

import DAO.SystemDAOmanager;
import model.Address;
import model.Entry;
import model.IAccount;
import model.ICustomer;
import model.IEntry;

public class Finco {

	protected SystemDAOmanager daoManager;

	protected List<ICustomer> customers;

	public List<ICustomer> persons = new ArrayList<>();

	public Finco() {
		daoManager = new SystemDAOmanager();
		customers = daoManager.customers();
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

	public void depositAmountCompany(IAccount account, double amount) {
		if (account != null) {
			IEntry entry = new Entry(new Date(), "Deposit made", amount, account.getAccountNumber());
			account.depositMoney(amount);
			account.addEntry(entry);
			account.notifyObservers();
		}
	}

	public void depositAmountPersonal(IAccount account, double amount) {
		if (account != null) {
			IEntry entry = new Entry(new Date(), "Deposit made", amount, account.getAccountNumber());
			account.depositMoney(amount);
			account.addEntry(entry);
			if (amount > 500) {
				account.notifyObservers();
			}
		}

	}

	public void withDrwalCompany(IAccount account, double amount) {
		if (account != null) {
			IEntry entry = new Entry(new Date(), "Withdraw made", amount, account.getAccountNumber());
			account.withdraw(amount);
			account.addEntry(entry);
			account.notifyObservers();
		}
	}

	public void withDrwalPersonal(IAccount account, double amount) {
		if (account != null) {
			IEntry entry = new Entry(new Date(), "Withdraw made", amount, account.getAccountNumber());
			account.withdraw(amount);
			account.addEntry(entry);
			if (account.getBalance() < 0) {
				account.getOwner().sendEMail();
			}
		}
	}

	public void deposit(String accountNumber, double amount, String type) {
		IAccount account = findAccount(accountNumber);
		if (account != null && type.equalsIgnoreCase("Company")) {
			depositAmountCompany(account, amount);
		} else if (account != null && type.equalsIgnoreCase("Person")) {
			depositAmountPersonal(account, amount);
		} else {
			System.out.println("Not found");
		}
	}

	public void withdraw(String accountNumber, double amount, String type) {
		IAccount account = findAccount(accountNumber);
		if (account != null && type.equals("Company")) {
			withDrwalCompany(account, amount);
		} else if (account != null && type.equals("Person")) {
			withDrwalPersonal(account, amount);
		}
	}

	public void addInterest() {
		customers.stream().flatMap(x -> x.getListOfAccounts().stream()).forEach(IAccount::addInterest);

	}

	public List<ICustomer> getCustomers() {
		return customers;
	}

}
