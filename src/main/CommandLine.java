package main;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandLine {

	/**
	 * Instance of GameEnvironment
	 */
	private GameEnvironment game;
	
	/**
	 * The chosen difficulty
	 */
	private boolean difficulty;
	
	public void userInputPrompt() {
		Scanner nameInput = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		String name = nameInput.nextLine();
		Scanner daysInput = new Scanner(System.in);
		System.out.println("Please enter the number of in-game days that you would like to play for: ");
		int days = daysInput.nextInt();
		Scanner monsterInput = new Scanner(System.in);
		System.out.println("Possible monsters: 'BloodMuncha', 'Garen', 'Katarina', 'Malphite', 'MasterYi', 'Volibear'");
		System.out.println("Please enter the name of the monster you would like to start with: ");
		String monsterChoice = monsterInput.nextLine();
		Scanner difficultyInput = new Scanner(System.in);
		System.out.println("Please enter '0' if you would like to play on normal difficulty, or '1' if you would like to play on hard difficulty: ");
		int difficultyChoice = difficultyInput.nextInt();
		if (difficultyChoice == 0) {
			boolean difficulty = false;
		} else if (difficultyChoice == 1) {
			boolean difficulty = true;
		}
		game = new GameEnvironment(name, days, monsterChoice, difficulty);
		ArrayList<String> possibleActions = new ArrayList<String>();
		possibleActions.add("Get current stats");
		possibleActions.add("Get your team properties");
		possibleActions.add("View your inventory");
		possibleActions.add("Use an item");
		possibleActions.add("View available battles");
		possibleActions.add("Choose a battle");
		possibleActions.add("Visit the shop");
		possibleActions.add("Buy an item from the shop");
		possibleActions.add("Sell an item to the shop");
		possibleActions.add("Sleep");
		while (game.shouldGameFinish() == false) {
			Scanner methodCaller = new Scanner(System.in);
			System.out.println("-------------\n");
			System.out.println("Possible actions: \n");
			for (int i=0; i < possibleActions.size(); i++) {
				System.out.println((i+1) + ": " + possibleActions.get(i) + "\n");
			}
			System.out.println("Enter the corresponding number to choose an action");
			int chosenAction = methodCaller.nextInt();
			switch(chosenAction) {
				case 1:
					System.out.println(game.getStats());
					break;
				case 2:
					System.out.println(game.getTeamProperties());
					break;
				case 3:
					System.out.println(game.getPlayerInventory());
					break;
				case 4:
					Scanner itemChoice = new Scanner(System.in);
					System.out.println("Enter the corresponding number of the item you would like to use from your inventory: ");
					int itemChosen = itemChoice.nextInt();
					Scanner monster = new Scanner(System.in);
					System.out.println("Enter the corresponding number of the monster you would like to use from your team: ");
					int monsterChosen = monster.nextInt();
					System.out.println(game.useItem(itemChosen, monsterChosen));
					break;
				case 5:
					System.out.println(game.viewBattles());
					break;
				case 6:
					Scanner chosenBattle = new Scanner(System.in);
					System.out.println("Enter the corresponding number of the battle you would like to choose: ");
					int battleNum = chosenBattle.nextInt();
					System.out.println(game.chooseBattle(battleNum - 1));
					break;
				case 7:
					System.out.println(game.visitShop());
					break;
				case 8:
					Scanner purchasableNum = new Scanner(System.in);
					System.out.println("Enter the corresponding number of the thing you would like to buy from the shop: ");
					int chosenItemNum = purchasableNum.nextInt();
					System.out.println(game.buyPurchasable(chosenItemNum));
					break;
				case 9:
					Scanner soldNum = new Scanner(System.in);;
					System.out.println("Enter the corresponding number of the item you would like to sell from your invenory: ");
					int selectedItem = soldNum.nextInt();
					game.sellItem(selectedItem);
					break;
				case 10:
					System.out.println(game.sleep());
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		CommandLine cli = new CommandLine();
		cli.userInputPrompt();
	}
	
}
