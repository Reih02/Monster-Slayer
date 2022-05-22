package main;

/*
 * Manages information for a particular Item object,
 * of type Purchasable. For use on Monster objects.
 * @author Orion Lynch and Reilly Haskins.
 * */
public class Item implements Purchasable {

	/*
	 * Parent class of the two types of items; Potion and Food.
	 * Allows all types of items to call this superclass in order to 
	 * get the required attributes
	 * */
	
	private int purchasePrice;
	private int sellPrice;
	private String itemName;
	private int bonusValue;
	
	/*
	 * Constructor for Item class, takes 4 values to set attributes to
	 * */
	public Item(int buyPrice, int sellValue, String name, int bonus, boolean difficulty) {
		if(difficulty == true) {
			purchasePrice = buyPrice + 5;
			sellPrice = (int) Math.round(sellValue * 0.5);
		}
		else {
			purchasePrice = buyPrice;
			sellPrice = sellValue;
		}		
		itemName = name;
		bonusValue = bonus;
	}
	
	/*
	 * Following methods implement Purchasable interface
	 * */
	/*
	 * Getter methods
	 * */
	
	/**
	* The buy price of the item.
	* @return The buy price.
	**/
	public int getBuyPrice() {
		return purchasePrice;
	}
	
        /**
	 * gets the sell price of the item.
	 * @return the sellPrice of the item.
	 */
	public int getSellPrice() {
		return sellPrice;
	}
	
	/**
	 * gets the name of the item.
	 * @return the name of the item.
	 */
	public String getName() {
		return itemName;
	}
	
	/**
	 * gets the bonus value of the item.
	 * @return the bonus value of the item.
	 */
	public int getBonusValue() {
		return bonusValue;
	}
	/**
	 * A method which prints the item out in a nice manner.
	 * @return a string representation of an Item object.
	 */
	public String toString() {
		// return getName() + ", item costs " + getBuyPrice() + " gold, the item's bonus value is " + getBonusValue() + ".";
		return "Name: '" + getName() + "', Cost: " + getBuyPrice() + "G, Value: " + getSellPrice() + "G, Bonus: " + getBonusValue();
		
	}

}
