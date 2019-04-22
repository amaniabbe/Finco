package model;

public class Company extends AbstractCustomer implements ICompany {

	private Integer numberOfEmployees;

	public Company(String name, String emailAddress, Integer nberofEmployees) {
		this.names = name;
		this.emailAddress = emailAddress;
		this.numberOfEmployees = nberofEmployees;
	}

	@Override
	public Integer getNumberOfEmployees() {
		return this.numberOfEmployees;
	}

	@Override
	public void setNumberOfEmployees(Integer number) {
		this.numberOfEmployees = number;

	}

}
