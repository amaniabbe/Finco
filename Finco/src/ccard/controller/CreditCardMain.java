package ccard.controller;

import java.util.Date;

import ccard.model.CreditCard;
import controller.Finco;
import model.Entry;
import model.IAccount;
import model.ICustomer;

public class CreditCardMain extends Finco {

	public void createSilverAccount(ICustomer customer, String accountNumber, Date expirationDate) {
		CreditCardFactory.getFactory();
		IAccount account = CreditCardFactory.createSilverCard(customer, accountNumber, expirationDate);
		customer.addAccount(account);
	}

	public void createBronzeAccount(ICustomer customer, String accountNumber, Date expirationDate) {
		CreditCardFactory.getFactory();
		IAccount account = CreditCardFactory.createBronzeCard(customer, accountNumber, expirationDate);
		customer.addAccount(account);
	}

	public void createGoldAccount(ICustomer customer, String accountNumber, Date expirationDate) {
		CreditCardFactory.getFactory();
		IAccount account = CreditCardFactory.createGoldCard(customer, accountNumber, expirationDate);
		customer.addAccount(account);
	}

	public void chargeCard(String acountNumber, double amount) {
		IAccount account = findAccount(acountNumber);
		account.addEntry(new Entry(new Date(), "charge", amount));
		if (amount > 400) {
			account.getOwner().sendEMail();
		}
	}

	public double newBalance(IAccount card) {
		double previousBal = previousBalance(card);
		double totalCredits = totalCredits(card);
		double totalCharges = totalCurrentMonthCharges(card);

		return previousBal - totalCredits + totalCharges
				+ ((CreditCard) card).getMonthlyInterest() * (previousBal - totalCredits);
	}

	public double totalDue(IAccount card) {
		return ((CreditCard) card).getMinimumPayment() * newBalance(card);
	}

	public String generateBill() {
		String report = "";
		for (ICustomer customer : getCustomers()) {
			report += "Customer : " + customer.getNames();
			report += "\n--------------------------------\n";
			for (IAccount account : customer.getListOfAccounts()) {
				report += "Previous Balance : " + previousBalance(account) + "\n";
				report += "Total Charges    : " + totalCurrentMonthCharges(account) + "\n";
				report += "Total Credits    : " + totalCredits(account) + "\n";
				report += "New Balance      : " + newBalance(account) + "\n";
				report += "Total Due        : " + totalDue(account) + "\n\n";
			}
			report += "---------------------------------\n";
		}
		return report;
	}

	public double previousBalance(IAccount account) {
		int month = new Date().getMonth() + 1;
		return account.entries().stream().filter(x -> (x.getDate().getMonth()) + 1 < month).mapToDouble(x -> x.amount())
				.sum();
	}

	public double totalCurrentMonthCharges(IAccount account) {
		int month = new Date().getMonth() + 1;
		return account.entries().stream().filter(x -> x.getDescription().equals("charge"))
				.filter(y -> (y.getDate().getMonth() + 1) == month).mapToDouble(x -> x.amount()).sum();
	}

	public double totalCredits(IAccount account) {
		int month = new Date().getMonth() + 1;
		return account.entries().stream().filter(x -> x.getDescription().contains("Deposit"))
				.filter(y -> (y.getDate().getMonth() + 1) == month).mapToDouble(x -> x.amount()).sum();
	}

}
