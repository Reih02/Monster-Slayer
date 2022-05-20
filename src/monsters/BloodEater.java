package monsters;

import main.Monster;

/**
 * BloodMuncha class that extends the super class Monster.
 * @author Orion Lynch & Reilly Haskins.
 */
public class BloodEater extends Monster {
	
	/**
	 * BloodMuncha constructor that calls the super constructor with default values.
	 * @param difficulty the Difficulty setting that changes some of the monsters values.
	 */
	public BloodEater(boolean difficulty) {
		super(50, "BloodEater", 45, 25, difficulty);
	}

}
