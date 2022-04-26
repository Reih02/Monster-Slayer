package items;

/*
 * Strength Potion, calls Potion superclass
 * */
public class StrengthPotion extends Potion {
	
	private static int buyPrice = 25;
	private static int sellValue = 20;
	private static String name = "Strength Potion";
	private static int bonus = 5;
	
	
	public StrengthPotion(String difficulty) {
		super(buyPrice, sellValue, name, bonus, difficulty);
	}
}
