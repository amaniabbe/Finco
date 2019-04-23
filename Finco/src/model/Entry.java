package model;

import java.util.Date;

public class Entry implements IEntry {

	private Date recordedDate;

	private String description;

	private double amount;
	
	private String accountNumber;

	
	
	public Entry(Date recordedDate,String description,double amount,String accountNumber) {
		this.recordedDate = recordedDate;
		this.description = description;
		this.amount = amount;
		this.accountNumber = accountNumber;
	}

	@Override
	public Date getDate() {
		return this.recordedDate;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public double amount() {
		return this.amount;
	}

	@Override
	public String accountNumber() {
		return this.accountNumber;
	}

	
	
	

}
