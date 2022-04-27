package items;

/*
 * Steak, calls Food superclass
 * */
public class Steak extends Food {
	
	private static int buyPrice = 10;
	private static int sellValue = 7;
	private static String name = "Steak";
	private static int bonus = 15;
	
	
	public Steak(boolean difficulty) {
		super(buyPrice, sellValue, name, bonus, difficulty);
	}

}
