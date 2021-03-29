package com.techelevator;


public class Chips extends VendingMachineItems{

	private String message;
	
	public Chips(String name, int price, String location, int stock) {
		super(name, price, location, stock);
		this.message ="Crunch Crunch, Yum!";
	}

	public String getMessage() {
		return message;
	}
	
	

}
