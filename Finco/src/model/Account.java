package model;

public class Account extends AbstractAccount {

	public Account(ICustomer customer, String accountNumber,double balance) {
		addOwner(customer);
		this.accountNumber = accountNumber;
		this.owner = customer;
	}

	@Override
	public String getAccountNumber() {
		return this.accountNumber;
	}

	

}
