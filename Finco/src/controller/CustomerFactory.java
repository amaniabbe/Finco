package controller;

import java.util.Date;

import model.Address;
import model.Company;
import model.Person;

public class CustomerFactory {
	
	 static CustomerFactory factory = null;

	public static Company createCompany(String names, String emailAddress, Integer numberOfEmployees,Address adress) {
		return new Company(names, emailAddress, numberOfEmployees,adress);
	}

	public static  Person createPerson(String names, String emailAddress,Address adress) {
		return new Person(names, emailAddress,adress, new Date());
	}
	
	
	public static CustomerFactory getFactory() {
		if(factory == null) {
			factory = new CustomerFactory();
		}
		return factory;
	}

}
