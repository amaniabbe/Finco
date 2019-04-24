package Bank.controller;

import controller.Finco;
import model.IAccount;
import model.ICustomer;
import model.IPerson;

public class BankMain extends Finco {

	public void addCheckingAccount(ICustomer customer, String accountNumber) {
		BankAccountFactory.getFactory();
		IAccount account = BankAccountFactory.createCheckingAccount(customer, accountNumber);
		customer.addAccount(account);
		persons.add(customer);
		System.out.println("added");
	}

	public void addSavingAccount(ICustomer customer, String accountNumber) {
		BankAccountFactory.getFactory();
		IAccount account = BankAccountFactory.createSavingAccount(customer, accountNumber);
		customer.addAccount(account);
		persons.add(customer);
		System.out.println("added");
	}

}
