package items;

/*
 * Health Potion, calls Potion superclass
 * */
public class HealthPotion extends Potion {
	
	private static int buyPrice = 25;
	private static int sellValue = 20;
	private static String name = "Health Potion";
	private static int bonus = 25;
	
	
	public HealthPotion(boolean difficulty) {
		super(buyPrice, sellValue, name, bonus, difficulty);
	}
}
