package com.example.clip;

import java.util.Calendar;

public class FuturePlan extends EducationPlan{
	// Data Members
	private Calendar applicationDate;
	private ApplicationStatus applicationStatus;
	
	public Calendar getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Calendar applicationDate) {
		this.applicationDate = applicationDate;
	}
	public ApplicationStatus getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	
	// Constructor from superclass
	public FuturePlan(Institution school, DegreeType degree) {
		super(school, degree);
		// TODO Auto-generated constructor stub
	}
	
	// Method to update application status
	public void updateApplicationStatus(ApplicationStatus status){
		this.setApplicationStatus(status);
	}
	
}
