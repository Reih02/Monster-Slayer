package main;

/**
 * Slayer class where the user's game information is stored and altered
 * @author Orion Lynch and Reilly Haskins
 */
public class Slayer {

	/**
	 * Initialises user's name
	 */
	private String name;
	
	/**
	 * Initialises user's days spent in game
	 */
	private int daysSpent;
	
	/**
	 * Constructor for new Slayer object
	 * @param slayerName
	 * @param slayerDaysSpent
	 */
	public Slayer(String slayerName, int slayerDaysSpent) {
		name = slayerName;
		daysSpent = slayerDaysSpent;
	}
	
	/**
	 * Increases daysSpent by one
	 */
	public void increaseDays() {
		daysSpent ++;
	}
	
	/**
	 * Returns the name of the Slayer object
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the current amount of user's days passed
	 * @return
	 */
	public int getDaysPassed() {
		return daysSpent;
	}
	
}
