package Bank.View;

import java.awt.event.ActionEvent;
import Default.View.Deposit;

public class BankDeposite extends Deposit {

	private BankMainView parent;
	private String acnt;
	//test

	public BankDeposite(BankMainView parent, String aaccnr) {
		super(parent, aaccnr);
		acnt = aaccnr;
		this.parent = parent;
	}

	@Override
	protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		double amount = Double.parseDouble(JTextField_Deposit.getText());
		parent.main.deposit(acnt, amount, parent.accountType);
		parent.refre();
		dispose();
	}

}
