package factory;



import model.Address;
import model.Company;
import model.Person;

public class CustomerFactory {

	public Company createCompany(String names, String emailAddress, Integer numberOfEmployees, Address address) {
		return new Company(names, emailAddress, numberOfEmployees, address);
	}

	public Person createPerson(String names, String emailAddress , Address address) {
		return new Person(names, emailAddress, address);
	}

}
