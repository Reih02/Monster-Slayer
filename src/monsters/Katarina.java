package monsters;

import main.Monster;

/**
 * Katarina class that extends the super class Monster.
 * @author Orion Lynch & Reilly Haskins.
 */
public class Katarina extends Monster {
	
	/**
	 * Katarina constructor that calls the super constructor with default values.
	 * @param difficulty the Difficulty setting that changes some of the monsters values.
	 */
	public Katarina(String difficulty) {
		super(80, "Katarina", 30, 15, difficulty);
	}

}
