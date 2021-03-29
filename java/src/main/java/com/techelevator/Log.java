package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
	
	public void logFeedMoney(double moneyAdded, double wallet) throws IOException {
		File newFile = new File("log.txt");
		LocalDateTime timeStamp = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");
		
		boolean append = newFile.exists() ? true : false;
		
		try(PrintWriter logWriter = new PrintWriter(new FileOutputStream (newFile, append))){
			logWriter.append(formatter.format(timeStamp) + " " + "FEED MONEY: $" + moneyAdded + " $"+ wallet/100 + "\n");
	}
}
	public void logItemBought(String name, String location, double wallet, double price) throws IOException {
		File newFile = new File("log.txt");
		LocalDateTime timeStamp = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");
		
		boolean append = newFile.exists() ? true : false;
		
		try(PrintWriter logWriter = new PrintWriter(new FileOutputStream (newFile, append))){
			logWriter.append(formatter.format(timeStamp) + " " + name + " " + location + " $" + (wallet+price)/100 + " $" + wallet/100 + "\n");
	}
}
	public void logChange(double wallet, double change) throws IOException {
		File newFile = new File("log.txt");
		LocalDateTime timeStamp = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");
		
		boolean append = newFile.exists() ? true : false;
		
		try(PrintWriter logWriter = new PrintWriter(new FileOutputStream (newFile, append))){
			logWriter.append(formatter.format(timeStamp) + " " + "GIVE CHANGE: $" + wallet/100 + " $"+ change/100 + "\n");
	}
}
	
}


