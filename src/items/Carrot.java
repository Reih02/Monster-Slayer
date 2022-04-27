package items;

/*
 * Carrot, calls Food superclass
 * */
public class Carrot extends Food {

	private static int buyPrice = 5;
	private static int sellValue = 3;
	private static String name = "Carrot";
	private static int bonus = 5;
	
	
	public Carrot(boolean difficulty) {
		super(buyPrice, sellValue, name, bonus, difficulty);
	}

}
