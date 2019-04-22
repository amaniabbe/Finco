package model;

import java.util.Date;

public class person extends AbstractCustomer implements IPerson {

	private Date dob;

	public person(Date dob) {
		this.dob = dob;
	}

	@Override
	public Date getDateofBirth() {
		return this.dob;
	}

}
