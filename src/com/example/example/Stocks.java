package com.example.example;

class Stocks {
	
	 //private variables
    private final int _id;
    
	private String numStock; 
	private String name;
	public String getNumStock() {
		return numStock;
	}
	public void setNumStock(String numStock) {
		this.numStock = numStock;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Stocks(int _id) {
		super();
		this._id = _id;
	}
	public int get_id() {
		return _id;
	}


}

	
	