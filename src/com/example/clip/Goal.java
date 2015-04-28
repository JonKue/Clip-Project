package com.example.clip;



public class Goal {
	// Data fields
	private String name;
	private GoalType type;
	
	
	public GoalType getType() {
		return type;
	}
	public void setType(GoalType type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Goal(String name) {
		super();
		this.name = name;
	}
	
	
}
