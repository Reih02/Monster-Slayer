package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Monster;
import monsters.MasterYi;

/**
 * Test for the Monster class.
 * @author Orion Lynch and Reilly Haskins
 *
 */
class MonsterTest {
	
	/**
	 * Monster class to test
	 */
	private Monster testMonster;
	
	/**
	 * Creates a MasterYi object for each test
	 */
	@BeforeEach
	public void testSetUp() {
		testMonster = new MasterYi(false);
	}
    
	/**
	 * Tests the set health method and the get health method to ensure the Monster's health is what was expected.
	 */
	@Test
	void testCurrentHealth() {
		testMonster.setCurrentHealth(-10);
		assertEquals(0,testMonster.getCurrentHealth());
		
		
	}
	
	/**
	 * Tests the isFainted method to ensure that the Monster is fainted only when it's current health is set to 0.
	 */
	@Test
	void testIsFainted() {
		assertFalse(testMonster.isFainted());
		testMonster.setCurrentHealth(0);
		assertTrue(testMonster.isFainted());
	}

}
