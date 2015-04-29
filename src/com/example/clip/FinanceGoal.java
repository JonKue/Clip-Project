package com.example.clip;

public class FinanceGoal {
	private String name;
	private String description;
	private String type;
	private String date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public FinanceGoal(String name, String description, String type, String date) {
		super();
		this.name = name;
		this.description = description;
		this.type = type;
		this.date = date;
	}
	
	
}
