package ccard.controller;

import java.util.Date;

import ccard.model.Bronze;
import ccard.model.Gold;
import ccard.model.Silver;
import model.ICustomer;

public class CreditCardFactory {

	private static CreditCardFactory factory = null;

	

	public static Bronze createBronzeCard(ICustomer c, String accountNumber, Date expirationDate) {
		return new Bronze(c, accountNumber, expirationDate);
	}

	public static Gold createGoldCard(ICustomer customer, String accountNumber, Date expirationDate) {
		return new Gold(customer, accountNumber, expirationDate);
	}

	public static Silver createSilverCard(ICustomer customer, String accountNumber, Date expirationDate) {
		return new Silver(customer, accountNumber, expirationDate);

	}

	public static CreditCardFactory getFactory() {
		if (factory == null) {
			factory = new CreditCardFactory();
		}
		return factory;
	}

}
