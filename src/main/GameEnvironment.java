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
	
	/**
	 * The user's starting monster
	 */
	private Monster startingMonster;
	
	/**
	 * ArrayList storing all monsters
	 */
	private ArrayList<Monster> monsters;
	
	/**
	 * The amount of days the game will last for
	 */
	private int days;
	
	/**
	 * Sets up game by getting the user's chosen variables
	 * @param playerName
	 * @param gameLength
	 * @param startMonster
	 * @param difficulty
	 */
	public void gameSetup(String playerName, int gameLength, String startMonster, boolean difficulty) {
		
		monsters = new ArrayList<>();
		days = gameLength;
		
		if (playerName.length() < 3 || playerName.length() > 15 || !lettersOnly(playerName)) {
			System.out.println("Please change your name so that it contains no letters and is between 3 and 15 characters");
		} else {
			slayer = new Slayer(playerName, 1, 150, 0); // Creates Slayer object on first day and with 150 gold (?) and with 0 points
			inventory = new Inventory();
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
			monsters.add(startingMonster);
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
		if (slayer.getDaysPassed() > days || (monsters.size() <= 0 && slayer.getGold() < 100)){
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
		for (int i=0; i < monsters.size(); i++) {
			Monster currMonster = monsters.get(i);
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
		return inventory.getInventoryList();
	}
	
	public String viewBattles() {
		// Show 3 optional battles (random gen, current day)
		// Show gold and points gained for winning each battle (scale with difficulty)
		return "Unfinished";
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
		
	}
	
	public String sleep() {
		// Update all items in shop
		// Update all battles
		// heal monsters
		// Add random events 10%? chance of each (monster levels up, monster leaves, Random monster joins)
		changeDay();
		if (shouldGameFinish()) {
			// add gold gained stat
			return String.format("---GAME ENDED---\nName: %s\n%o\n%o", slayer.getName(), days, slayer.getPoints());
		} else {
			return "Sleeping... zz";
		}
	}
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.gameSetup("Steve", 5, "Garen", false);
		System.out.println(game.getStats());
		System.out.println(game.getTeamProperties());
		System.out.println(game.getPlayerInventory());
	}
	
	
	
}
