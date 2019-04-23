package Bank.View;

import java.awt.event.ActionEvent;
import Default.View.Deposit;

public class BankDeposite extends Deposit {

	private BankMainView parent;

	public BankDeposite(BankMainView parent, String aaccnr) {
		super(parent, aaccnr);
		setTitle("Bank deposite");
		this.parent = parent;
	}

	@Override
	protected void JButtonOK_actionPerformed(ActionEvent event) {
		parent.amount = JTextField_Deposit.getText();
		System.out.println("amount"+(double)parent.amount);
		parent.main.deposit(accnr, (double) parent.amount, parent.accountType);
		System.out.println("trio version");
		parent.reload();
		
	}

}
