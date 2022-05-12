package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import main.GameEnvironment;
import main.Item;
import main.Monster;
import monsters.Garen;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class InventoryScreen {

	private JFrame frmYourInventory;
	
	private GameEnvironment inventoryManager;

	public InventoryScreen(GameEnvironment incomingManager) {
		this.inventoryManager = incomingManager;
		initialize();
		frmYourInventory.setVisible(true);
	}
	
	public void closeWindow() {
		frmYourInventory.dispose();
	}
	
	public void shutdownWindow() {
		inventoryManager.closeInventoryScreen(this);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameEnvironment gameEnvironment = new GameEnvironment("name", 5, "Garen", false);
					InventoryScreen window = new InventoryScreen(gameEnvironment);
					window.frmYourInventory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmYourInventory = new JFrame();
		frmYourInventory.setTitle("Your Inventory");
		frmYourInventory.setBounds(100, 100, 450, 300);
		frmYourInventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmYourInventory.getContentPane().setLayout(null);
		
		JButton homeBtn = new JButton("Home");
		homeBtn.setBounds(157, 11, 126, 35);
		frmYourInventory.getContentPane().add(homeBtn);
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shutdownWindow();
				inventoryManager.launchMainScreen();
			}
		});
		
		
		
		JButton sellItemBtn = new JButton("Sell Item");
		sellItemBtn.setBounds(252, 227, 104, 23);
		frmYourInventory.getContentPane().add(sellItemBtn);
		
		DefaultListModel<Item> listModel = new DefaultListModel<>();
		ArrayList<Item> items = inventoryManager.guiGetInventory();
		System.out.println(items);
		for (int i = 0; i < items.size(); i++) {
			listModel.addElement(items.get(i));
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(108, 46, 328, 169);
		frmYourInventory.getContentPane().add(panel);
		JList<Item> inventoryList = new JList<Item>(listModel);
		inventoryList.setFont(new Font("Dialog", Font.PLAIN, 10));
		panel.add(inventoryList);
		inventoryList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		JButton useItemBtn = new JButton("Use Item");
		useItemBtn.setBounds(108, 227, 113, 23);
		frmYourInventory.getContentPane().add(useItemBtn);
		useItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item selectedItem = inventoryList.getSelectedValue();
				inventoryManager.setGuiItemIndex(items.indexOf(selectedItem));
				shutdownWindow();
				inventoryManager.launchUseItemScreen();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Your items:");
		lblNewLabel.setBounds(12, 46, 93, 29);
		frmYourInventory.getContentPane().add(lblNewLabel);
		
	}
}
