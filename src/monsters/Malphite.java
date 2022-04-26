package monsters;

import main.Monster;

/**
 * Malphite class that extends the super class Monster.
 * @author Orion Lynch & Reilly Haskins.
 */
public class Malphite extends Monster {
	
	/**
	 * Malphite constructor that calls the super constructor with default values.
	 * @param difficulty the Difficulty setting that changes some of the monsters values.
	 */
	public Malphite(String difficulty) {
		super(120, "Malphite", 15, 25, difficulty);
	}

}
