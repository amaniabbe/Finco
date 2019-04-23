package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public abstract class AbstractCustomer implements ICustomer {

	protected List<IAccount> accounts = new ArrayList<>();

	protected String names;

	protected String emailAddress;
	
	private Address address;
	
	
	 public AbstractCustomer(String names,String emailAddress,Address address) {
		this.names = names;
		this.emailAddress = emailAddress;
		this.address = address;
	}

	@Override
	public boolean addAccount(IAccount account) {
		return accounts.add(account);
	}

	@Override
	public boolean removeAccount(IAccount account) {
		return accounts.remove(account);
	}

	@Override
	public void sendEMail() {
		System.out.println("Email is sent to the customer with emailAddress  :" + emailAddress);

	}

	@Override
	public List<IAccount> getListOfAccounts() {
		return this.accounts;
	}

	
	@Override
	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
