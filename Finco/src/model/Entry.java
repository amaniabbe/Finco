package model;

import java.util.Date;

public class Entry implements IEntry {

	private Date recordedDate;

	private String description;

	private double amount;

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
