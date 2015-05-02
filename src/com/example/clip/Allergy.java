package com.example.clip;

public class Allergy {
	private final int _id;
	private String allergyName;
	private String allergyDescription;
	
	
	public int get_id() {
		return _id;
	}
	public String getAllergyName() {
		return allergyName;
	}
	public void setAllergyName(String allergyName) {
		this.allergyName = allergyName;
	}
	public String getAllergyDescription() {
		return allergyDescription;
	}
	public void setAllergyDescription(String allergyDescription) {
		this.allergyDescription = allergyDescription;
	}
	public Allergy(int _id) {
		super();
		this._id = _id;
	}
	
	
}
