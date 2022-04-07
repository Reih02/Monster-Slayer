package main;

/**
 * Purchasable interface
 * This interface means that the classes that implement it must have the methods in purchasable.
 * The classes that implement purchasable are Monster and item.
 * @author Orion Lynch & Reilly Haskins.
 *
 */

public interface Purchasable {
	
	/**
	 * This method returns the purchase price where it is implemented.
	 * @return The price to purchase the purchasable.
	 */
	public int getBuyPrice();
	
	/**
	 * This method returns the sell price where it is implemented.
	 * @return The price to sell the purchasable.
	 */
	public int getSellPrice();
	
}
