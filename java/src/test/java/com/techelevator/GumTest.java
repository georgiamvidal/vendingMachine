package com.techelevator;

import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class GumTest {
	
	Gum gum;
	@Before
	public void createTest() {
		gum = new Gum ("Triplemint", 125, "D4", 75);

	}
	
	@After
	public void teardown() {
		
	}
	@Test
	public void test_01_getMessage_returnMessage() {
		String actualResult = gum.getMessage();
		String expectedResult = "Chew Chew, Yum!";
		Assert.assertEquals(expectedResult, actualResult);
	}
}