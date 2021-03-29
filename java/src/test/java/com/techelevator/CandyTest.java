package com.techelevator;

import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class CandyTest {
	
	Candy candy;
	@Before
	public void createTest() {
		candy = new Candy ("Cowtales", 150, "B2", 5);
	}
	
	@After
	public void teardown() {
		
	}
	@Test
	public void test_01_getMessage_returnMessage() {
		String actualResult = candy.getMessage();
		String expectedResult = "Munch Munch, Yum!";
		Assert.assertEquals(expectedResult, actualResult);
	}
}
