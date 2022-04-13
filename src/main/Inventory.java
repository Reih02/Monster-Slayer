package main;

import java.util.ArrayList;

/*
 * Inventory class that manages user's items,
 * allows user to add or remove items to inventory 
 * as well as get all items stored.
 * @author Orion Lynch and Reilly Haskins.
 * */
public class Inventory {

	private ArrayList<Item> inventoryList;
	
	/*
	 * Creates ArrayList inventoryList which stores
	 * objects of type Item
	 * */
	public Inventory() {
		inventoryList = new ArrayList<Item>();
	}
	
	/*
	 * Adds parameter object of type Item to 
	 * inventoryList
	 * */
	public void addItem(Item item) {
		inventoryList.add(item);
	}
	
	/*
	 * Removes parameter object of type Item from
	 * inventorylist
	 * */
	public void removeItem(Item item) {
		if (inventoryList.contains(item)) {
			inventoryList.remove(item);
		}
	}
	
	/*
	 * Returns all items currently in inventoryList
	 * */
	public ArrayList<Item> getInventoryList() {
		return inventoryList;
	}
}
