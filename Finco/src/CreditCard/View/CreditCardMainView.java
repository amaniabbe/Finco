package CreditCard.View;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import Bank.View.AddCompanyAccView;
import Bank.View.BankWithdraw;
import Default.View.DefaultMainView;
import Default.View.Deposit;

public class CreditCardMainView extends DefaultMainView {

	protected boolean newaccount;
	protected Object name;
	protected Object CCNumber;
	protected Object type;
	protected Object expireDate;
	protected Object street;
	protected Object city;
	protected Object state;
	protected Object zip;
	protected Object email;
	protected Object balance;
	private String amountDeposit;

	public CreditCardMainView() {
		this.setTitle("Credit Card ");
		List<String> list = Arrays.asList("Name", "CC Number", "Exp date", "Type", "Balance");
		setJScrollPane(list);
		JButton_PerAC.setText("Add Credit Card account");
		JButton_CompAC.setText("Generate Monthly Bills");
		JButton_Addinterest.setVisible(false);
		JButton_Withdraw.setText("Charge");

	}

	@Override
	protected void JButtonPerAC_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		addCreditCard pac = new addCreditCard(this);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
//
		if (newaccount) {
			// add row to table
			rowdata[0] = name;
			rowdata[1] = CCNumber;
			rowdata[2] = expireDate;
			rowdata[3] = type;
			rowdata[4] = balance;
			addRow(rowdata);

//		}  
		}
	}

	@Override
	protected void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding deposit amount for the current mane
			CreditDeposite dep = new CreditDeposite(this, accnr);
			dep.setBounds(430, 15, 275, 140);
			dep.show();

			// compute new amount
			if (amountDeposit != null) {
				long deposit = Long.parseLong(amountDeposit);
				String samount = (String) model.getValueAt(selection, 5);
				long currentamount = Long.parseLong(samount);
				long newamount = currentamount + deposit;
				model.setValueAt(String.valueOf(newamount), selection, 5);
			}
		}

	}
	
	@Override
	protected void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding withdraw amount for the current mane
			CreditCardWithdraw wd = new CreditCardWithdraw(this, accnr);
			wd.setBounds(430, 15, 275, 140);
			wd.show();

			// compute new amount
			if (amountDeposit != null) {
				long deposit = Long.parseLong(amountDeposit);
				String samount = (String) model.getValueAt(selection, 5);
				long currentamount = Long.parseLong(samount);
				long newamount = currentamount - deposit;
				model.setValueAt(String.valueOf(newamount), selection, 5);
				if (newamount < 0) {
					JOptionPane.showMessageDialog(JButton_Withdraw,
							" Account " + accnr + " : balance is negative: $" + String.valueOf(newamount) + " !",
							"Warning: negative balance", JOptionPane.WARNING_MESSAGE);
				}
			}
		}

	}

}
