package Default.View;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import Default.View.AddCompAcc;
import Default.View.DefaultMainView;
import Default.View.AddCompAcc.SymAction;
import model.Address;
import model.ICustomer;

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
		
		parent.accountnr = UUID.randomUUID().toString().split("-")[1];
		parent.clientName = JTextField_NAME.getText();
		parent.street = JTextField_STR.getText();
		parent.city = JTextField_CT.getText();
		parent.zip = JTextField_ZIP.getText();
		parent.state = JTextField_ST.getText();
		parent.newaccount = true;
		Address a = new Address(parent.state, parent.city, parent.street, parent.zip);
		parent.finco.createPerson(a, parent.clientName, parent.email);
		ICustomer c = parent.finco.findCustomer(parent.clientName);
		parent.finco.addPersonalAccount(c, parent.accountnr);
		dispose();
	}

}
