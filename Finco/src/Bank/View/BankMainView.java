package Bank.View;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import CreditCard.View.CreditDeposite;
import Default.View.AddCompAcc;
import Default.View.DefaultMainView;
import Default.View.Withdraw;

public class BankMainView extends DefaultMainView {

	protected boolean newaccount;
	protected Object name;
	protected Object street;
	protected Object city;
	protected Object state;
	protected Object type;
	protected Object chS;
	protected Object zip;
	protected Object email;
	protected Object birthdate;
	protected Object amount;
	private Object amountDeposit;

	public BankMainView() {

		this.setTitle("Bank View ");
		List<String> list = Arrays.asList("Street" , "City" ,"State" , "ZIP" , "P/CC" ,"Ch/S" , "Amount") ; 
		setJScrollPane(list);
	}

	@Override
	protected void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * JDialog_AddPAcc type object is for adding personal information construct a
		 * JDialog_AddPAcc type object set the boundaries and show it
		 */

		AddPersonalAccView pac = new AddPersonalAccView(this);
		pac.setSize(300, 400);
		pac.show();
//
		if (newaccount) {
			// add row to table
			rowdata[0] = street;
			rowdata[1] = city;
			rowdata[2] = state;
			rowdata[3] = zip;
			rowdata[4] = "P";
			rowdata[5] = chS;
			rowdata[6] = amount;
			addRow(rowdata);

//		}  
		}
	}

	@Override
	protected void JButtonCompAC_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		AddCompanyAccView pac = new AddCompanyAccView(this);
		pac.setSize(300, 400);
		pac.show();
//
		if (newaccount) {
			// add row to table
			rowdata[0] = street;
			rowdata[1] = city;
			rowdata[2] = state;
			rowdata[3] = zip;
			rowdata[4] = "c";
			rowdata[5] = chS;
			rowdata[6] = amount;
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
			BankDeposite dep = new BankDeposite(this, accnr);
			dep.setBounds(430, 15, 275, 140);
			dep.show();

			// compute new amount
			if (amountDeposit != null) {
				long deposit = Long.parseLong((String) amountDeposit);
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
			BankWithdraw wd = new BankWithdraw(this, accnr);
			wd.setBounds(430, 15, 275, 140);
			wd.show();

			// compute new amount
			if (amountDeposit != null) {
				long deposit = Long.parseLong((String) amountDeposit);
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
