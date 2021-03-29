package com.techelevator;


public class Candy extends VendingMachineItems{

	private String message;
	
	public Candy(String name, int price, String location, int stock) {
		super(name, price, location, stock);
		this.message = "Munch Munch, Yum!";
	}

	public String getMessage() {
		return message;
	}


	
	
}
