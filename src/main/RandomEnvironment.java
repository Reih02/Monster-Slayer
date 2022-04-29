package main;

import java.util.ArrayList;
import java.util.Random;

import monsters.BloodMuncha;
import monsters.Garen;
import monsters.Katarina;
import monsters.Malphite;
import monsters.MasterYi;
import monsters.Volibear;


/**
 * Class that Randomly generates some events that have a chance to happen each day in the game.
 * @author User Orion Lynch and Reilly Haskins
 *
 */
public class RandomEnvironment {
	
	/**
	 * Attribute that stores a list of current monster's that the player has.
	 */
	private ArrayList<Monster> currentMonsters;
	
	/**
	 * Attribute that records the difficulty of the game.
	 */
	private boolean difficulty;
	
	/**
	 * Constructor that sets currentMonsters to a list of current Monsters.
	 * @param currentMonsterList An ArrayList of Monsters the player currently has.\
	 * @param difficulty The difficulty that the game is set to, used when creating Monster objects.
	 */
	public RandomEnvironment(ArrayList<Monster> currentMonsterList, boolean gameDifficulty){
		currentMonsters = currentMonsterList;
		difficulty = gameDifficulty;
		
	}
	
	/**
	 * Method that has a 50% chance of leveling up a random Monster in your current monster list.
	 * @return returns true if a monster in your party leveled up and false if a monster did not level up.
	 */
	public boolean monsterLevelUp() {
		Random randomLevelUp = new Random();
		
		int number = 1;
		
		if(difficulty) {
			number = randomLevelUp.nextInt(4);
		}
		else {
		    number = randomLevelUp.nextInt(2);
		}
		if (number == 1) {
			int size = currentMonsters.size();
			Random monsterIndex = new Random();
			int index = monsterIndex.nextInt(size);
			Monster monsterLevelUp = currentMonsters.get(index);
			monsterLevelUp.setMaxHealth(monsterLevelUp.getMaxHealth() + 10);
			monsterLevelUp.setDamage(monsterLevelUp.getDamage() + 2);
			return true;				
		}
		return false;
		
	}

	/**
	 * Method that has a 1/11 chance of a monster leaving your current monster list when it is called.
	 * @return True if a Monster leaves otherwise returns False.
	 */
	public boolean monsterLeaves() {
		Random randomLeave = new Random();
		int number = 1;
		if(difficulty) {
			number = randomLeave.nextInt(7); 
		}
		else {
		    number = randomLeave.nextInt(11);
		}
		if (number == 1) {
			int size = currentMonsters.size();
			Random monsterIndex = new Random();
			int index = monsterIndex.nextInt(size);
			currentMonsters.remove(index);
			return true;
 

		}
		else {
			return false;
		}
	}
	
	/**
	 * Method that has a 1/7 chance of adding a new monster to your party when called.
	 * @return True if the monster arrives otherwise returns False.
	 */
	public boolean monsterArrives() {
		ArrayList<Monster> potentialMonsters = new ArrayList<Monster>();
		potentialMonsters.add(new MasterYi(difficulty));
		potentialMonsters.add(new Garen(difficulty));
		potentialMonsters.add(new Katarina(difficulty));
		potentialMonsters.add(new BloodMuncha(difficulty));
		potentialMonsters.add(new Malphite(difficulty));
		potentialMonsters.add(new Volibear(difficulty));
		
		Random randomArrives = new Random();
	    int number = 1;
		int size = potentialMonsters.size();
		if (difficulty) {
		    number = randomArrives.nextInt(7);
		}
		else {
			number = randomArrives.nextInt(4);
		}
		
		if (number == 1) {
			Random monsterIndex = new Random();
			int index = monsterIndex.nextInt(size);
			currentMonsters.add(potentialMonsters.get(index));
			return true;
		}
		else {
			return false;
		}
		
	}
	/**
	 * Method that randomly generates the amount of monsters in the shop and then randomly generates which monsters are in the shop.
	 * @return An ArrayList of monsters in the shop.
	 */
	public ArrayList<Monster> monstersInShop(){
		
		ArrayList<Monster> shop = new ArrayList<Monster>();
		ArrayList<Monster> potentialMonsters = new ArrayList<Monster>();
		potentialMonsters.add(new MasterYi(difficulty));
		potentialMonsters.add(new Garen(difficulty));
		potentialMonsters.add(new Katarina(difficulty));
		potentialMonsters.add(new BloodMuncha(difficulty));
		potentialMonsters.add(new Malphite(difficulty));
		potentialMonsters.add(new Volibear(difficulty));
		
		Random amount = new Random();
		int number = amount.nextInt(3);
		 		
		for(number = number + 3; number != 0; number --) {
			int index = amount.nextInt(6);
			shop.add(potentialMonsters.get(index));						
		}
		return shop;
	}
	
	/**
	 * Method that randomly generates the amount of potential battles there are and randomly generates the amount of Monsters and what type of monsters.
	 * @param dayNumber The day that it is currently.
	 * @return An ArrayList of ArrayLists that are made up of monsters.
	 */
	public ArrayList<ArrayList<Monster>> generateBattles(int dayNumber){
		ArrayList<ArrayList<Monster>> battles = new ArrayList<ArrayList<Monster>>();
		
		ArrayList<Monster> potentialMonsters = new ArrayList<Monster>();
		potentialMonsters.add(new MasterYi(difficulty));
		potentialMonsters.add(new Garen(difficulty));
		potentialMonsters.add(new Katarina(difficulty));
		potentialMonsters.add(new BloodMuncha(difficulty));
		potentialMonsters.add(new Malphite(difficulty));
		potentialMonsters.add(new Volibear(difficulty));
		Random randomBattle = new Random();
		int number = randomBattle.nextInt(3);
		
		for(number = number + 3; number != 0; number --) {
			ArrayList<Monster> battle = new ArrayList<Monster>();
			if(difficulty) {
			    for(int battleSize = randomBattle.nextInt(dayNumber) + 2; battleSize != 0; battleSize --) {
			    	int index = randomBattle.nextInt(6);
			    	battle.add(potentialMonsters.get(index));
			    }
			    battles.add(battle);
		}
			else {
				for(int battleSize = randomBattle.nextInt(dayNumber) + 1; battleSize != 0; battleSize --) {
			    	int index = randomBattle.nextInt(6);
			    	battle.add(potentialMonsters.get(index));
			}
				battles.add(battle);
			}
	     }
		return battles;
	}
}
