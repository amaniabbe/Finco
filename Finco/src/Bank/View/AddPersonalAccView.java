package Bank.View;

import java.util.Arrays;
import java.util.List;

import Default.View.AddCompAcc;
import Default.View.DefaultMainView;
import Default.View.AddCompAcc.SymAction;

public class AddPersonalAccView extends AddCompAcc {

	BankMainView parent;
	protected javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
	protected javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();

	public AddPersonalAccView(BankMainView parent) {
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
		parent.name = JTextField_NAME.getText();
		parent.street = JTextField_STR.getText();
		parent.city = JTextField_CT.getText();
		parent.state = JTextField_ST.getText();
		parent.zip = JTextField_ZIP.getText();
		parent.email = JTextField_EM.getText();
		if (JRadioButton_Chk.isSelected())
			parent.chS = "Ch";
		else
			parent.chS = "S";
		parent.newaccount = true;
		dispose();
	}

}
