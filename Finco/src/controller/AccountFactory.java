package controller;

import model.Account;
import model.ICustomer;

public class AccountFactory {

	static AccountFactory factory = null;

	public static  Account createAccount(ICustomer customer, String accountNumber) {
		return new Account(customer, accountNumber,0.0);
	}

	public static AccountFactory getFactory() {
		if (factory == null) {
			factory = new AccountFactory();
		}
		return factory;
	}

}
