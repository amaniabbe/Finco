package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public abstract class AbstractCustomer implements ICustomer {

	protected List<IAccount> accounts = new ArrayList<>();

	protected String names;

	protected String emailAddress;

	private Address address;

	public AbstractCustomer(String names, String emailAddress, Address address) {
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
		System.out.println("Email is sent to the customer");

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

	@Override
	public String getEMail() {
		return this.emailAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((names == null) ? 0 : names.hashCode());
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
		AbstractCustomer other = (AbstractCustomer) obj;
		if (accounts == null) {
			if (other.accounts != null)
				return false;
		} else if (!accounts.equals(other.accounts))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (names == null) {
			if (other.names != null)
				return false;
		} else if (!names.equals(other.names))
			return false;
		return true;
	}
	
	
	

}
