package DAO;

import java.util.List;

import model.*;

public interface IPersonDAO {
	
	List<IPerson> getAllcustomers();
	boolean updateCustomer(IPerson costomer);
	boolean deleteCustomer(String name);
	boolean addCustomer(IPerson customer);
}
