package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.techelevator.view.Menu;

public class VendingMachineCLI {
	//Map of inventory of all items in vending machine
	static TreeMap<String, VendingMachineItems> inventory = new TreeMap<>();
	Set<Map.Entry<String, VendingMachineItems>> inventoryMap = inventory.entrySet();

	//Main menu options
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT }; 

	//Purchasing menu options
	private static final String PUCHASING_MENU_FEED_MONEY = "Feed Money";
	private static final String PUCHASING_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PUCHASING_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASING_MENU_OPTIONS = {PUCHASING_MENU_FEED_MONEY, PUCHASING_MENU_SELECT_PRODUCT, PUCHASING_MENU_FINISH_TRANSACTION};


	private Menu menu;
	Log auditLog = new Log();
	Wallet wallet = new Wallet();


	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	//Printing out the inventory items and their information 
	public void printInventory(TreeMap<String, VendingMachineItems> inventory) {
		for(Map.Entry<String, VendingMachineItems> inventoryItem: inventoryMap) {
			double itemPrice = inventoryItem.getValue().getPrice()/100d;

			System.out.println(inventoryItem.getKey() + " " + inventoryItem.getValue().getName() 
					+ " $" + itemPrice + " stock:" + inventoryItem.getValue().getStock() + "\n");
		}
	}

	public void run() {
		while (true) {
			//Beginning screen with menu options
			System.out.println("\n----Welcome to the Vending Machine----\n");
			System.out.println("Please make a selection from the following:");
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			//If user chooses 1, print main menu
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println("\n----Inventory----\n");
				printInventory(inventory);
			}
			//If user chooses 2, print purchasing menu options
			else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASING_MENU_OPTIONS);
				while(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				System.out.println("\nPlease make a selection from the following:\n");

				//If user chooses 1, advance to feed money option
				while(purchaseChoice.equals(PUCHASING_MENU_FEED_MONEY)) {
					Scanner moneyScanner = new Scanner(System.in);
					System.out.println("Please enter money: $1, $2, $5, or $10 or press 0 to exit.");	
					//Adding user input to balance as long as it is a whole number
					try {
					int moneyAdded = moneyScanner.nextInt();
					if(moneyAdded > 0) {
						wallet.addToBalance(moneyAdded);
						try {
							auditLog.logFeedMoney(moneyAdded, wallet.getBalance());
						}catch(IOException ex){
					}
					//If user input is 0 return to purchase menu- prompted 0 as "exit"	
					}else if(moneyAdded <= 0){
						purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASING_MENU_OPTIONS);
					}
					}
					//Exception in case user input is a decimal
					catch(InputMismatchException e) {
						System.out.println("Not a vaild option.");
					}
				}
				//If user chooses 2, prompts to select product from inventory items	
				while(purchaseChoice.equals(PUCHASING_MENU_SELECT_PRODUCT)) {
					//prints inventory items in vending machine and information
					System.out.println("\nPlease make a selection from the following:\n");
					printInventory(inventory);
					//Allows user to input value and used toUpperCase so user doesn't have to capitalize it
					Scanner itemScanner = new Scanner(System.in);
					System.out.println("Make selection or press x to exit:");
					String code = itemScanner.next().toUpperCase();
					//Brings user back to purchasing menu options
					if(code.equals("x")){
						purchaseChoice = "";
						purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASING_MENU_OPTIONS);
					}
					//If the user inputs a code that is valid, it prints what they are buying and price
					//prints their current balance and dispenses the item- making the stock drop by 1
					else if(inventory.containsKey(code)) {
						if(wallet.getBalance() >= inventory.get(code).getPrice() && inventory.get(code).getStock() > 0) {
							double itemPriceAsDouble = inventory.get(code).getPrice();
							System.out.println("Your selection is: " + inventory.get(code).getName() + " $" + itemPriceAsDouble/100);

							wallet.subtractFromBalance(inventory.get(code).getPrice());

							inventory.get(code).dispenseItem();
							purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASING_MENU_OPTIONS);
							//audits the purchase and logs in it the log.txt file
							try {
								auditLog.logItemBought(inventory.get(code).getName(), code, wallet.getBalance(), inventory.get(code).getPrice());
							}catch(IOException ex){
						}
						}
						//If not enough money to buy item
						else if(wallet.getBalance() < inventory.get(code).getPrice()){
							System.out.println("Not enough funds.");
							purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASING_MENU_OPTIONS);
						}
						//If item is dispensed
						else {
							inventory.get(code).dispenseItem();
							purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASING_MENU_OPTIONS);
						}
					}
					//If user inputs a location that doesn't exist
					else {
						System.out.println("This item doesn't exist");
						purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASING_MENU_OPTIONS);
					}

				}
				//If user chooses 3, return change in smallest amount of coins and update balance to 0
				while(purchaseChoice.equals(PUCHASING_MENU_FINISH_TRANSACTION)) {
					double currentBalance = wallet.getBalance();
					wallet.getChange();
					choice = "";
					purchaseChoice = "";
					//log amount of change given to log.txt file
					try {
						auditLog.logChange(currentBalance, wallet.getBalance());
					}catch(IOException ex){
				}
					break;
				}
				}

			}
			//Ends program if user chooses 3 on main menu
			else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
		System.out.println("\n----EXIT----\n");
		System.exit(0);
	} 
}
}


	
	
	
	

public static void main(String[] args) throws FileNotFoundException{
	Menu menu = new Menu(System.in, System.out);
	VendingMachineCLI cli = new VendingMachineCLI(menu);

	//Reading the vendingmachine.csv file which has what the items are/cost
	//placed here so it reads the file before running the program
	File inventoryFile = new File("vendingmachine.csv");
	try(Scanner inventoryItems = new Scanner(inventoryFile)){
		while(inventoryItems.hasNextLine()) {

			String items = inventoryItems.nextLine();
			String[] itemInfo = items.split("\\|");

			//Set the indexes of the split array to variables to use throughout program 
			String location = itemInfo[0];
			String name = itemInfo[1];
			double priceAsDouble = Double.parseDouble(itemInfo[2]);
			priceAsDouble *= 100;
			int price = (int)priceAsDouble;
			String item = itemInfo[3];

			if (item.equals("Gum")) {
				Gum gumItem = new Gum (name, price, location, 5);
				inventory.put(location, gumItem);
			}
			else if(item.equals("Candy")) {
				Candy candyItem = new Candy (name, price, location, 5);
				inventory.put(location, candyItem);
			}
			else if(item.equals("Drink")) {
				Drinks drinkItem = new Drinks (name, price, location, 5);
				inventory.put(location, drinkItem);
			}
			else if(item.equals("Chip")) {
				Chips chipItem = new Chips (name, price, location, 5);
				inventory.put(location, chipItem);
			}

		}

		cli.run();

	}
}
}
