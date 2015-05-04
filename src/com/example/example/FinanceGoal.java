package com.example.example;

class FinanceGoal {
	
	//private variables
    private final int _id;
	
	private String name;
	private String description;
	private String type;
	private String date;
	public FinanceGoal(int _id) {
		super();
		this._id = _id;
	}
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
	
	public int get_id() {
		return _id;
	}
	
	
	
}
