package com.example.clip;

public class Scholarship extends FinancialSupport {
	private String name;
	private String[] requirement;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getRequirement() {
		return requirement;
	}
	public void setRequirement(String[] requirement) {
		this.requirement = requirement;
	}
	
	public Scholarship(String name) {
		super();
		this.name = name;
	}
}
