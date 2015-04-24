package com.example.clip;

public class Institution {
	private String schoolName;
	private Address location;
	
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Address getLocation() {
		return location;
	}
	public void setLocation(Address location) {
		this.location = location;
	}
	
	// Construction with school name
	public Institution(String schoolName) {
		super();
		this.schoolName = schoolName;
	}
	
}
