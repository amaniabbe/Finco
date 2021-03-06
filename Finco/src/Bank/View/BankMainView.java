package Bank.View;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import Bank.controller.BankMain;
<<<<<<< HEAD
import CreditCard.View.CreditDeposite;
=======
import DAO.SystemDAOmanager;
>>>>>>> 359e26a52301ba4fc6f4f05f036957332f3e473f
import Default.View.AddCompAcc;
import Default.View.DefaultMainView;
import Default.View.Deposit;
import Default.View.Refresh;
import Default.View.Withdraw;
import model.IAccount;
<<<<<<< HEAD
import model.ICustomer;
=======
import model.ICompany;
import model.ICustomer;
import model.IPerson;
>>>>>>> 359e26a52301ba4fc6f4f05f036957332f3e473f

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

	protected BankMain main;

	public BankMainView() {

		this.setTitle("Bank View ");
		List<String> list = Arrays.asList("Account", "City", "State", "ZIP", "P/CC", "Ch/S", "Amount");
		setJScrollPane(list);
		main = new BankMain();
		refre();
	}

	public void refre() {
		model.setRowCount(0);
		for (ICustomer c : main.getCustomers()) {
			for (IAccount a : c.getListOfAccounts()) {
				rowdata[0] = a.getAccountNumber();
				rowdata[1] = c.getAddress().getCity();
				rowdata[2] = c.getAddress().getState();
				rowdata[3] = c.getAddress().getZipCode();
				rowdata[4] = c.getClass().getSimpleName();
				rowdata[5] = a.getClass().getSimpleName();
				rowdata[6] = a.getBalance();
				model.addRow(rowdata);
			}
		}

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

		refre();
		;
	}

	@Override
	protected void JButtonCompAC_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		AddCompanyAccView pac = new AddCompanyAccView(this);
		pac.setSize(300, 400);
		pac.show();

		refre();

	}

	@Override
	protected void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);
			accountType = (String) model.getValueAt(selection, 4);

			// Show the dialog for adding deposit amount for the current mane
			BankDeposite dep = new BankDeposite(this, accnr);
			dep.setBounds(430, 15, 275, 140);
			dep.show();

		}

	}

	@Override
	protected void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);
<<<<<<< HEAD
			accountType = (String)model.getValueAt(selection, 4);
=======
			accountType = (String) model.getValueAt(selection, 4);
>>>>>>> 359e26a52301ba4fc6f4f05f036957332f3e473f

			// Show the dialog for adding withdraw amount for the current mane
			BankWithdraw wd = new BankWithdraw(this, accnr);
			wd.setBounds(430, 15, 275, 140);
			wd.show();

		}

	}

	@Override
	protected void JButtonAddinterest_actionPerformed(ActionEvent event) {
<<<<<<< HEAD
	    main.addInterest();
	    refre();
	}
	
=======
		main.addInterest();
		refre();
	}

	@Override
	protected void JButtonExit_actionPerformed(ActionEvent event) {
		List<IPerson> persons = new ArrayList<>();
		List<ICompany> companies = new ArrayList<>();
		System.out.println(main.persons.size());
		for (ICustomer c : main.persons) {
			if (c instanceof IPerson) {
				persons.add((IPerson) c);
				System.out.println(c.getNames());
			} else {
				companies.add((ICompany) c);
				System.out.println(c.getNames());
			}

		}
		new SystemDAOmanager().addCompanies(companies);
		new SystemDAOmanager().addPersons(persons);
		System.exit(0);
	}

>>>>>>> 359e26a52301ba4fc6f4f05f036957332f3e473f
}
