package monsters;

import main.Monster;

/**
 * Maltite class that extends the super class Monster.
 * @author Orion Lynch & Reilly Haskins.
 */
public class Maltite extends Monster {
	
	/**
	 * Maltite constructor that calls the super constructor with default values.
	 * @param difficulty the Difficulty setting that changes some of the monsters values.
	 */
	public Maltite(boolean difficulty) {
		super(120, "Maltite", 15, 25, difficulty);
	}

}
