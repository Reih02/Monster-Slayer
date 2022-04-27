package main;

import monsters.*;

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
	
	private Monster startingMonster;
	
	/**
	 * Sets up game by getting the user's chosen variables
	 * @param playerName
	 * @param gameLength
	 * @param startMonster
	 * @param difficulty
	 */
	public void gameSetup(String playerName, int gameLength, String startMonster, boolean difficulty) {
		
		int days = gameLength;
		
		if (playerName.length() < 3 || playerName.length() > 15 || !alphaOnly(playerName)) {
			System.out.println("Please change your name so that it contains no letters and is between 3 and 15 characters");
		} else {
			slayer = new Slayer(playerName, 1); // Creates Slayer object on first day
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
	
	public boolean alphaOnly(String name) {
		for (int i=0; i < name.length(); i++) {
			char letter = name.charAt(i);
			if (!Character.isLetter(letter)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
	}
	
	
	
}
