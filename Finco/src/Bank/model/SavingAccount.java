package Bank.model;

import model.Account;
import model.ICustomer;

public class SavingAccount extends Account {

	public SavingAccount(ICustomer customer, String accountNumber) {
		super(customer, accountNumber,0.0);
		setInterest(0.08);
	}

}
