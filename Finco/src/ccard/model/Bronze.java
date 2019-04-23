package ccard.model;

import java.util.Date;

import model.ICustomer;

public class Bronze extends CreditCard {

	public Bronze(ICustomer customer, String accountNumber,Date expirationDate) {
		super(customer, accountNumber);
		setMonthlyInterest(0.1);
		setMinimumPayment(0.14);
		setExpirationDate(expirationDate);
	}

}
