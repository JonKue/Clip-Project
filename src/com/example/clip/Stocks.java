package com.example.clip;

public class Stocks {
	private int numStock; 
	private String name;
	public int getNumStock() {
		return numStock;
	}
	public void setNumStock(int numStock) {
		this.numStock = numStock;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//constructor
	public Stocks(int numStock, String name) {
		super();
		this.numStock = numStock;
		this.name = name;
	}
}
