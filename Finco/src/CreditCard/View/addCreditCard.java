package CreditCard.View;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.swing.JRadioButton;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import Default.View.AddCompAcc;
import Default.View.DefaultMainView;
import Default.View.AddCompAcc.SymAction;
import model.Address;
import model.ICustomer;

public class addCreditCard extends AddCompAcc {

	CreditCardMainView parent;
	private JRadioButton JRadioButton_gold;
	private JRadioButton JRadioButton_Silver;
	private JRadioButton JRadioButton_bronze;

	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	public addCreditCard(CreditCardMainView parent) {
		super(parent);
		this.parent = parent;
		setTitle("add credit Card");
		setSize(500, 700);
		setViews();

		// }}

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
		JRadioButton_bronze.setText("Bronze");
		JRadioButton_bronze.setActionCommand("Bronze");
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
		SymMouse aSymMouse = new SymMouse();
		JRadioButton_gold.addMouseListener(aSymMouse);
		JRadioButton_Silver.addMouseListener(aSymMouse);
		JRadioButton_bronze.addMouseListener(aSymMouse);

	}

	class SymMouse extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			Object object = event.getSource();
			if (object == JRadioButton_gold)
				JRadioButtonGold_mouseClicked(event);
			else if (object == JRadioButton_Silver)
				JRadioButtonSilver_mouseClicked(event);
			else if (object == JRadioButton_bronze)
				JRadioButtonBronze_mouseClicked(event);

		}
	}

	void JRadioButtonGold_mouseClicked(java.awt.event.MouseEvent event) {
		JRadioButton_gold.setSelected(true);
		JRadioButton_Silver.setSelected(false);
		JRadioButton_bronze.setSelected(false);
	}

	void JRadioButtonSilver_mouseClicked(java.awt.event.MouseEvent event) {
		JRadioButton_gold.setSelected(false);
		JRadioButton_Silver.setSelected(true);
		JRadioButton_bronze.setSelected(false);

	}

	void JRadioButtonBronze_mouseClicked(java.awt.event.MouseEvent event) {
		JRadioButton_gold.setSelected(false);
		JRadioButton_Silver.setSelected(false);
		JRadioButton_bronze.setSelected(true);

	}

	@Override
	protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		// TODO Auto-generated method stub
		try {
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
			else if (JRadioButton_Silver.isSelected())
				parent.type = "Silver";
			else
				parent.type = "bronze";
			parent.newaccount = true;

			Address a = new Address(parent.state.toString(), parent.city.toString(), parent.street.toString(),
					parent.zip.toString());
			parent.main.createPerson(a, parent.name.toString(), parent.email.toString());
			ICustomer c = parent.main.findCustomer(parent.name.toString());
			if (parent.type.equals("Silver")) {
				parent.main.createSilverAccount(c, parent.CCNumber.toString(),
						format.parse(parent.expireDate.toString()));
			} else if (parent.type.equals("Gold")) {
				parent.main.createGoldAccount(c, parent.CCNumber.toString(),
						format.parse(parent.expireDate.toString()));
			} else {
				parent.main.createBronzeAccount(c, parent.CCNumber.toString(),
						format.parse(parent.expireDate.toString()));
			}
			parent.reload();
			dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
