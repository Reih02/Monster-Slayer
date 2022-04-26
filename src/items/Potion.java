package items;

import main.Item;

/*
 * Potion class, superclass of individual potion types and child of Item class.
 * */
public class Potion extends Item {

	/*
	 * Potion constructor, passes values into superclass (Item)
	 * */
	public Potion(int buyPrice, int sellValue, String name, int bonus, String difficulty) {
		super(buyPrice, sellValue, name, bonus, difficulty);
	}
}
