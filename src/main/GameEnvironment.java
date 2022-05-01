package main;

import java.util.ArrayList;

import items.*;
import monsters.*;

/**
 * GameEnvironment class that manages the game and calls methods to make the game work
 * @author Orion Lynch and Reilly Haskins
 *
 */
public class GameEnvironment {
	
	/**
	 * Random Environment class initialised
	 */
	private RandomEnvironment randomEnv;
	
	/**
	 * Inventory class initialised
	 */
	private Inventory inventory;
	
	/**
	 * Shop class initialised
	 */
	private Shop shop;
	
	/**
	 * The user's Slayer class
	 */
	private Slayer slayer;
	
	private boolean difficultySetting;
	
	/**
	 * ArrayList of ArrayLists of monsters representing the monsters to fight in a battle
	 */
	private ArrayList<ArrayList<Monster>> battle1;
	
	/**
	 * second battle
	 */
	private ArrayList<ArrayList<Monster>> battle2;
	
	/**
	 * third battle
	 */
	private ArrayList<ArrayList<Monster>> battle3;
	
	/**
	 * The user's starting monster
	 */
	private Monster startingMonster;
	
	/**
	 * The amount of days the game will last for
	 */
	private int days;
	
	/**
	 * The amount of gold awarded for winning a battle
	 */
	private int goldGained;
	
	/**
	 * The amount of points gained for winning a battle
	 */
	private int pointsGained;
	
	/**
	 * Sets up game by getting the user's chosen variables
	 * @param playerName
	 * @param gameLength
	 * @param startMonster
	 * @param difficulty
	 */
	public void gameSetup(String playerName, int gameLength, String startMonster, boolean difficulty) {
		
		days = gameLength;
		difficultySetting = difficulty;
		
		if (playerName.length() < 3 || playerName.length() > 15 || !lettersOnly(playerName)) {
			System.out.println("Please change your name so that it contains no letters and is between 3 and 15 characters");
		} else {
			slayer = new Slayer(playerName, 1, 150, 0); // Creates Slayer object on first day and with 150 gold (?) and with 0 points
			inventory = new Inventory();
			// TESTING
			HealthPotion healthPot = new HealthPotion(difficulty);
			inventory.addItem(healthPot);
			StrengthPotion strengthPot = new StrengthPotion(difficulty);
			inventory.addItem(strengthPot);
			Carrot carrot = new Carrot(difficulty);
			inventory.addItem(carrot);
			// TESTING
			shop = new Shop(difficulty);
			switch(startMonster) {
				case "BloodMuncha":
					startingMonster = new BloodMuncha(difficulty);
					break;
				case "Garen":
					startingMonster = new Garen(difficulty);
					break;
				case "Katarina":
					startingMonster = new Katarina(difficulty);
					break;
				case "Malphite":
					startingMonster = new Malphite(difficulty);
					break;
				case "MasterYi":
					startingMonster = new MasterYi(difficulty);
					break;
				case "Volibear":
					startingMonster = new Volibear(difficulty);
					break;
			}
			slayer.addMonster(startingMonster);
			slayer.getCurrMonsters().get(0).setCurrentHealth(50);
			randomEnv = new RandomEnvironment(slayer.getCurrMonsters(), difficulty);
			// Sets the gold and points gained from winning battles depending on difficulty
			if (difficultySetting == true) {
				goldGained = 80;
				pointsGained = 1000;
			} else {
				goldGained = 100;
				pointsGained = 500;
			}
		}
		
	}
	
	/**
	 * Method that checks if name string has only alphanumeric letters in it
	 * @param name
	 * @return
	 */
	public boolean lettersOnly(String name) {
		for (int i=0; i < name.length(); i++) {
			char letter = name.charAt(i);
			if (!Character.isLetter(letter)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Method that calls increaseDays method in slayer object,
	 * as long as user is not out of days 
	 */
	public void changeDay() {
		if (slayer.getDaysPassed() + 1 <= days) {
			slayer.increaseDays();
		} else {
			System.out.println("Out of days!");
		}
	}
	
	/**
	 * Method that checks if the game should finish depending on:
	 * - if amount of days that have passed exceeds game length
	 * - or if user has no monsters and not enough gold to buy any more monsters
	 * @return
	 */
	public boolean shouldGameFinish() {
		if (slayer.getDaysPassed() > days || (slayer.getCurrMonsters().size() <= 0 && slayer.getGold() < 100)){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns the stats of gold, days passed, and days left in game
	 * @return
	 */
	public String getStats() {
		System.out.println(slayer.getGold());
		String string = "Your current gold: " + slayer.getGold() + "\nThe current day: " + slayer.getDaysPassed() + "\nYour days left: " + (days - slayer.getDaysPassed());
		return string;
		
	}
	
	/**
	 * Returns a string containing properties of each current monster on the user's team
	 * @return
	 */
	public String getTeamProperties() {
		// name of each monster
		// properties of each monster
		// order of monsters
		String statsString = "-------------";
		for (int i=0; i < slayer.getCurrMonsters().size(); i++) {
			Monster currMonster = slayer.getCurrMonsters().get(i);
			statsString += String.format("\nMonster %s:\n", i+1);
			statsString += String.format("NAME: '%s'", currMonster.getName()) + "\n";
			statsString += String.format("HP: %o/%o, DMG: %o, HEAL: %o", currMonster.getCurrentHealth(), currMonster.getMaxHealth(), currMonster.getDamage(), currMonster.getHealAmount());
			statsString += "\n-------------";
		}
		return statsString;
	}
	
	/**
	 * Returns a string containing the name of all items in player's inventory, alongside with their bonus value
	 * @return
	 */
	public String getPlayerInventory() {
		// TODO: Allow user to use item on a monster
		String inventoryString = "-------------";
		for (int i=0; i < inventory.getInventoryList().size(); i++) {
			Item currItem = inventory.getInventoryList().get(i); 
			inventoryString += String.format("\nITEM: %s", currItem.getName()) + "\n";
			inventoryString += String.format("EFFECT: %o", currItem.getBonusValue()) + "\n";
			inventoryString += "-------------";
		}
		return inventoryString;
	}
	
	public void useItem(int itemIndex, int monsterIndex) {
		Item item = inventory.getInventoryList().get(itemIndex);
		Monster monster = slayer.getCurrMonsters().get(monsterIndex);
		if (item.getClass().getName() == "items.HealthPotion") {
			monster.setCurrentHealth(monster.getCurrentHealth() + item.getBonusValue()); // Increases health of monster (potion)
			inventory.removeItem(item);
		} else if (item.getClass().getName() == "items.StrengthPotion") {
			monster.setDamage(monster.getDamage() + item.getBonusValue()); // Increases strength of monster
			inventory.removeItem(item);
		} else {
			monster.setCurrentHealth(monster.getCurrentHealth() + item.getBonusValue()); // Increases health of monster (food)
			inventory.removeItem(item);
		}
	}
	
	public String viewBattles() {
		// Show gold and points gained for winning each battle (scale with difficulty)
		ArrayList<ArrayList<ArrayList<Monster>>> battles = new ArrayList<ArrayList<ArrayList<Monster>>>();
		battle1 = randomEnv.generateBattles(slayer.getDaysPassed());
		battle2 = randomEnv.generateBattles(slayer.getDaysPassed());
		battle3 = randomEnv.generateBattles(slayer.getDaysPassed());
		battles.add(battle1);
		battles.add(battle2);
		battles.add(battle3);
		String returnString = "-------------";
		// Inefficient? Fixed amount of battles to loop through at least (3)
		for (int i=0; i < battles.size(); i ++) {
			returnString += String.format("\nBATTLE %o:\n", i+1) + "(Gold gained: " + goldGained + ")\n" + "(Points gained: " + pointsGained + ")\n";
			for (int j=0; j < battles.get(i).size(); j++) {
				returnString += String.format("%s", battles.get(i).get(j).get(0).getName()) + "\n";
			}
		}
		returnString += "-------------";
		return returnString;
	}
	
	public String chooseBattle() {
		// Only one time per battle
		// Can't battle if all monsters fainted
		// Lose battle if all monsters faint during battle
		// Reward user with gold and points if battle won
		return "Unfinished";
	}
	
	// Add functionality for battling process
	
	public String visitShop() {
		// Allow selling of monsters and items back to shop
		// View 3 monsters on sale  
		// Allow purchase of monster only if user has less than 4 monsters already
		// Implement monster rarity system?
		// View 3 items for sale
		// Add item to inventory when bought
		String shopVisitString = "-------------";
		shopVisitString += "\nYour current gold: " + slayer.getGold();
		return "Unfinished";
		
	}
	
	public String sleep() {
		// Update all items in shop
		// Update all battles
		// Add random events 10%? chance of each (monster levels up, monster leaves, Random monster joins)
		changeDay();
		if (shouldGameFinish()) {
			return String.format("---GAME ENDED---\nName: %s\nDays lasted: %o/%o\nPoints earned: %o\nGold earned: %o", slayer.getName(), slayer.getDaysPassed(), days, slayer.getPoints(), slayer.getGoldTotal());
		} else {
			for (int i=0; i < slayer.getCurrMonsters().size(); i++) {
				slayer.getCurrMonsters().get(i).setCurrentHealth(slayer.getCurrMonsters().get(i).getHealAmount()); // Heals monsters (Too complicated?)
			}
			return "Sleeping... zz";
		}
	}
	
	// Testing purposes
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.gameSetup("Steve", 5, "Garen", false);
		System.out.println(game.viewBattles());
	}
	
	
	
}
