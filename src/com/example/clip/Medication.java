package com.example.clip;

import java.util.Date;

public class Medication {
	// Data Members
	private String pillName;
	private Date dateStarted;
	private Date dateEnded;
	boolean setReminder;
	public String getPillName() {
		return pillName;
	}
	public void setPillName(String pillName) {
		this.pillName = pillName;
	}
	public Date getDateStarted() {
		return dateStarted;
	}
	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}
	public Date getDateEnded() {
		return dateEnded;
	}
	public void setDateEnded(Date dateEnded) {
		this.dateEnded = dateEnded;
	}
	public boolean isSetReminder() {
		return setReminder;
	}
	public void setSetReminder(boolean setReminder) {
		this.setReminder = setReminder;
	}
	public Medication(String pillName) {
		super();
		this.pillName = pillName;
	}
	
	
}
