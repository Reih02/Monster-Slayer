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
	 * The user's points
	 */
	private int pointsScored;
	
	/**
	 * Constructor for new Slayer object
	 * @param slayerName
	 * @param slayerDaysSpent
	 */
	public Slayer(String slayerName, int slayerDaysSpent, int gold, int points) {
		name = slayerName;
		daysSpent = slayerDaysSpent;
		goldBalance = gold;
		pointsScored = points;
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
	 * Method to return user's total points earned
	 * @return
	 */
	public int getPoints() {
		return pointsScored;
	}
	
	/**
	 * Returns the current amount of user's days passed
	 * @return
	 */
	public int getDaysPassed() {
		return daysSpent;
	}
	
}
