package com.example.clip;

public class FinancialSupport {
	// Data Members
	private int amount;
	private ApplicationStatus applicationStatus;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public ApplicationStatus getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	
	// method to update application status
	public void updateApplicationStatus(ApplicationStatus status){
		this.setApplicationStatus(status);
	}
}
