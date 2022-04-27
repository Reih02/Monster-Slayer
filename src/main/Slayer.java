package main;

/**
 * Slayer class where the users game information is stored and altered
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
	 * The user's gold
	 */
	private int goldBalance;
	
	/**
	 * Constructor for new Slayer object
	 * @param slayerName
	 * @param slayerDaysSpent
	 */
	public Slayer(String slayerName, int slayerDaysSpent, int gold) {
		name = slayerName;
		daysSpent = slayerDaysSpent;
		goldBalance = gold;
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
	 * Method to return user's current gold
	 * @return
	 */
	public int getGold() {
		return goldBalance;
	}
	
	/**
	 * Returns the current amount of user's days passed
	 * @return
	 */
	public int getDaysPassed() {
		return daysSpent;
	}
	
}
