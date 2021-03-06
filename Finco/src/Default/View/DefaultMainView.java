package Default.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import DAO.SystemDAOmanager;
import Default.View.DefaultMainView.SymAction;
import controller.Finco;
import model.IAccount;
import model.ICompany;
import model.ICustomer;
import model.IPerson;

import javax.swing.*;

/**
 * A basic JFC based application.
 **/
public class DefaultMainView extends javax.swing.JFrame {
	/****
	 * init variables in the object
	 ****/
	public String accountnr, clientName, street, city, zip, state, accountType, clientType, amountDeposit, email;
	boolean newaccount;
	protected DefaultTableModel model;
	protected JTable JTable1;
	private JScrollPane JScrollPane1;
	DefaultMainView myframe;
	protected Object rowdata[];
	protected Finco finco;

	public DefaultMainView() {
		myframe = this;

		setTitle("Finco");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(575, 310);
		setVisible(false);
		finco = new Finco();
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);

		JPanel1.setBounds(0, 0, 575, 310);
		this.setLocationRelativeTo(null);

		/*
		 * /Add five buttons on the pane /for Adding personal account, Adding company
		 * account /Deposit, Withdraw and Exit from the system
		 */
//        JScrollPane1 = new JScrollPane();
//        model = new DefaultTableModel();
//        JTable1 = new JTable(model);
//        model.addColumn("AccountNr");
//        model.addColumn("Name");
//        model.addColumn("City");
//        model.addColumn("P/C");
//        model.addColumn("Ch/S");
//        model.addColumn("Amount");
//        rowdata = new Object[8];
//        newaccount=false;
//        
//        
//        JPanel1.add(JScrollPane1);
//        JScrollPane1.setBounds(12,92,444,160);
//        JScrollPane1.getViewport().add(JTable1);
//        JTable1.setBounds(0, 0, 420, 0);
		List<String> list = Arrays.asList("AccountNr", "Name", "Balance", "City", "P/C");
		JScrollPane1 = new JScrollPane();
		setJScrollPane(list);
//        rowdata = new Object[8];

		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468, 104, 96, 33);
		JButton_Withdraw.setText("Withdraw");
		JPanel1.add(JButton_Withdraw);

		JButton_Withdraw.setBounds(468, 164, 96, 33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468, 248, 96, 31);
		// lineBorder1.setRoundedCorners(true);
		// lineBorder1.setLineColor(java.awt.Color.green);
		// $$ lineBorder1.move(24,312);

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		addVODButtons(lSymAction);

	}

	public void addVODButtons(SymAction lSymAction) {
		JButton_PerAC.setText("Add personal account");
		JPanel1.add(JButton_PerAC);
		JButton_PerAC.setBounds(24, 20, 192, 33);
		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		JButton_PerAC.setActionCommand("jbutton");
		JPanel1.add(JButton_CompAC);
		JButton_CompAC.setBounds(240, 20, 192, 33);
		JButton_Addinterest.setBounds(448, 20, 106, 33);
		JButton_Addinterest.setText("Add interest");
		JPanel1.add(JButton_Addinterest);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);

	}

	/*****************************************************
	 * The entry point for this application. Sets the Look and Feel to the System
	 * Look and Feel. Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	static public void main(String args[]) {
		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			// Create a new instance of our application's frame, and make it visible.
			(new DefaultMainView()).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	public void setJScrollPane(java.util.List<String> list) {
		model = new DefaultTableModel();

		JTable1 = new JTable(model);
		for (String s : list) {
			model.addColumn(s);
		}

		rowdata = new Object[list.size()];
		this.refresh();
		newaccount = false;

		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12, 92, 444, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);
	}

	public void refresh() {
		model.setRowCount(0);
		for (ICustomer c : finco.getCustomers()) {
			for (IAccount a : c.getListOfAccounts()) {
				rowdata[0] = a.getAccountNumber();
				rowdata[1] = c.getNames();
				rowdata[2] = a.getBalance();
				rowdata[3] = c.getAddress().getCity();
				rowdata[4] = c.getClass().getSimpleName();
				model.addRow(rowdata);
			}
		}
	}

	public void addRow(Object rowdata[]) {
		model.addRow(rowdata);

	}

	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	protected javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	protected javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();

	void exitApplication() {
		try {
			List<IPerson> persons = new ArrayList<>();
			List<ICompany> companies = new ArrayList<>();
			for (ICustomer c : finco.persons) {
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
			this.setVisible(false); // hide the Frame
			this.dispose(); // free the system resources
			System.exit(0); // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == DefaultMainView.this)
				DefaultMainView_windowClosing(event);
		}
	}

	protected void DefaultMainView_windowClosing(java.awt.event.WindowEvent event) {
		// to do: code goes here.
		List<IPerson> persons = new ArrayList<>();
		List<ICompany> companies = new ArrayList<>();
		for (ICustomer c : finco.persons) {
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
	
		DefaultMainView_windowClosing_Interaction1(event);
	}

	void DefaultMainView_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_PerAC)
				JButtonPerAC_actionPerformed(event);
			else if (object == JButton_CompAC)
				JButtonCompAC_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);

		}
	}

	// When the Exit button is pressed this code gets executed
	// this will exit from the system
	protected void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		List<IPerson> persons = new ArrayList<>();
		List<ICompany> companies = new ArrayList<>();
		for (ICustomer c : finco.persons) {
			if (c instanceof IPerson) {
				persons.add((IPerson) c);
			} else {
				companies.add((ICompany) c);
			}
		
		}
		new SystemDAOmanager().addCompanies(companies);
		new SystemDAOmanager().addPersons(persons);
		System.exit(0);
	}

	protected void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * JDialog_AddPAcc type object is for adding personal information construct a
		 * JDialog_AddPAcc type object set the boundaries and show it
		 */

		addPerAcc pac = new addPerAcc(myframe);
		pac.setSize(300, 400);
//		pac.setBounds(450, 20, 300, 330);
		pac.show();

		/*
		 * if (newaccount) { // add row to table rowdata[0] = accountnr; rowdata[1] =
		 * clientName; rowdata[2] = city; rowdata[3] = "P"; addRow(rowdata); }
		 */
		refresh();
	}

	protected void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {

		AddCompAcc pac = new AddCompAcc(myframe);
		pac.setSize(300, 400);
		pac.show();

		refresh();

	}

	protected void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);
			accountType = (String) model.getValueAt(selection, 4);

			// Show the dialog for adding deposit amount for the current mane
			Deposit dep = new Deposit(myframe, accnr);
			dep.setBounds(430, 15, 275, 140);
			dep.show();

		}

	}

	protected void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);
			accountType = (String) model.getValueAt(selection, 4);

			// Show the dialog for adding withdraw amount for the current mane
			Withdraw wd = new Withdraw(myframe, accnr);
			wd.setBounds(430, 15, 275, 140);
			wd.show();

		}

	}

	protected void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
		JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts",
				"Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
		finco.addInterest();
		refresh();

	}

<<<<<<< HEAD
	public Finco getFinco() {
		return finco;
	}

=======
>>>>>>> 359e26a52301ba4fc6f4f05f036957332f3e473f
	

}
