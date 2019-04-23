package ccard.model;

import java.util.Date;

import model.Account;
import model.ICustomer;

public class CreditCard extends Account {

	private Date expirationDate;

	private double monthlyInterest;

	private double minimumPayment;

	public CreditCard(ICustomer customer, String accountNumber) {
		super(customer, accountNumber);

	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public double getMonthlyInterest() {
		return monthlyInterest;
	}

	public void setMonthlyInterest(double monthlyInterest) {
		this.monthlyInterest = monthlyInterest;
	}

	public double getMinimumPayment() {
		return minimumPayment;
	}

	public void setMinimumPayment(double minimumPayment) {
		this.minimumPayment = minimumPayment;
	}
	
	public void charge(double amount) {
		this.balance = balance - amount;
	}

	@Override
	public void addInterest() {
		this.balance = balance + (balance * getMonthlyInterest());
	}

}
