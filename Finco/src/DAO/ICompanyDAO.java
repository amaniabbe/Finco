package DAO;

import java.util.List;

import model.ICompany;

public interface ICompanyDAO {
	
	List<ICompany> getAllcustomers();
	boolean updateCustomer(ICompany costomer);
	boolean deleteCustomer(String name);
	boolean addCustomer(ICompany customer);

}
