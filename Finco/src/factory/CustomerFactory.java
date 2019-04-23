package factory;

import model.Company;
import model.Person;

public class CustomerFactory {

	public Company createCompany(String names, String emailAddress, Integer numberOfEmployees) {
		return new Company(names, emailAddress, numberOfEmployees);
	}

	public Person createPerson(String names, String emailAddress) {
		return new Person(names, emailAddress);
	}

}
