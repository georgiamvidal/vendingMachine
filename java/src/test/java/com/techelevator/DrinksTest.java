package com.techelevator;

import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class DrinksTest {
	
	Drinks drink;
	@Before
	public void createTest() {
		drink = new Drinks ("Cola", 125, "C1", 5);
	}
	
	@After
	public void teardown() {
		
	}
	@Test
	public void test_01_getMessage_returnMessage() {
		String actualResult = drink.getMessage();
		String expectedResult = "Glug Glug, Yum!";
		Assert.assertEquals(expectedResult, actualResult);
	}
}