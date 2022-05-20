package monsters;

import main.Monster;

/**
 * Katarine class that extends the super class Monster.
 * @author Orion Lynch & Reilly Haskins.
 */
public class Katarine extends Monster {
	
	/**
	 * Katarine constructor that calls the super constructor with default values.
	 * @param difficulty the Difficulty setting that changes some of the monsters values.
	 */
	public Katarine(boolean difficulty) {
		super(80, "Katarine", 30, 15, difficulty);
	}

}
