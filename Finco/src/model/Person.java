package model;

import java.util.Date;

import javax.print.attribute.SetOfIntegerSyntax;

public class Person extends AbstractCustomer implements IPerson {

	public Person(String names, String emailAddress,Address adress,Date dob) {
		super(names, emailAddress,adress);
		this.dob = dob;
	}



	private Date dob;

	

	@Override
	public Date getDateofBirth() {
		return this.dob;
	}

}
