package model;

public class Account extends AbstractAccount {

	public Account(ICustomer customer, String accountNumber,double balance) {
		addOwner(customer);
		this.accountNumber = accountNumber;
		this.owner = customer;
		this.interest = 0.02;
	}

	@Override
	public String getAccountNumber() {
		return this.accountNumber;
	}

	

}
