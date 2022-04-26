package main;

import monsters.Garen;

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
	 * Sets up game by getting the user's chosen variables
	 * @param playerName
	 * @param gameLength
	 * @param startMonster
	 * @param difficulty
	 */
	public void gameSetup(String playerName, int gameLength, Monster startMonster, String difficulty) {
		
		int days = gameLength;
		
		if (playerName.length() < 3 || playerName.length() > 15 || !alphaOnly(playerName)) {
			System.out.println("Please change your name so that it contains no letters and is between 3 and 15 characters");
		} else {
			// do something with the difficulty (change health, cost of items, etc.)?
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
