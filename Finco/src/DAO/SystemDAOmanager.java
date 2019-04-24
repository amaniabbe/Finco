package DAO;



import java.util.List;

import model.Account;
import model.Company;
import model.IAccount;
import model.ICompany;
import model.IEntry;
import model.IPerson;
import model.Person;

public class SystemDAOmanager {
	ICompanyDAO companyDAO = SystemDAOFactory.getCompanyDAOInstance();
	IPersonDAO personDAO = SystemDAOFactory.getPersonDAOInstance();
	IAccountDAO accountDAO = SystemDAOFactory.getAccountDAOInstance();
	IEntryDAO entryDAO = SystemDAOFactory.getEnryDAOInstance();
	
	public List<ICompany> getListofCustomers() {
		
		
		List<ICompany> companyList = companyDAO.getAllcustomers();
		List<IAccount> accountList = accountDAO.getAllAccounts();
		List<IEntry> entryList = entryDAO.getAllentries();
		
		
		accountList.stream().forEach(account->{
			for(IEntry entry :  entryList) {
				if(account.getAccountNumber() == entry.accountNumber())
					{
					account.addEntry(entry);

					}
			}
		} );
		
		companyList.stream().forEach(company->{
			for(IAccount account :  accountList) {
				if(company.getNames() == account.getOwner().getNames())
					company.addAccount(new Account(company,account.getAccountNumber(), account.getBalance()));
			}
		} );
		
		
		
		
		return companyList;
	}
	
	public List<IPerson> getListofPersons() {
			
		List<IPerson> personList = personDAO.getAllcustomers();
		List<IAccount> accountList = accountDAO.getAllAccounts();
		List<IEntry> entryList = entryDAO.getAllentries();
		
		accountList.stream().forEach(account->{
			for(IEntry entry :  entryList) {
				if(account.getAccountNumber() == entry.accountNumber())
					account.addEntry(entry);
				
			}
		} );
		
		personList.stream().forEach(person->{
			for(IAccount account :  accountList) {
				if(person.getNames() == account.getOwner().getNames())
					person.addAccount(new Account(person,account.getAccountNumber(), account.getBalance()));
			}
		} );
		
		
		
		
		return personList;
		
	}
	
	public void addPersons(List<IPerson> persons) {
		persons.stream().forEach(person -> {
			for(IAccount account : person.getListOfAccounts()) {
				for(IEntry entry : account.entries()) {
					entryDAO.addEntry(entry);
				
				}
				accountDAO.addAccount(account);
			}
			
			personDAO.addCustomer(person);
		});
	} 
	
	public void addCompanies(List<ICompany> companies) {
		companies.stream().forEach(company -> {
			for(IAccount account : company.getListOfAccounts()) {
				for(IEntry entry : account.entries()) {
					entryDAO.addEntry(entry);
					
				}
					
				accountDAO.addAccount(account);
			}			
			companyDAO.addCustomer(company);
			
		});
	}
}
