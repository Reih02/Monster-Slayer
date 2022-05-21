package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import items.*;
import main.Inventory;
import main.Item;

/*
 * Test for Inventory class
 * @author Orion Lynch and Reilly Haskins.
 * */
class InventoryTest {

	private Item testApple = new Apple(false);
	private Item testHealthPotion = new HealthPotion(false);
	private Item testSteak;
	private Item testStrengthPotion;
	private Inventory testInventory;
	
	@BeforeEach
	public void setUp() throws Exception {
		testApple = new Apple(false);
		testHealthPotion = new HealthPotion(false);
		testInventory = new Inventory();
		testInventory.addItem(testApple);
		testInventory.addItem(testHealthPotion);
	}
	
	
	@Test
	void testAddItem() {
		testSteak = new Steak(false);
		testStrengthPotion = new StrengthPotion(false);
		testInventory.addItem(testSteak);
		testInventory.addItem(testStrengthPotion);
		assertEquals(4, testInventory.getInventoryList().size());
		testInventory.addItem(testStrengthPotion);
		assertEquals(5, testInventory.getInventoryList().size());
	}

	@Test
	void testRemoveItem() {
		assertEquals(2, testInventory.getInventoryList().size());
		testInventory.removeItem(testApple);
		assertEquals(1, testInventory.getInventoryList().size());
		testSteak = new Steak(false);
		testInventory.addItem(testSteak);
		testInventory.addItem(testHealthPotion);
		assertEquals(3, testInventory.getInventoryList().size());
	}

	@Test
	void testGetInventoryList() {
		assertEquals(2, testInventory.getInventoryList().size());
	}

}
