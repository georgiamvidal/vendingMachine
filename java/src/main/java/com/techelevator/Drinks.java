package com.techelevator;


public class Drinks extends VendingMachineItems{
		
	private String message;
	
	public Drinks(String name, int price, String location, int stock) {
		super(name, price, location, stock);
		this.message = "Glug Glug, Yum!";
	}

	public String getMessage() {
		return message;
	}
	


	

}
