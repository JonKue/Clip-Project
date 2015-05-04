package com.example.example;


public class Goal {
	// Data fields
	private final int _id;
	private String name;
	private String type;
	
	
	
	public int get_id() {
		return _id;
	}
	public String getType() {
		return type;
	}
	public void setType(String string) {
		this.type = string;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Goal(int _id) {
		super();
		this._id = _id;
	}
	
}
