package com.techelevator;

import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class ChipTest {
	
	Chips chip;
	@Before
	public void createTest() {
		chip = new Chips ("Stackers", 145, "A2", 5);
	}
	
	@After
	public void teardown() {
		
	}
	@Test
	public void test_01_getMessage_returnMessage() {
		String actualResult = chip.getMessage();
		String expectedResult = "Crunch Crunch, Yum!";
		Assert.assertEquals(expectedResult, actualResult);
	}
}