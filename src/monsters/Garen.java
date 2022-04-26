package monsters;

import main.Monster;

/**
 * Garen class that extends the super class Monster.
 * @author Orion Lynch & Reilly Haskins.
 */
public class Garen extends Monster {
	
	/**
	 * Garen constructor that calls the super constructor with default values.
	 * @param difficulty the Difficulty setting that changes some of the monsters values.
	 */
	public Garen(String difficulty) {
		super(90, "Garen", 25, 15, difficulty);
	}

}
