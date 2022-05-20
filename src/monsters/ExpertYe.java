package monsters;

import main.Monster;

/**
 * ExpertYe class that extends the super class Monster.
 * @author Orion Lynch & Reilly Haskins.
 */
public class ExpertYe extends Monster {
	
	/**
	 * ExpertYe constructor that calls the super constructor with default values.
	 * @param difficulty the Difficulty setting that changes some of the monsters values.
	 */
	public ExpertYe(boolean difficulty) {
		super(100, "ExpertYe", 20, 20, difficulty);
	}

}
