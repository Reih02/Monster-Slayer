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
	 * @param dificulty The difficulty setting of the monster.
	 */
	public Monster(int health, String name, int damage, int healAmount, boolean difficulty) {
		if(difficulty == true) {
			monsterMaxHealth = health - 15;
			monsterDamage = damage - 5;
			monsterHealAmount = healAmount - 5;
		}
		else {
			monsterMaxHealth = health;
			monsterDamage = damage;
			monsterHealAmount = healAmount;
		}		
	    monsterName = name;	       
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
	 * Method that updates the Monster's current health.
	 * @param newHealth The value that currentHealth is going to become.
	 * @return Null.
	 */
	public void setCurrentHealth(int newHealth) {
		if (newHealth < 0) {
			newHealth = 0;
		} else if ((monsterCurrentHealth + newHealth) > monsterMaxHealth) {
			monsterCurrentHealth = monsterMaxHealth;
		} else {
			monsterCurrentHealth = newHealth;
		}
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
	
	/**
	 * Method that updates the Monster's max health
	 * @param newMaxHealth The value that the max health is going to become.
	 */
	public void setMaxHealth(int newMaxHealth) {
		monsterMaxHealth = newMaxHealth;
	}
	
	/**
	 * Method that updates the Monster's damage
	 * @param newDamage The value that the damage is going to become
	 */
	public void setDamage(int newDamage) {
		monsterDamage = newDamage;
	}
	
	/**
	 * Method that returns a string format of a Monster.
	 */
	public String toString() {
		// return getName() + " costs " + getBuyPrice() + " gold, deals " + getDamage() + " damage, has " + getMaxHealth() + "health and heals " + getHealAmount() + " each day.";
		return "Name: " + getName() + ", Cost: " + getBuyPrice() + "G, DMG: " + getDamage() + ", HP: " + getCurrentHealth() + "/" + getMaxHealth() + ", Daily heal: " + getHealAmount();
	}
	
}
