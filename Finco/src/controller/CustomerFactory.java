package controller;

import model.Address;
import model.Company;
import model.Person;

public class CustomerFactory {

	public Company createCompany(String names, String emailAddress, Integer numberOfEmployees,Address adress) {
		return new Company(names, emailAddress, numberOfEmployees,adress);
	}

	public Person createPerson(String names, String emailAddress,Address adress) {
		return new Person(names, emailAddress,adress);
	}

}
