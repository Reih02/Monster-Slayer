package main;

import java.util.ArrayList;
import java.util.Scanner;

import gui.MainScreen;
import gui.SetupScreen;
import gui.StoreScreen;
import gui.UseItemScreen;
import gui.ViewTeamScreen;
import gui.BattleScreen;
import gui.InventoryScreen;
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
	private int baseGoldGained;
	
	/**
	 * The amount of points gained for winning a battle
	 */
	private int basePointsGained;
	
	/**
	 * The monsters that are currently in the shop.
	 */
	private ArrayList<Monster> monstersInShop;
	
	/**
	 * The index of selected item in InventoryScreen
	 */
	private int inventorySelectedItemIndex;
	
	/**
	 * Sets up game by getting the user's chosen variables
	 * @param playerName
	 * @param gameLength
	 * @param startMonster
	 * @param difficulty
	 */
	public void setupGameEnvironment(String playerName, int gameLength, String startMonster, boolean difficulty) {
		
		days = gameLength;
		difficultySetting = difficulty;
		slayer = new Slayer(playerName, 1, 150, 0); // Creates Slayer object on first day and with 150 gold (?) and with 0 points
		inventory = new Inventory();
		shop = new Shop(difficulty);
		switch(startMonster) {
			case "BloodEater":
				startingMonster = new BloodEater(difficulty);
				break;
			case "Jaren":
				startingMonster = new Jaren(difficulty);
				break;
			case "Katarine":
				startingMonster = new Katarine(difficulty);
				break;
			case "Maltite":
				startingMonster = new Maltite(difficulty);
				break;
			case "ExpertYe":
				startingMonster = new ExpertYe(difficulty);
				break;
			case "VolicityCub":
				startingMonster = new VolicityCub(difficulty);
				break;
		}
		slayer.addMonster(startingMonster);
		randomEnv = new RandomEnvironment(slayer.getCurrMonsters(), difficulty);
		if (difficultySetting == true) {
			baseGoldGained = 80;
			basePointsGained = 1000;
		} else {
			baseGoldGained = 100;
			basePointsGained = 500;
		}
		monstersInShop = shop.getMonsterList(randomEnv.monstersInShop());
		battles = viewBattles();
	}
	
	/**
	 * Method that checks if name string has only alphanumeric letters in it,
	 * and if it is between 3 and 15 chars long
	 * @param name
	 * @return true or false depending on outcome
	 */
	public boolean isNameValid(String name) {
		int stringLength = 0;
		for (int i=0; i < name.length(); i++) {
			if (stringLength > 15) {
				return false;
			} else {
				stringLength ++;
				char letter = name.charAt(i);
				if (!Character.isLetter(letter)) {
					return false;
				}
			}
		}
		if (stringLength < 3) {
			return false;
		} else {
			return true;
		}
	}
	
	public void launchMainScreen() {
		new MainScreen(this);
	}
	
	public void closeMainScreen(MainScreen mainScreen) {
		mainScreen.closeWindow();
	}
	
	public void launchSetupScreen() {
		new SetupScreen(this);
	}
	
	public void closeSetupScreen(SetupScreen setupScreen) {
		setupScreen.closeWindow();
	}
	
	public void launchStoreScreen() {
		new StoreScreen(this);
	}
	
	public void closeStoreScreen(StoreScreen storeScreen) {
		storeScreen.closeWindow();
	}
	
	public void launchInventoryScreen() {
		new InventoryScreen(this);
	}
	
	public void closeInventoryScreen(InventoryScreen inventoryScreen) {
		inventoryScreen.closeWindow();
	}
	
	public void launchUseItemScreen() {
		new UseItemScreen(this);
	}
	
	public void closeUseItemScreen(UseItemScreen useItemScreen) {
		useItemScreen.closeWindow();
	}
	
	public void launchViewTeamScreen() {
		new ViewTeamScreen(this);
	}
	
	public void closeViewTeamScreen(ViewTeamScreen viewTeamScreen) {
		viewTeamScreen.closeWindow();
	}
	
	public void launchBattleScreen() {
		new BattleScreen(this);
	}
	
	public void closeBattleScreen(BattleScreen battleScreen) {
		battleScreen.closeWindow();
	}
	/**
	 * Gets index of selected item in GUI inventory screen
	 * for use in UseItemScreen
	 * @return
	 */
	public int getGuiItemIndex() {
		return inventorySelectedItemIndex;
	}
	
	/**
	 * Sets index of selected item in GUI inventory screen
	 * for use in UseItemScreen
	 * @param index
	 */
	public void setGuiItemIndex(int index) {
		inventorySelectedItemIndex = index;
	}
	
	/**
	 * Getter that returns the game difficulty.
	 */
	public boolean getDifficulty() {
		return difficultySetting;
	}
	
	/**
	 * Method that calls increaseDays method in slayer object
	 */
	public void changeDay() {
		slayer.increaseDays();
	}
	
	
	/**
	 * Gets gold balance directly from slayer class
	 * @return
	 */
	public int getSlayerGold() {
		return slayer.getGold();
	}
	
	/**
	 * Method that returns the slayer class.
	 * @return The slayer class.
	 */
	public Slayer getSlayer() {
		return slayer;
	}
	
	/**
	 * Gets days passed directly from slayer class
	 * @return
	 */
	public int getSlayerDay() {
		return slayer.getDaysPassed();
	}
	
	/**
	 * Gets the current amount of points from slayer class
	 * @return
	 */
	public int getSlayerScore() {
		return slayer.getPoints();
	}
	
	/**
	 * Gets maximum days user selected to play for
	 * For use in GUI
	 * @return
	 */
	public int getMaxDays() {
		return days;
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
	
	public ArrayList<Item> getInventoryRaw(){
		return inventory.getInventoryList();
	}
	
	public ArrayList<Item> guiGetInventory(){
		return inventory.getInventoryList();
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
	
	public ArrayList<Monster> getMonsters(){
		return slayer.getCurrMonsters();
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
	
	/**
	 * Method that calls the random battle generator and returns the list.
	 * @return
	 */
	public ArrayList<ArrayList<Monster>> viewBattles() {
		// Show gold and points gained for winning each battle (scale with difficulty)
		battles = randomEnv.generateBattles(slayer.getDaysPassed());
		return battles;
	}
	
	/**
	 * Method that returns the current possible battles.
	 * @return ArrayList filled with ArrayList with Monsters inside each one.
	 */
	public ArrayList<ArrayList<Monster>> getBattles(){
		return battles;
	}
	
	public ArrayList<String> viewStringBattles(){
		ArrayList<String> niceBattles = new ArrayList<String>();
		for(int i = 0; i < battles.size(); i++) {
			String addString = "";
			for (int j = 0; j < battles.get(i).size(); j++) {
				addString = addString + battles.get(i).get(j).getName() + ", ";
				
			}
			niceBattles.add(addString);
		}
		
		return niceBattles;
	}
	
	/**
	 * Method to construct a Battle object and run Battle.fight() on the 
	 * user's selected battle
	 * @param battleNum
	 * @return
	 */
	public String chooseBattle(int battleNum) {
		ArrayList<Monster> enemyMonsters = new ArrayList<Monster>();
		enemyMonsters = battles.get(battleNum);
		
		if (slayer.getCurrMonsters().size() <= 0) {
			return "You don't have any monsters available!";
		} else {
			Battle battleSelected = new Battle(enemyMonsters, slayer.getCurrMonsters());
			boolean battleOutcome = battleSelected.fight();
			 if (battleOutcome == true) {
				 int goldGained = baseGoldGained + (5 * enemyMonsters.size());
				 int pointsGained = basePointsGained + (20 * enemyMonsters.size());
				 slayer.increaseGold(goldGained);
				 slayer.increasePoints(pointsGained);
				 int casualities = 0;
				 for(int i = 0; i < slayer.getCurrMonsters().size(); i++) {
					 if(slayer.getCurrMonsters().get(i).isFainted()) {
						 casualities ++;
					 }
				 }
				 return "You have won the battle! You earned " + goldGained + " gold and " + pointsGained + " points. " + casualities + " Monster(s) fainted.";
			 } else {
				 return "You lost the battle.. Better luck next time";
			 }
		}
	}
	
	public void removeBattle(int index) {
		battles.remove(index);
	}

	
	
	/**
	 * Method to buy a Purchasable object from the shop
	 * @param itemNum
	 * @return
	 */
	public String buyPurchasable(int itemNum) {
		
		String itemBoughtName = shop.getPurchasableList().get(itemNum).getName();
		int price = shop.getPurchasableList().get(itemNum).getBuyPrice();
		if (price <= slayer.getGold()) {
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
			return endGame();
		} else {
			for (int i=0; i < slayer.getCurrMonsters().size(); i++) {
				slayer.getCurrMonsters().get(i).setCurrentHealth(slayer.getCurrMonsters().get(i).getCurrentHealth() + slayer.getCurrMonsters().get(i).getHealAmount()); 
			}
			monstersInShop = shop.getMonsterList(randomEnv.monstersInShop());
			battles = viewBattles();
			boolean check = randomEnv.monsterLevelUp();
			if(check == true) {
				return "Sleeping... zz\nWelcome to day " + (slayer.getDaysPassed()) + "/" + days + ". A random Monster has levelled up!";
			}
			check = randomEnv.monsterArrives();
			if(check == true) {
				return "Sleeping... zz\nWelcome to day " + (slayer.getDaysPassed()) + "/" + days + ". A random Monster has joined your party!";
			}
			check = randomEnv.monsterLeaves();
			if(check == true) {
				return "Sleeping... zz\nWelcome to day " + (slayer.getDaysPassed()) + "/" + days + ". One of your monsters has ran away!";
			}
			return "Sleeping... zz\nWelcome to day " + (slayer.getDaysPassed()) + "/" + days;
		}
	}
	
	/**
	 * Method for GUI and sleep() to show a message when the game ends
	 * @return A string for ending the game
	 */
	public String endGame() {
		return String.format("---GAME ENDED---\nName: %s\nDays lasted: %o/%o\nPoints earned: " + slayer.getPoints() + "\nGold earned: " + slayer.getGoldTotal(), slayer.getName(), (slayer.getDaysPassed() - 1), days);
	}
	
	/**
	 * Runs the main game.
	 * @param args
	 */
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.launchSetupScreen();
		
		
		
		
	}
	
	
	
}
