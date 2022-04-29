package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Monster;
import main.RandomEnvironment;

import monsters.MasterYi;

/**
 * Random Environment test that ensures the class is working as expected.
 * @author Orion Lynch and Reilly Haskins.
 *
 */
class RandomEnvironmentTest {
	
	/**
	 * Random Environment object used for testing.
	 */
	private RandomEnvironment randomTest;
	
	/**
	 * ArrayList object that takes Monster objects used for testing.
	 */
	private ArrayList<Monster> testList;
		
	/**
	 * Test that creates a List with a monster in it and a Random Environment object with the List.
	 */
	@BeforeEach
	public void setUpTests() {
		MasterYi masterYi = new MasterYi(false);
		testList = new ArrayList<Monster>();
		testList.add(masterYi);
		randomTest = new RandomEnvironment(testList,false);
	}

	/**
	 * Test that checks the monsters max health and damage after it has leveled up to see it has increased and checks to make sure it hasn't increased when the monster doesn't level up.
	 */
	@Test
	public void testMonsterLevelUp() {
		boolean record = randomTest.monsterLevelUp();
		Monster monster = testList.get(0);
		if(record) {
			assertEquals(110, monster.getMaxHealth());
			assertEquals(22, monster.getDamage());
		}
		else {
			assertEquals(100, monster.getMaxHealth());
			assertEquals(20, monster.getDamage());
			
		}
		
		
	}
	
	/**
	 * Test that checks if the size of the list of monsters decreases when the random event is triggered and doesn't decrease when the random event is not triggered.
	 */
	@Test
	public void testMonsterLeaves() {
		boolean record = randomTest.monsterLeaves();
		if(record) {
			assertEquals(0,testList.size());
		}
		else {
			assertEquals(1,testList.size());
		}
		
	}
	
	
	/**
	 * Test that checks if the size of the list of monsters increases when the random event is triggered and doesn't increase when the random event is not triggered.
	 */
	@Test
	public void testMonsterArrives() {
		boolean record = randomTest.monsterArrives();
		if(record) {
			assertEquals(2,testList.size());
		}
		else {
			assertEquals(1,testList.size());
		}
		
	}
	
	/**
	 * Tests that there are monsters in the shop.
	 */
	@Test
	public void testMonstersInShop() {
		assertNotNull(randomTest.monstersInShop());
	}

}
