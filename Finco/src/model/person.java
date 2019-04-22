package model;

import java.util.Date;

public class person extends AbstractCustomer implements IPerson {

	public person(String names, String emailAddress) {
		super(names, emailAddress);
		this.dob = dob;
	}



	private Date dob;

	

	@Override
	public Date getDateofBirth() {
		return this.dob;
	}

}
