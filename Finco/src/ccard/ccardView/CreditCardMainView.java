package ccard.ccardView;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import Bank.View.AddCompanyAccView;
import Bank.View.BankWithdraw;
import Default.View.DefaultMainView;
import Default.View.Deposit;
import ccard.controller.CreditCardMain;
import ccard.model.CreditCard;
import model.IAccount;
import model.ICustomer;

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

	protected CreditCardMain main;

	public CreditCardMainView() {
		this.setTitle("Credit Card ");
		List<String> list = Arrays.asList("Name", "CC Number", "Exp date", "Type", "Balance");
		setJScrollPane(list);
		JButton_PerAC.setText("Add Credit Card account");
		JButton_CompAC.setText("Generate Monthly Bills");
		JButton_Addinterest.setVisible(false);
		JButton_Withdraw.setText("Charge");
		main = new CreditCardMain();
		reload();
	}

	public void reload() {
		model.setRowCount(0);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for (ICustomer c : main.getCustomers()) {
			for (IAccount a : c.getListOfAccounts()) {
				rowdata[0] = c.getNames();
				rowdata[1] = a.getAccountNumber();
				rowdata[2] = sdf.format(((CreditCard) a).getExpirationDate());
				rowdata[3] = a.getClass().getSimpleName();
				rowdata[4] = a.getBalance();
				model.addRow(rowdata);
			}
		}
	}

	@Override
	protected void JButtonPerAC_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		addCreditCard pac = new addCreditCard(this);
		pac.setSize(300, 400);
		pac.show();

	}

	@Override
	protected void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			accountnr = (String) model.getValueAt(selection, 1);

			// Show the dialog for adding deposit amount for the current mane
			CreditDeposite dep = new CreditDeposite(this, accountnr);
			dep.setBounds(430, 15, 275, 140);
			dep.show();

		}

	}

	@Override
	protected void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			accountnr = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding withdraw amount for the current mane
			CreditCardWithdraw wd = new CreditCardWithdraw(this, accountnr);
			wd.setBounds(430, 15, 275, 140);
			wd.show();

			
		}

	}
	
	
	@Override
	protected void JButtonCompAC_actionPerformed(ActionEvent event) {
		System.out.println(main.generateMonthlyReport());
	}

}
