package ccard.model;

import java.util.Date;

import model.ICustomer;

public class Silver extends CreditCard {

	public Silver(ICustomer customer, String accountNumber, Date expirationDate) {
		super(customer, accountNumber);
		setMonthlyInterest(0.08);
		setMinimumPayment(0.12);
		setExpirationDate(expirationDate);
	}

}
