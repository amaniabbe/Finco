package factory;

import model.Account;
import model.ICustomer;

public class AccountFactory {

	public Account createAccount(ICustomer customer, String accountNumber) {
		return new Account(customer, accountNumber,0.0);
	}

}
