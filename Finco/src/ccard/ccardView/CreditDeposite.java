package ccard.ccardView;

import java.awt.event.ActionEvent;

import Default.View.DefaultMainView;
import Default.View.Deposit;

public class CreditDeposite extends Deposit {

	CreditCardMainView parent;

	public CreditDeposite(CreditCardMainView parent, String aaccnr) {
		super(parent, aaccnr);
		// TODO Auto-generated constructor stub
		setTitle("Credit Card deposite");
		this.parent = parent;
	}

	@Override
	protected void JButtonOK_actionPerformed(ActionEvent event) {
		double amount = Double.parseDouble(JTextField_Deposit.getText());
		parent.main.deposit(parent.accountnr, amount, "Person");
		parent.reload();
		dispose();
	}

}
