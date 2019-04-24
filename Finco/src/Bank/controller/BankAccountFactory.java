package Bank.controller;

import Bank.model.CheckingAccount;
import Bank.model.SavingAccount;
import model.ICustomer;

public class BankAccountFactory {

	static BankAccountFactory factory = null;
	

	public static CheckingAccount createCheckingAccount(ICustomer customer, String accountNumber) {
		return new CheckingAccount(customer, accountNumber);
	}

	public static SavingAccount createSavingAccount(ICustomer customer, String accountNumber) {
		return new SavingAccount(customer, accountNumber);
	}

	public static BankAccountFactory getFactory() {
		if (factory == null) {
			factory = new BankAccountFactory();
		}
		return factory;
	}

}
