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
		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36, 12, 84, 24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36, 36, 84, 24);
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
		if (JRadioButton_Chk.isSelected())
			parent.accountType = "Ch";
		else
			parent.accountType = "S";
		parent.newaccount = true;
		dispose();
	}

}
