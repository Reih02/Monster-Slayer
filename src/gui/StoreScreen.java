package gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;

import main.GameEnvironment;
import main.Monster;
import main.Purchasable;
import main.Shop;

import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* Class that displays the Store with Monsters and items.
* Authors Orion Lynch and Reilly Haskins
*/
public class StoreScreen {

	private JFrame storeScreenFrame;
	
	private Shop storeManager;
	
	private boolean gameDifficulty;
	
	private GameEnvironment gameManager;
	
	/**
	 * Create the application.
	 */
	public StoreScreen(boolean difficulty, GameEnvironment game) {
		this.gameManager = game;
		storeManager = new Shop(difficulty);
		gameDifficulty = difficulty;
		initialize();
	}
	
	public void closeWindow() 
	{
		storeScreenFrame.dispose();
	}
	
	/**
	 * A function that calls closeWindow to close the store screen. call this method if you want to close the screen.
	 */
	public void finishWindow() 
	{
		gameManager.closeStoreScreen(this);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// testing remember to delete parameters
					StoreScreen window = new StoreScreen(false, new GameEnvironment("Steve", 5, "Garen", false));
					window.storeScreenFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	/**
	 * Create the application.
	 */
	public StoreScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		storeScreenFrame = new JFrame();
		storeScreenFrame.setTitle("Monster Slayer - Store");
		storeScreenFrame.setBounds(100, 100, 562, 453);
		storeScreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		storeScreenFrame.getContentPane().setLayout(null);
		
		JList monsterList = new JList();
		monsterList.setModel(new AbstractListModel() {
			ArrayList<Monster> values = gameManager.getMonsterInShop();
			public int getSize() {
				return values.size();
			}
			public Object getElementAt(int index) {
				return values.get(index);
			}
		});
		monsterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		monsterList.setSelectedIndex(0);
		monsterList.setBounds(50, 165, 486, 100);
		storeScreenFrame.getContentPane().add(monsterList);
		
		JList itemList = new JList();
		itemList.setSelectedIndices(new int[] {0});
		
		itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		itemList.setModel(new AbstractListModel() {
			ArrayList<Purchasable> values = storeManager.getPurchasableList();
			public int getSize() {
				return values.size();
			}
			public Object getElementAt(int index) {
				return values.get(index);
			}
		});
		itemList.setSelectedIndex(0);
		itemList.setBounds(154, 303, 382, 100);
		storeScreenFrame.getContentPane().add(itemList);
		
		JLabel itemSaleLabel = new JLabel("ITEMS FOR SALE");
		itemSaleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		itemSaleLabel.setBounds(261, 241, 182, 68);
		storeScreenFrame.getContentPane().add(itemSaleLabel);
		
		
		
		JLabel itemPurchaseStatus = new JLabel("Item being purchased...");
		itemPurchaseStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		itemPurchaseStatus.setBounds(0, 253, 342, 47);
		storeScreenFrame.getContentPane().add(itemPurchaseStatus);
		
		JButton itemBuyButton = new JButton("BUY ITEM");
		itemBuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String purchaseMessage = gameManager.buyPurchasable(itemList.getSelectedIndex());
				itemPurchaseStatus.setText(purchaseMessage);
			}
		});
		itemBuyButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		itemBuyButton.setBounds(0, 311, 114, 92);
		storeScreenFrame.getContentPane().add(itemBuyButton);
		
		JLabel monsterSaleLabel = new JLabel("MONSTERS FOR SALE");
		monsterSaleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		monsterSaleLabel.setBounds(178, 121, 382, 33);
		storeScreenFrame.getContentPane().add(monsterSaleLabel);
		
		JLabel monsterStatusLabel = new JLabel("Monster being purchased...");
		monsterStatusLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		monsterStatusLabel.setBounds(19, 11, 342, 33);
		storeScreenFrame.getContentPane().add(monsterStatusLabel);
		
		JButton MonsterBuyButton = new JButton("BUY MONSTER");
		MonsterBuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String purchaseMessage = gameManager.buyMonster(monsterList.getSelectedIndex());
				monsterStatusLabel.setText(purchaseMessage);
			}
		});
		MonsterBuyButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		MonsterBuyButton.setBounds(0, 55, 168, 68);
		storeScreenFrame.getContentPane().add(MonsterBuyButton);
		
		JButton mainScreenButton = new JButton("Back To Main Screen");
		mainScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeScreenFrame.dispose();
				//gameManager.launchMainScreen();
			}
		});
		mainScreenButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		mainScreenButton.setBounds(341, 17, 195, 61);
		storeScreenFrame.getContentPane().add(mainScreenButton);
		
		JLabel goldDisplayLabel = new JLabel("Starting Gold: ");
		goldDisplayLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		goldDisplayLabel.setText(gameManager.getStats());
		goldDisplayLabel.setBounds(171, 80, 365, 43);
		storeScreenFrame.getContentPane().add(goldDisplayLabel);
		
		
		
		
	}
}
