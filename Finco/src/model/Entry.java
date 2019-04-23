package model;

import java.util.Date;

public class Entry implements IEntry {

	private Date recordedDate;

	private String description;

	private double amount;

	
	
	public Entry(Date recordedDate,String description,double amount) {
		this.recordedDate = recordedDate;
		this.description = description;
		this.amount = amount;
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

}
