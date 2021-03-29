package com.techelevator;

import java.util.Scanner;

public class Wallet {
	
	public int balance = 0; 
	
	private static final int ONE_DOLLAR = 100;
	private static final int TWO_DOLLARS = 200;
	private static final int FIVE_DOLLARS = 500;
	private static final int TEN_DOLLARS = 1000;
	
	private static final int NICKEL = 5;
	private static final int DIME = 10;
	private static final int QUARTER = 25;


	public int getBalance() {
		return balance;
	}
	public void addToBalance(int money) {
		balance += money*100;
		double balanceAsDouble = balance;
		System.out.println("Your current balance is: $" + balanceAsDouble/100 + "\n");
	}
	public void subtractFromBalance(int money) {
		balance -= money;
		double balanceAsDouble = balance;
		System.out.println("Your current balance is: $" + balanceAsDouble/100 + "\n");
	}
	
	
	public void getChange() {
		int countQuarter = 0;
		int countDime = 0;
		int countNickel = 0;
		while(balance > 0) {
		if((balance - QUARTER) >= 0) {
			balance -= QUARTER;
			countQuarter++;
		}else if((balance - DIME) >= 0) {
			balance -= DIME;
			countDime++;
		}else if((balance - NICKEL) >= 0) {
			balance -= NICKEL;
			countNickel++;
		}
	}System.out.println("Your balance is: $" + getBalance());
	System.out.println("Your change is " + countQuarter + " quarters, " + countDime + " dimes, " + countNickel + " nickels.");
	}
	


}
