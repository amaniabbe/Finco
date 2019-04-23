package Bank.View;

import java.util.Arrays;
import java.util.List;

import Default.View.AddCompAcc;
import Default.View.DefaultMainView;
import Default.View.AddCompAcc.SymAction;

public class AddCompanyAccView extends AddCompAcc {

	BankMainView parent;

	public AddCompanyAccView(BankMainView parent) {
		super(parent);
		this.parent = parent;
		setTitle("add company Account");
		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36, 12, 84, 24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36, 36, 84, 24);
		JLabel6.setText("No of Employees");

	}
	
	
	
	
	@Override
	protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		// TODO Auto-generated method stub
		parent.name = JTextField_ACNR.getText();
		parent.street = JTextField_NAME.getText();
		parent.city = JTextField_STR.getText();
		parent.state = JTextField_CT.getText();
		parent.zip = JTextField_ZIP.getText();
		parent.email = JTextField_ST.getText();
		if (JRadioButton_Chk.isSelected())
			parent.chS = "Ch";
		else
			parent.chS = "S";
		parent.newaccount = true;
		dispose();
	}

}
