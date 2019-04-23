package DAO;



import java.util.List;

import model.Company;
import model.ICompany;
import model.IPerson;
import model.Person;

public class SystemDAOmanager {
	
	public List<ICompany> getListofCustomers() {
		ICompanyDAO companyDAO = SystemDAOFactory.getCompanyDAOInstance();
		List<ICompany> companylist = companyDAO.getAllcustomers();
		return null;
	}
	
	public List<IPerson> getListofPersons() {
		return null;
	}

}
