package monsters;

import main.Monster;

/**
 * Jaren class that extends the super class Monster.
 * @author Orion Lynch & Reilly Haskins.
 */
public class Jaren extends Monster {
	
	/**
	 * Jaren constructor that calls the super constructor with default values.
	 * @param difficulty the Difficulty setting that changes some of the monsters values.
	 */
	public Jaren(boolean difficulty) {
		super(90, "Jaren", 25, 15, difficulty);
	}

}
