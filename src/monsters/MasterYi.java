package monsters;

import main.Monster;

/**
 * MasterYi class that extends the super class Monster.
 * @author Orion Lynch & Reilly Haskins.
 */
public class MasterYi extends Monster {
	
	/**
	 * MasterYi constructor that calls the super constructor with default values.
	 * @param difficulty the Difficulty setting that changes some of the monsters values.
	 */
	public MasterYi(boolean difficulty) {
		super(100, "MasterYi", 20, 20, difficulty);
	}

}
