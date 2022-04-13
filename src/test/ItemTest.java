package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Item;
import items.*;

/*
 * Test for Item class
 * @author Orion Lynch and Reilly Haskins.
 * */
class ItemTest {

	/*
	 * Initialising objects for both potion and food types to test
	 * */
	private Item testApple;
	private Item testCarrot;
	private Item testSteak;
	private Item testHealthPotion;
	private Item testStrengthPotion;
	
	/*
	 * Creates potion and food items for each test
	 * */
	@BeforeEach
	public void setUp() throws Exception {
		testApple = new Apple();
		testCarrot = new Carrot();
		testSteak = new Steak();
		testHealthPotion = new HealthPotion();
		testStrengthPotion = new StrengthPotion();
	}

	/*
	 * Checks buy prices correct for potion and food
	 * */
	@Test
	final void testGetBuyPrice() {
		assertEquals(7, testApple.getBuyPrice());
		assertEquals(5, testCarrot.getBuyPrice());
		assertEquals(10, testSteak.getBuyPrice());
		assertEquals(25, testHealthPotion.getBuyPrice());
		assertEquals(25, testStrengthPotion.getBuyPrice());
	}

	/*
	 * Checks sell prices correct for potion and food
	 * */
	@Test
	final void testGetSellPrice() {
		assertEquals(5, testApple.getSellPrice());
		assertEquals(3, testCarrot.getSellPrice());
		assertEquals(7, testSteak.getSellPrice());
		assertEquals(20, testHealthPotion.getSellPrice());
		assertEquals(20, testStrengthPotion.getSellPrice());
	}

	/*
	 * Checks name assigned correctly
	 * */
	@Test
	final void testGetName() {
		assertEquals("Apple", testApple.getName());
		assertEquals("Carrot", testCarrot.getName());
		assertEquals("Steak", testSteak.getName());
		assertEquals("Health Potion", testHealthPotion.getName());
		assertEquals("Strength Potion", testStrengthPotion.getName());
	}

	
	/*
	 * Checks bonus value assigned correctly
	 * */
	@Test
	final void testGetBonusValue() {
		assertEquals(7, testApple.getBonusValue());
		assertEquals(5, testCarrot.getBonusValue());
		assertEquals(15, testSteak.getBonusValue());
		assertEquals(25, testHealthPotion.getBonusValue());
		assertEquals(5, testStrengthPotion.getBonusValue());
	}

}