package DAO;

import java.util.List;

import model.*;

public interface IPersonDAO {
	
	List<IPerson> getAllcustomers();
	boolean addCustomer(IPerson customer);
}
