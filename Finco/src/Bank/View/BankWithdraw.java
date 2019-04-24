package Bank.View;

import Default.View.DefaultMainView;
import Default.View.Withdraw;

public class BankWithdraw extends Withdraw {

	private BankMainView parent;
	private String acctNo;

	public BankWithdraw(BankMainView parent, String aaccnr) {
		super(parent, aaccnr);
		this.parent = parent;
		this.acctNo = aaccnr;
		setTitle("Bank Withdraw");
	}

	@Override
	protected  void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		double amount = Double.parseDouble(JTextField_AMT.getText());
		parent.main.withdraw(acctNo, amount, parent.accountType);
		parent.refre();
		dispose();
	}

}
