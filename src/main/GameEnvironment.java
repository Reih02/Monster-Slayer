package main;

import java.util.ArrayList;
import java.util.Scanner;

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
	
	/**
	 * The difficulty of the game
	 */
	private boolean difficultySetting;
	
	/**
	 * Stores the available battles to the user
	 */
	private ArrayList<ArrayList<Monster>> battles;
	
	
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
	 * The monsters that are currently in the shop.
	 */
	private ArrayList<Monster> monstersInShop;
	
	/**
	 * Sets up game by getting the user's chosen variables
	 * @param playerName
	 * @param gameLength
	 * @param startMonster
	 * @param difficulty
	 */
	public GameEnvironment(String playerName, int gameLength, String startMonster, boolean difficulty) {
		
		days = gameLength;
		difficultySetting = difficulty;
		
		if (playerName.length() < 3 || playerName.length() > 15 || !lettersOnly(playerName)) {
			System.out.println("Please change your name so that it contains no spaces and is between 3 and 15 characters");
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
			slayer.addMonster(startingMonster);
			slayer.getCurrMonsters().get(0).setCurrentHealth(50);
			randomEnv = new RandomEnvironment(slayer.getCurrMonsters(), difficulty);
			changePurchasableMonsters();
			// Sets the gold and points gained from winning battles depending on difficulty
			if (difficultySetting == true) {
				goldGained = 80;
				pointsGained = 1000;
			} else {
				goldGained = 100;
				pointsGained = 500;
			}
		}
		monstersInShop = shop.getMonsterList(randomEnv.monstersInShop());
		randomEnv.generateBattles(days);
		
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
	 * Method that calls increaseDays method in slayer object
	 */
	public void changeDay() {
		slayer.increaseDays();
	}
	
	public void changePurchasableMonsters() {
		ArrayList<Monster> newMonsters = randomEnv.monstersInShop();
		for (int i=0; i < newMonsters.size(); i++) {
			shop.addPurchasable(newMonsters.get(i));
		}
	}
	
	/**
	 * Method that checks if the game should finish depending on:
	 * - if amount of days that have passed exceeds game length
	 * - or if user has no monsters and not enough gold to buy any more monsters
	 * @return
	 */
	public boolean shouldGameFinish() {
		if (slayer.getDaysPassed() > days){
			System.out.println("Ran out of days!");
			return true;
		}
		if (slayer.getCurrMonsters().size() <= 0 && slayer.getGold() < 100) {
			System.out.println("Ran out of monsters!");
			return true;
		}
		
		return false;
	}
	
	/**
	 * Returns the stats of gold, days passed, and days left in game
	 * @return
	 */
	public String getStats() {
		String string = "Your current gold: " + slayer.getGold() + " \nThe current day: " + slayer.getDaysPassed() + " \nYour days left: " + (days - slayer.getDaysPassed());
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
	
	/**
	 * Method to sell an item from user's inventory
	 * @param itemNum
	 * @return
	 */
	public String sellItem(int itemNum) {
		if (itemNum < 1 || itemNum > inventory.getInventoryList().size()) {
			return "Item not found";
		} else {
			Item selectedItem = inventory.getInventoryList().get(itemNum - 1);
			int itemValue = selectedItem.getSellPrice();
			slayer.increaseGold(itemValue);
			inventory.removeItem(selectedItem);
			return "Item sold!\nYour current gold: " + slayer.getGold();
		}
	}
	
	/**
	 * Uses item from inventory on monster in team
	 * @param itemIndex
	 * @param monsterIndex
	 */
	public String useItem(int itemIndex, int monsterIndex) {
		Item item = inventory.getInventoryList().get(itemIndex);
		Monster monster = slayer.getCurrMonsters().get(monsterIndex);
		if (item.getClass().getName() == "items.HealthPotion") {
			monster.setCurrentHealth(monster.getCurrentHealth() + item.getBonusValue()); // Increases health of monster (potion)
			inventory.removeItem(item);
			return "Health Potion used on " + monster;
		} else if (item.getClass().getName() == "items.StrengthPotion") {
			monster.setDamage(monster.getDamage() + item.getBonusValue()); // Increases strength of monster
			inventory.removeItem(item);
			return "Strength Potion used on " + monster;
		} else {
			monster.setCurrentHealth(monster.getCurrentHealth() + item.getBonusValue()); // Increases health of monster (food)
			inventory.removeItem(item);
			return String.format("%s used on ", item) + monster;
		}
	}
	
	public String viewBattles() {
		// Show gold and points gained for winning each battle (scale with difficulty)
		battles = randomEnv.generateBattles(slayer.getDaysPassed());
		String returnString = "-------------";
		// Inefficient? Fixed amount of battles to loop through at least (3)
		for (int i=0; i < battles.size(); i ++) {
			returnString += String.format("\nBATTLE %o:\n", i+1) + "(Gold gained: " + goldGained + ")\n" + "(Points gained: " + pointsGained + ")\n";
			for (int j=0; j < battles.get(i).size(); j++) {
				returnString += String.format("%s", battles.get(i).get(j).getName()) + "\n";
			}
		}
		returnString += "-------------";
		return returnString;
	}
	
	/**
	 * Method to construct a Battle object and run Battle.fight() on the 
	 * user's selected battle
	 * @param battleNum
	 * @return
	 */
	public String chooseBattle(int battleNum) {
		ArrayList<Monster> enemyMonsters = new ArrayList<Monster>();
		for (int i=0; i < battles.get(battleNum).size(); i++) {
			enemyMonsters.add(battles.get(battleNum).get(i));
		}
		if (slayer.getCurrMonsters().size() <= 0) {
			return "You don't have any monsters available!";
		} else {
			Battle battleSelected = new Battle(enemyMonsters, slayer.getCurrMonsters());
			boolean battleOutcome = battleSelected.fight();
			battles.remove(battleNum);
			 if (battleOutcome == true) {
				 return "You have won the battle! You earned " + goldGained + " gold and " + pointsGained + " points";
			 } else {
				 return "You lost the battle.. Better luck next time";
			 }
		}
	}
	
	// Add functionality for battling process
	
	public String visitShop() {
		// Allow selling of monsters and items back to shop
		// Allow purchase of monster only if user has less than 4 monsters already
		String shopVisitString = "-------------\n";
		shopVisitString += "Your current gold: " + slayer.getGold() + "\n";
		for (int i=0; i < shop.getPurchasableList().size(); i++) {
			shopVisitString += "\nITEM " + (i + 1) + ": " + shop.getPurchasableList().get(i).getName() + "\nPRICE: " + shop.getPurchasableList().get(i).getBuyPrice() + "\n";
		}
		shopVisitString += "-------------";
		return shopVisitString;
	}
	
	/**
	 * Method to buy a Purchasable object from the shop
	 * @param itemNum
	 * @return
	 */
	public String buyPurchasable(int itemNum) {
		
		String itemBoughtName = shop.getPurchasableList().get(itemNum).getName();
		int price = shop.getPurchasableList().get(itemNum).getBuyPrice();
		if (price < slayer.getGold()) {
			inventory.addItem((Item) shop.getPurchasableList().get(itemNum));
				
			slayer.decreaseGold(price);
			return "" + itemBoughtName + " purchased!\nYour remaining gold: " + slayer.getGold();
			} else {
				return "Not enough gold!";
			}
		
	}
	
	/**
	 * Method to buy a Monster from the shop.
	 * @param itemNum the index of the Monster in the list.
	 * @return A string that displays whether you bought the monster or not.
	 */
	public String buyMonster(int itemNum) {
		String itemBoughtName = monstersInShop.get(itemNum).getName();
		int price = monstersInShop.get(itemNum).getBuyPrice();
		if(price < slayer.getGold()) {
			slayer.addMonster((Monster) monstersInShop.get(itemNum));
			slayer.decreaseGold(price);
			return "" + itemBoughtName + " purchased!\nYour remaining gold: " + slayer.getGold();
			
		}
		else {
			return "Not enough gold!";
		}
	}
	/**
	 * getter method that returns a list of monsters.
	 * @return An ArrayList filled with Monsters
	 */
	public ArrayList<Monster> getMonsterInShop(){
		return monstersInShop;
	}
	
	/**
	 * Makes the game progress to the next day, healing monsters, changing monsters in shop, generating new battles,
	 * and allowing monsters to arrive, leave, and level up depending on small odds.
	 * @return
	 */
	public String sleep() {
		changeDay();
		boolean gameStatus = shouldGameFinish();
		if (gameStatus == true) {
			return String.format("---GAME ENDED---\nName: %s\nDays lasted: %o/%o\nPoints earned: %o\nGold earned: %o", slayer.getName(), slayer.getDaysPassed(), days, slayer.getPoints(), slayer.getGoldTotal());
		} else {
			for (int i=0; i < slayer.getCurrMonsters().size(); i++) {
				slayer.getCurrMonsters().get(i).setCurrentHealth(slayer.getCurrMonsters().get(i).getHealAmount()); // Heals monsters (Too complicated?)
			}
			monstersInShop = shop.getMonsterList(randomEnv.monstersInShop());
			randomEnv.generateBattles(days);
			randomEnv.monsterArrives();
			randomEnv.monsterLeaves();
			randomEnv.monsterLevelUp();
			return "Sleeping... zz";
		}
	}
	
	// Testing purposes
	public static void main(String[] args) {
		/**GameEnvironment game = new GameEnvironment("Steve", 5, "Garen", false);
		
		System.out.println(game.viewBattles());
		System.out.println(game.chooseBattle(0));
		/**System.out.println(game.visitShop());
		System.out.println(game.getPlayerInventory());
		System.out.println(game.getTeamProperties());
		System.out.println(game.promptBuyPurchasable());
		System.out.println(game.getPlayerInventory());
		System.out.println(game.getTeamProperties());
		**/
	}
	
	
	
}
