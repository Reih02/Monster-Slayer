package main;

import java.util.ArrayList;

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
	 * Keeps track of user's monsters in an ArrayList
	 */
	private ArrayList<Monster> currentMonsters = new ArrayList<>();
	
	/**
	 * Initialises user's days spent in game
	 */
	private int daysSpent;
	
	/**
	 * The user's gold
	 */
	private int goldBalance;
	
	/**
	 * Keeps track of all gold the user has gained; not just the current balance
	 */
	private int goldTotalGained;
	
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
	 * Increases both user's gold balance and total gold gained by some value
	 * @param value
	 */
	public void increaseGold(int value) {
		goldBalance += value;
		goldTotalGained += value;
	}
	
	/**
	 * Decrease user's gold balance by some value
	 * @param value
	 */
	public void decreaseGold(int value) {
		goldBalance -= value;
	}
	
	/**
	 * Increases user's points by some value
	 * @param value
	 */
	public void increasePoints(int value) {
		pointsScored += value;
	}
	
	/**
	 * Returns the name of the Slayer object
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns user's monsters
	 * @return
	 */
	public ArrayList<Monster> getCurrMonsters(){
		return currentMonsters;
	}
	
	public void addMonster(Monster monster) {
		currentMonsters.add(monster);
	}
	
	/**
	 * Method to return user's current gold
	 * @return
	 */
	public int getGold() {
		return goldBalance;
	}
	
	/**
	 * Returns user's total gold gained value
	 * @return
	 */
	public int getGoldTotal() {
		return goldTotalGained;
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
