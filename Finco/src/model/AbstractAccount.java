package model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAccount implements IAccount {

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

	@Override
	public void setBalance(double balance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((entries == null) ? 0 : entries.hashCode());
		temp = Double.doubleToLongBits(interest);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractAccount other = (AbstractAccount) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (entries == null) {
			if (other.entries != null)
				return false;
		} else if (!entries.equals(other.entries))
			return false;
		if (Double.doubleToLongBits(interest) != Double.doubleToLongBits(other.interest))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}
	
	
}
