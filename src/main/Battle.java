package main;

import java.util.ArrayList;

/**
 * Battle class that gets created when a battle is starting.
 * In this class the user can start the battle and get the winner of the battle.
 * @author Orion Lynch and Reilly Haskins.
 */
public class Battle {
	
	/**
	 * List of enemy Monster objects
	 */
	private ArrayList<Monster> enemyMonsters = new ArrayList<Monster>();
	
	/**
	 * List of allied Monster objects
	 */
	private ArrayList<Monster> alliedMonsters = new ArrayList<Monster>();
	
	/**
	 * Battle constructor that sets the two lists to the input lists.
	 * @param enemyMonsterList The list of enemy Monsters.
	 * @param alliedMonsterList The list of allied Monsters.
	 */
	public Battle(ArrayList<Monster> enemyMonsterList, ArrayList<Monster> alliedMonsterList) {
		enemyMonsters = enemyMonsterList;
		alliedMonsters = alliedMonsterList;
	}
	
	/**
	 * The fight method goes through the entire battle where the first conscious monster on each team takes turns attacking each other till one team is completely unconscious.
	 * @return True if allied Monsters win the fight or False if the enemy Monsters win
	 */
	public boolean fight() {
		int alliedIndex = 0;
		
		int enemyIndex = 0;
		
		while (alliedIndex < alliedMonsters.size() && enemyIndex < enemyMonsters.size()) {
			
			while(alliedMonsters.get(alliedIndex).isFainted() != true) {
				alliedIndex ++;
				
				if(alliedIndex == alliedMonsters.size()) {
					return false;
				}
			}
			
			while(enemyMonsters.get(enemyIndex).isFainted() != true) {
				
				enemyIndex ++;
				
				if(enemyIndex == enemyMonsters.size()) {
					return true;
					
				}
			}
			attack(alliedMonsters.get(alliedIndex), enemyMonsters.get(enemyIndex));
			
			attack(enemyMonsters.get(enemyIndex), alliedMonsters.get(alliedIndex));
		
		}
	return true;				
	}
	
	/**
	 * This method uses that damage from the attacking Monster and changes the health of the defending Monster accordingly.
	 * @param attacker A Monster that is attacking.
	 * @param defender A Monster that is being attacked.
	 */
    public void attack(Monster attacker, Monster defender) {
		defender.setCurrentHealth(defender.getCurrentHealth() - attacker.getDamage());
	}
    
 }
