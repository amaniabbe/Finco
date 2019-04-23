package CreditCard.View;

import java.util.Arrays;
import java.util.List;

import javax.swing.JRadioButton;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import Default.View.AddCompAcc;
import Default.View.DefaultMainView;
import Default.View.AddCompAcc.SymAction;

public class addCreditCard extends AddCompAcc {

	CreditCardMainView parent;
	private JRadioButton JRadioButton_gold;
	private JRadioButton JRadioButton_Silver;
	private JRadioButton JRadioButton_bronze;

	public addCreditCard(CreditCardMainView parent) {
		super(parent);
		this.parent = parent;
		setTitle("add credit Card");
		setSize(500 , 700);
		setViews();

		//}}

	}
	
	@Override
	protected void setViews() {
		// TODO Auto-generated method stub
		JRadioButton_gold = new javax.swing.JRadioButton();
		JRadioButton_Silver = new javax.swing.JRadioButton();
		JRadioButton_bronze = new javax.swing.JRadioButton();
		JRadioButton_gold.setText("Gold");
		JRadioButton_gold.setActionCommand("Gold");
		getContentPane().add(JRadioButton_gold);
		JRadioButton_gold.setBounds(36, 12, 84, 24);
		JRadioButton_Silver.setText("Silver");
		JRadioButton_Silver.setActionCommand("Silver");
		getContentPane().add(JRadioButton_Silver);
		JRadioButton_Silver.setBounds(36, 36, 84, 24);
		JRadioButton_bronze = new javax.swing.JRadioButton();
		JRadioButton_bronze.setText("Silver");
		JRadioButton_bronze.setActionCommand("Silver");
		getContentPane().add(JRadioButton_bronze);
		JRadioButton_bronze.setBounds(36, 60, 84, 24);
		JLabel1.setText("Name");
		JLabel2.setText("Street");
		JLabel3.setText("City");
		JLabel4.setText("State");
		JLabel5.setText("ZIP");
		JLabel6.setText("Email");
		JLabel7.setText("CC Number");
		JLabel8.setText("Ex. Date");
		JTextField_ACNR.setVisible(true);
		JLabel8.setVisible(true);
	}
	
	
	
	
	@Override
	protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		// TODO Auto-generated method stub
		parent.name = JTextField_NAME.getText();
		parent.street = JTextField_STR.getText();
		parent.city = JTextField_CT.getText();
		parent.state = JTextField_ST.getText();
		parent.zip = JTextField_ZIP.getText();
		parent.email = JTextField_NoOfEmp.getText();
		parent.CCNumber = JTextField_EM.getText();
		parent.expireDate = JTextField_ACNR.getText();
		if (JRadioButton_gold.isSelected())
			parent.type = "Gold";
		else if(JRadioButton_Silver.isSelected())
			parent.type = "Silver";
		else 
			parent.type = "bronze";
		parent.newaccount = true;
		dispose();
	}

}
