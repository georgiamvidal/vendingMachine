package com.techelevator;

import java.util.List;

public class VendingMachineItems{

	private String name;
	private int price;
	private String location;
	private int stock;
	private String message;
	
	
	//constructor - used to initialize objects
	public VendingMachineItems(String name, int price, String location, int stock) {
		this.name = name;
		this.price = price;
		this.location = location;
		this.stock = stock;
	}
	
	//getters & setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getStock() {
		return stock;
	}

	//methods
	public void dispenseItem() {
		if(stock > 0) {
			stock--;
			System.out.println(getMessage());
		}else {
			System.out.println("Item is out of stock. Choose another option.");
		}
	}

	public String getMessage() {
		return message;
	}
	
	
}
