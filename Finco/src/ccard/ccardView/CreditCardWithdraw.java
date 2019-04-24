package ccard.ccardView;

import java.awt.event.ActionEvent;

import Default.View.DefaultMainView;
import Default.View.Withdraw;

public class CreditCardWithdraw extends Withdraw {

	CreditCardMainView parent;

	public CreditCardWithdraw(CreditCardMainView parent, String aaccnr) {
		super(parent, aaccnr);
		setTitle("Credit card Withdraw");
		this.parent = parent;
	}

	@Override
	protected void JButtonOK_actionPerformed(ActionEvent event) {
		double amount = Double.parseDouble(JTextField_AMT.getText());
		parent.main.chargeCard(parent.accountnr, amount);
		parent.reload();
		dispose();
	}

}
