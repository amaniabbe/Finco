package DAO;

public class SystemDAOFactory {
	
	private static final IPersonDAO personDaoInstace= new PersonDAO();
	private static final ICompanyDAO companyDaoInstace= new CompanyDAO();
	private static final IAccountDAO accountDaoInstace= new AccountDAO();
	private static final IEntryDAO entryDaoInstance= new EntryDAO();
	
	private SystemDAOFactory(){}
	
	
	public static synchronized IPersonDAO getPersonDAOInstance() {
        
        return personDaoInstace;
    }
	
	public static synchronized ICompanyDAO getCompanyDAOInstance() {
        
        return companyDaoInstace;
    }	
	public static synchronized IAccountDAO getAccountDAOInstance() {
        
        return accountDaoInstace;
    }
	public static synchronized IEntryDAO getEnryDAOInstance() {
        
        return entryDaoInstance;
    }
	

}
