package Default.View;

import java.util.Arrays;
import java.util.List;

import Default.View.AddCompAcc;
import Default.View.DefaultMainView;
import Default.View.AddCompAcc.SymAction;

public class addPerAcc extends AddCompAcc {

	DefaultMainView parent;

	public addPerAcc(DefaultMainView parent) {
		super(parent);
		this.parent = parent;
		setTitle("add personal Account");
		JLabel8.setVisible(false);
		JTextField_ACNR.setVisible(false);

	}

	@Override
	protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		// TODO Auto-generated method stub
		parent.accountnr = JTextField_ACNR.getText();
		parent.clientName = JTextField_NAME.getText();
		parent.street = JTextField_STR.getText();
		parent.city = JTextField_CT.getText();
		parent.zip = JTextField_ZIP.getText();
		parent.state = JTextField_ST.getText();
		parent.newaccount = true;
		dispose();
	}

}
