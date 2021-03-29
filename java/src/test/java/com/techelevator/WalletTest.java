package com.techelevator;

import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class WalletTest {
	
	@Test
	public void test_01_addToBalance() {
		Wallet test = new Wallet();
		test.addToBalance(10);
		Assert.assertEquals(1000, test.getBalance());
	}
	
	@Test
	public void test_02_subtractFromBalance() {
		Wallet test = new Wallet();
		test.addToBalance(10);
		test.subtractFromBalance(300);;
		Assert.assertEquals(700, test.getBalance());
	}
	
	@Test
	public void test_03_getChange() {
		Wallet test = new Wallet();
		test.addToBalance(140);
		test.getChange();;
		Assert.assertEquals(0, test.getBalance());
	}
}
