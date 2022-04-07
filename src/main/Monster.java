package main;
/**
 * Monster class where individual monsters are extended from.
 * Here the user can create a monster and check the monsters hit points, if it is fainted etc.
 * @author Orion Lynch & Reilly Haskins.
 */

public class Monster implements Purchasable {
	
	/**
	 * Max health of the monster.
	 */
	private int monsterMaxHealth;
	
	/**
	 * Name of the monster.
	 */
	private String monsterName;
	
	/**
	 * Amount of damage that an attack from the monster does
	 */
	private int monsterDamage;
	
	/**
	 * Amount that the monster heals each day
	 */
	private int monsterHealAmount;
	
	/**
	 * Amount of health that the monster currently has
	 */
	private int monsterCurrentHealth;
	
	/**
	 * Constructor for Monster class that sets the initial values for each monster created.
	 * @param health The monsters max health.
	 * @param name The monsters name.
	 * @param damage The monsters attack damage.
	 * @param healAmount The amount of health the monster restores each day.
	 */
	public Monster(int health, String name, int damage, int healAmount) {
		monsterMaxHealth = health;
	    monsterName = name;
	    monsterDamage = damage;
	    monsterHealAmount = healAmount;
	    monsterCurrentHealth = health;
	}
	
	/**
	 *  returns the current health of the Monster.
	 * @return The Monster's current health.
	 */
	public int getCurrentHealth() {
		return monsterCurrentHealth;
	}


	/**
	 * returns the amount that you can buy a Monster for.
	 */
	public int getBuyPrice() {
		return 100;
	}

    /**
     * returns the amount that you can sell a Monster for.
     */
	public int getSellPrice() {
		return 150;
	}
	
	/**
	 * Method that returns the Monster's name
	 * @return The Monster's name.
	 */
	public String getName() {
		return monsterName;
	}
	
	/**
	 * Method that returns the Monster's damage.
	 * @return The Monster's damage.
	 */
	public int getDamage() {
		return monsterDamage;
	}
	
	/**
	 * Method that returns the Monster's heal amount.
	 * @return The Monster's heal amount.
	 */
	public int getHealAmount() {
		return monsterHealAmount;
	}
	
	/**
	 * Method that returns the Monster's max health.
	 * @return The Monster's max health.
	 */
	public int getMaxHealth() {
		return monsterMaxHealth;
	}
	
	/**
	 * Method that returns the Monster's current health.
	 * @param newHealth The value that currentHealth is going to become.
	 * @return The Monster's new health value.
	 */
	public int setCurrentHealth(int newHealth) {
		return newHealth;
	}
	
	/**
	 * Method that checks if the Monster has fainted or is still conscious.
	 * @return true if getCurrentHealth is 0 otherwise returns false.
	 */
	public boolean isFainted() {
		if(getCurrentHealth() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
