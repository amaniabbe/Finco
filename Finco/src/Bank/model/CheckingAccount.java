package Bank.model;

import model.Account;
import model.ICustomer;

public class CheckingAccount extends Account{

	public CheckingAccount(ICustomer customer, String accountNumber) {
		super(customer, accountNumber,0.0);
		setInterest(0.09);
	}

}
