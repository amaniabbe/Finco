package ccard.model;

import java.util.Date;

import model.ICustomer;

public class Gold extends CreditCard{

	public Gold(ICustomer customer, String accountNumber,Date expirationDate) {
		super(customer, accountNumber);
		setMonthlyInterest(0.06);
		setMinimumPayment(0.1);
		setExpirationDate(expirationDate);
	}

}
