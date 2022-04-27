package items;

import main.Item;

/*
 * Food class, superclass of individual food types and child of Item class.
 * */
public class Food extends Item {

	/*
	 * Food constructor, passes values into superclass (Item)
	 * */
	public Food(int buyPrice, int sellValue, String name, int bonus, boolean difficulty) {
		super(buyPrice, sellValue, name, bonus, difficulty);
	}

}
