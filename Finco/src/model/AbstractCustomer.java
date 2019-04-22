package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public abstract class AbstractCustomer implements ICustomer {

	protected List<IAccount> accounts = new ArrayList<>();

	protected String names;

	protected String emailAddress;
	
	
	 public AbstractCustomer(String names,String emailAddress) {
		this.names = names;
		this.emailAddress = emailAddress;
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
	public ICustomer getCustomer(String name) {
		return null;
	}

}
