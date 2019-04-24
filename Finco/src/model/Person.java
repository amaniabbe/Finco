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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		return true;
	}
	
	
	

}
