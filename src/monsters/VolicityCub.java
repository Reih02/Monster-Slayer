package monsters;

import main.Monster;

/**
 * VolicityCub class that extends the super class Monster.
 * @author Orion Lynch & Reilly Haskins.
 */
public class VolicityCub extends Monster {
	
	/**
	 * VolicityCub constructor that calls the super constructor with default values.
	 * @param difficulty the Difficulty setting that changes some of the monsters values.
	 */
	public VolicityCub(boolean difficulty) {
		super(150, "VolicityCub", 10, 20, difficulty);
	}

}
