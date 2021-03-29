package com.techelevator;

import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;


public class VendingMachineItemsTest {
	

	@Test
	public void test_01_getStock_Return_5() {
		VendingMachineItems VMI = new VendingMachineItems("Triplemint", 75, "D4", 5);
		VMI.getStock();
		Assert.assertEquals(5, VMI.getStock());
	}
	@Test
	public void test_02_getLocation_Return_D4() {
	VendingMachineItems VMI = new VendingMachineItems("Triplemint", 75, "D4", 5);
	VMI.getLocation();
	Assert.assertEquals("D4", VMI.getLocation());
	}
	@Test
	public void test_03_getPrice_Return_75() {
	VendingMachineItems VMI = new VendingMachineItems("Triplemint", 75, "D4", 5);	
	VMI.getPrice();
	Assert.assertEquals(75, VMI.getPrice());
	}
	@Test
	public void test_04_getname_Return_Triplemint() {
	VendingMachineItems VMI = new VendingMachineItems("Triplemint", 75, "D4", 5);
	VMI.getName();
	Assert.assertEquals("Triplemint", VMI.getName());
	}

	@Test
	public void test_05_dispenseItem_Return_4() {
	VendingMachineItems VMI = new VendingMachineItems("Triplemint", 75, "D4", 5);
	VMI.dispenseItem();
	Assert.assertEquals(4, VMI.getStock());
	}
	
	@Test
	public void test_06_dispenseItem_doesntReturn_neg1() {
	VendingMachineItems VMI = new VendingMachineItems("Triplemint", 75, "D4", 0);
	VMI.dispenseItem();
	Assert.assertEquals(0, VMI.getStock());
	}
	
	@Test
	public void test_07_setName_Return_name() {
	VendingMachineItems VMI = new VendingMachineItems("Triplemint", 75, "D4", 5);
	VMI.setName("Double Bubble");
	Assert.assertEquals("Double Bubble", VMI.getName());
	}
	
	@Test
	public void test_08_setLocation_Return_location() {
	VendingMachineItems VMI = new VendingMachineItems("Triplemint", 75, "D4", 5);
	VMI.setLocation("D9");
	Assert.assertEquals("D9", VMI.getLocation());
	}
}


	


//@Test
//public void drink_purchase_test() {
//	DrinkClass drinkTest = new DrinkClass("Heavy", 1.50);
//	drinkTest.takeOne();
//	Assert.assertEquals(4, drinkTest.getStock());		
//}
//
//@Test
//public void drink_is_available_test() {
//	DrinkClass drinkTest = new DrinkClass("Heavy", 1.50);
//	Assert.assertEquals(true, drinkTest.takeOne());		
//}
//
//@Test
//public void drink_is_not_available_test() {
//	DrinkClass drinkTest = new DrinkClass("Heavy", 1.50);
//	for(int i = 1; i < 6; i++) {
//		drinkTest.takeOne();
//	}
//	Assert.assertEquals(false, drinkTest.takeOne());		
//}
//
//@Test
//public void drink_price_test() {
//	DrinkClass drinkTest = new DrinkClass("Heavy", 1.50);
//	Assert.assertEquals(1.50, drinkTest.getPrice(), 1e-15);		
//}

