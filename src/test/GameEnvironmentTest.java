package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.GameEnvironment;
import main.Monster;
import monsters.ExpertYe;
import monsters.Jaren;
/**
 * Tests some of the methods in the GameEnvironment class to ensure they are working properly
 * @author Orion Lynch and Reilly Haskins.
 *
 */
class GameEnvironmentTest {
	
	/**
	 * Game environment attribute for testing.
	 */
	GameEnvironment game;
	
	
    /**
     * Initializes a GameEnvironment object to be used in each of the tests.
     */
	@BeforeEach
	public void testSetup() {
		game = new GameEnvironment();
		game.setupGameEnvironment("Orion",5,"Jaren",false);
	}
	
	/**
	 * Tests for valid and invalid player names.
	 */
	@Test
	void validNameTest() {
		game.isNameValid("Orion");
		assertTrue(game.isNameValid("Orion"));
		assertFalse(game.isNameValid("*#Orion("));
		assertFalse(game.isNameValid("or"));
		assertFalse(game.isNameValid("Orionnnnnnnnnnnnnnnnnnn"));
	}
	
	/**
	 * Tests that the game shouldn't finish while the number of days are less than the required amount to end and that the game should finish
	 * when the number of days surpass that which is needed.
	 */
	@Test
	void shouldGameFinishTest() {
		assertFalse(game.shouldGameFinish());
		for(int i = 0 ; i < game.getMaxDays(); i++) {
		    game.getSlayer().increaseDays();
		    }
		
		assertTrue(game.shouldGameFinish());
		
	}
	
	/**
	 * Tests that the player loses battle and the correct message is printed and that
	 * when the player wins the battle the correct message is printed.
	 */
	@Test 
	void testBattles() {
		game.viewBattles();
		assertEquals("You lost the battle.. Better luck next time", game.chooseBattle(1));
		game.getSlayer().addMonster(new ExpertYe(false));
		game.getSlayer().addMonster(new ExpertYe(false));
		assertEquals("You have won the battle! You earned 105 gold and 520 points. 1 Monster(s) fainted.", game.chooseBattle(0));					
	}
	
	/**
	 * Tests that when you buy an Item the correct string gets returned for Monsters and Items
	 */
	@Test
	void buyItemTest() {
		game.buyPurchasable(0);
		assertEquals("Apple purchased!\nYour remaining gold: 136", game.buyPurchasable(0));
		assertEquals("Name: 'Apple', Cost: 7G, Value: 5G, Bonus: 7 used on Name: Jaren, Cost: 100G, DMG: 25, HP: 90/90, Daily heal: 15", game.useItem(0, 0));
		String monsterName = game.getMonsterInShop().get(0).getName();
		assertEquals(monsterName + " purchased!\nYour remaining gold: 36" ,game.buyMonster(0));
		game.buyMonster(1);
		assertEquals("Not enough gold!", game.buyMonster(1));
		game.buyPurchasable(1);
		assertEquals("Item not found", game.sellItem(0));
		
	}
	
	/**
	 * Tests some of the stats to make sure they update correctly when certain actions are performed.
	 */
	@Test
	void correctStatsTest() {
		assertEquals("Your current gold: 150 \nThe current day: 1 \nYour days left: 4", game.getStats());
		game.buyMonster(1);
		assertEquals("Your current gold: 50 \nThe current day: 1 \nYour days left: 4", game.getStats());
		game.sleep();
		game.sleep();
		game.sleep();
		game.sleep();
		assertEquals("Your current gold: 50 \nThe current day: 5 \nYour days left: 0", game.getStats());
		game.viewStringBattles();
	}
	

}
