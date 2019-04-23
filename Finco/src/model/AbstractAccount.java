package model;

import java.util.ArrayList;
import java.util.List;

public  class AbstractAccount implements IAccount {

	protected String accountNumber;

	protected double balance;

	protected ICustomer owner;

	protected double interest;

	protected List<IEntry> entries = new ArrayList<>();

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public boolean addEntry(IEntry entry) {
		return this.entries.add(entry);
	}

	@Override
	public boolean addOwner(ICustomer customer) {
		this.owner = customer;
		return true;
	}

	@Override
	public ICustomer getOwner() {
		return this.owner;
	}

	@Override
	public void notifyObservers() {
		this.owner.sendEMail();
	}

	@Override
	public boolean deleteAccount() {
		return false;
	}

	@Override
	public boolean depositMoney(double amount) {
		if (amount > 0) {
			this.balance = balance + amount;
			return true;
		}
		return false;
	}

	@Override
	public boolean withdraw(double amount) {
		if (amount > 0) {
			this.balance = balance - amount;
			return true;
		}
		return false;
	}

	@Override
	public void addInterest() {
		this.balance = balance + (balance * interest);
		
		this.getOwner().sendEMail();
	}

	@Override
	public String getAccountNumber() {
		return this.accountNumber;
	}

	@Override
	public List<IEntry> entries() {
		return entries;
	}

	@Override
	public void setInterest(double percentage) {
		this.interest = percentage;
	}

}
