package model;

public class Company extends AbstractCustomer implements ICompany {

	public Company(String names, String emailAddress,Integer numberOfEmployees) {
		super(names, emailAddress);
	    this.numberOfEmployees = numberOfEmployees;	
	}

	private Integer numberOfEmployees;

	

	@Override
	public Integer getNumberOfEmployees() {
		return this.numberOfEmployees;
	}

	@Override
	public void setNumberOfEmployees(Integer number) {
		this.numberOfEmployees = number;

	}

}
