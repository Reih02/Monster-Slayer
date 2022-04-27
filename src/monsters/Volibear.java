package monsters;

import main.Monster;

/**
 * Volibear class that extends the super class Monster.
 * @author Orion Lynch & Reilly Haskins.
 */
public class Volibear extends Monster {
	
	/**
	 * Volibear constructor that calls the super constructor with default values.
	 * @param difficulty the Difficulty setting that changes some of the monsters values.
	 */
	public Volibear(boolean difficulty) {
		super(150, "Volibear", 10, 20, difficulty);
	}

}
