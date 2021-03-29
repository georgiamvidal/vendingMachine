package com.techelevator;


public class Gum extends VendingMachineItems{

	private String message;
	
	public Gum(String name, int price, String location, int stock) {
		super(name, price, location, stock);
		this.message = "Chew Chew, Yum!";
	}

	public String getMessage() {
		return message;
	}
	
	
	

}
