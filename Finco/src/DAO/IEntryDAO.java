package DAO;

import java.util.List;
import model.IEntry;

public interface IEntryDAO{
	
	List<IEntry> getAllentries();
	boolean updateCustomer(IEntry costomer);
	boolean deleteCustomer(String name);
	boolean addEntry(IEntry entry);

}
