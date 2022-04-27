package items;

/*
 * Apple, calls Food superclass
 * */
public class Apple extends Food {
	
	private static int buyPrice = 7;
	private static int sellValue = 5;
	private static String name = "Apple";
	private static int bonus = 7;
	
	
	public Apple(boolean difficulty) {
		super(buyPrice, sellValue, name, bonus, difficulty);
	}

}
