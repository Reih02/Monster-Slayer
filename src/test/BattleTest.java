package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Battle;
import main.Monster;
import monsters.ExpertYe;

/**
 * Test for the Battle class
 * @author Orion Lynch and Reilly Haskins.
 *
 */
class BattleTest {
	
	/**
	 * Battle class to test
	 */
	private Battle battle;
	
	/**
	 * First masterYi object that gets used in the battle test.
	 */
	private Monster masterYi1;
	
	/**
	 * Second masterYi object that gets used in the battle test.
	 */
	private Monster masterYi2;
	
	/**
	 * Third masterYi object that gets used in the battle test.
	 */
	private Monster masterYi3;
	
	/**
	 * ArrayList that takes monster objects of enemyMonsters.
	 */
	private ArrayList<Monster> enemyMonsters = new ArrayList<Monster>();
	
	/**
	 * ArrayList that takes monster objects of alliedMonsters.
	 */
	private ArrayList<Monster> alliedMonsters = new ArrayList<Monster>();
	
	/**
	 * Creates all the different masterYi objects that will be used in the testing and puts 1 object in each list.
	 */
	@BeforeEach
	public void testSetUp() {
		masterYi1 = new ExpertYe(false);
		masterYi2 = new ExpertYe(false);
		masterYi3 = new ExpertYe(false);
		enemyMonsters.add(masterYi1);
		alliedMonsters.add(masterYi2);		
	}

	/**
	 * Test that sets the only monster in the allied monster list to 0 current health and checks to see that the 
	 * allied monsters did not win the fight.
	 */
	@Test
	void alliedMonstersUnconciousTest() {
		alliedMonsters.get(0).setCurrentHealth(0);
		battle = new Battle(enemyMonsters, alliedMonsters);
		assertFalse(battle.fight());		
	}
	
	/**
	 * Tests the attack method in the Battle class and makes sure it works as expected.
	 */
	@Test
	void attackTest() {
		battle = new Battle(enemyMonsters, alliedMonsters);
		battle.attack(masterYi1, masterYi2);
		assertEquals(80, masterYi2.getCurrentHealth());
		
	}
	
	/**
	 * Tests the fight method when the allied monsters are stronger than the enemy monsters
	 */
	@Test
	void alliedMonsterWinTest() {
		alliedMonsters.add(masterYi3);		
		battle = new Battle(enemyMonsters, alliedMonsters);
		assertTrue(battle.fight());
	   
	}
	
	/**
	 * Tests the fight method when the allied monsters have equal strength to the enemy monsters
	 */
	@Test
	void alliedMonsterLoseTest() {
		battle = new Battle(enemyMonsters, alliedMonsters);
		assertFalse(battle.fight());
	}
	
	/**
	 * Tests the fight method when the allied monsters have less strength to the enemy monsters
	 */
	@Test
	void alliedMonsterLoseTest2() {
		enemyMonsters.add(masterYi3);
		battle = new Battle(enemyMonsters, alliedMonsters);
		assertFalse(battle.fight());
	}

}
