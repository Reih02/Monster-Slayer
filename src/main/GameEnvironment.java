package main;

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
		
		days = gameLength;
		
		if (playerName.length() < 3 || playerName.length() > 15 || !lettersOnly(playerName)) {
			System.out.println("Please change your name so that it contains no letters and is between 3 and 15 characters");
		} else {
			slayer = new Slayer(playerName, 1, 50); // Creates Slayer object on first day and with 50 gold (?) 
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
	 * Method that checks if the game should finish depending on the 
	 * amount of days that have passed
	 * @return
	 */
	public boolean shouldGameFinish() {
		if (slayer.getDaysPassed() > days) {
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
		return String.format("Your current gold: %o\nThe current day: %o\nYour days left: %o", slayer.getGold(), slayer.getDaysPassed(), (days - slayer.getDaysPassed()));
	}
	
	public static void main(String[] args) {
		
	}
	
	
	
}
