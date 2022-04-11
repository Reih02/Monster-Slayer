package main;

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
	public Item(int buyPrice, int sellValue, String name, int bonus) {
		purchasePrice = buyPrice;
		sellPrice = sellValue;
		itemName = name;
		bonusValue = bonus;
	}
	
	/*
	 * Following methods implement Purchasable interface
	 * */
	/*
	 * Getter methods
	 * */
	public int getBuyPrice() {
		return purchasePrice;
	}

	public int getSellPrice() {
		return sellPrice;
	}
	
	public String getName() {
		return itemName;
	}
	
	public int getBonusValue() {
		return bonusValue;
	}

}
