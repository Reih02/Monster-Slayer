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
	 * Constructor that sets currentMonsters to a list of current Monsters.
	 * @param currentMonsterList An ArrayList of Monsters the player currently has.
	 */
	RandomEnvironment(ArrayList<Monster> currentMonsterList){
		currentMonsters = currentMonsterList;
		
	}
	
	/**
	 * Method that has a 50% chance of leveling up a random Monster in your current monster list.
	 * @return returns true if a monster in your party leveled up and false if a monster did not level up.
	 */
	public boolean monsterLevelUp() {
		Random randomLevelUp = new Random();
		int number = randomLevelUp.nextInt(2);
		
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
		int number = randomLeave.nextInt(11);
		
		if (number == 10) {
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
		potentialMonsters.add(new MasterYi());
		potentialMonsters.add(new Garen());
		potentialMonsters.add(new Katarina());
		potentialMonsters.add(new BloodMuncha());
		potentialMonsters.add(new Malphite());
		potentialMonsters.add(new Volibear());
		
		Random randomArrives = new Random();
		
		int size = potentialMonsters.size();
		
		int number = randomArrives.nextInt(7);
		
		if (number == 6) {
			Random monsterIndex = new Random();
			int index = monsterIndex.nextInt(size);
			currentMonsters.add(potentialMonsters.get(index));
			return true;
		}
		else {
			return false;
		}
		
	}
}
