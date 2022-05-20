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
import monsters.Jaren;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;

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
					//GameEnvironment gameEnvironment = new GameEnvironment();
					InventoryScreen window = new InventoryScreen();
					window.frmYourInventory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public InventoryScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmYourInventory = new JFrame();
		frmYourInventory.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmYourInventory.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmYourInventory.setTitle("Your Inventory");
		frmYourInventory.setBounds(100, 100, 631, 490);
		frmYourInventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmYourInventory.getContentPane().setLayout(null);
		
		JButton homeBtn = new JButton("Home");
		homeBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		homeBtn.setBounds(493, 11, 116, 45);
		frmYourInventory.getContentPane().add(homeBtn);
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shutdownWindow();
				inventoryManager.launchMainScreen();
			}
		});
		
		DefaultListModel<Item> listModel = new DefaultListModel<>();
		ArrayList<Item> items = inventoryManager.guiGetInventory();
		for (int i = 0; i < items.size(); i++) {
			listModel.addElement(items.get(i));
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(SystemColor.text);
		panel.setBounds(143, 56, 328, 264);
		frmYourInventory.getContentPane().add(panel);
		JList<Item> inventoryList = new JList<Item>(listModel);
		inventoryList.setFont(new Font("Dialog", Font.BOLD, 11));
		panel.add(inventoryList);
		inventoryList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		
		
		JButton sellItemBtn = new JButton("Sell Item");
		sellItemBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sellItemBtn.setBounds(345, 346, 126, 35);
		frmYourInventory.getContentPane().add(sellItemBtn);
		sellItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item selectedItem = inventoryList.getSelectedValue();
				if (items.indexOf(selectedItem) < 0) {
					JOptionPane.showMessageDialog(frmYourInventory, "Please select an item first!");
				} else {
					int selectedItemIndex = items.indexOf(selectedItem);
					inventoryManager.sellItem(selectedItemIndex + 1);
					JOptionPane.showMessageDialog(frmYourInventory, "Sold " + selectedItem.getName() + " for " + selectedItem.getSellPrice() + " gold!");
					shutdownWindow();
					inventoryManager.launchInventoryScreen();
				}
			}
		});
		
		JButton useItemBtn = new JButton("Use Item");
		useItemBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		useItemBtn.setBounds(143, 346, 135, 35);
		frmYourInventory.getContentPane().add(useItemBtn);
		useItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item selectedItem = inventoryList.getSelectedValue();
				if (items.indexOf(selectedItem) < 0) {
					JOptionPane.showMessageDialog(frmYourInventory, "Please select an item first!");
				} else {
					inventoryManager.setGuiItemIndex(items.indexOf(selectedItem)); // marks the selected item by setting variable in GameEnvironment for use in UseItemScreen
					shutdownWindow(); // go to UseItemScreen to select the monster to use item on
					inventoryManager.launchUseItemScreen();
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Your items:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(259, 19, 116, 29);
		frmYourInventory.getContentPane().add(lblNewLabel);
		
		JLabel lblYourCurrentGold = new JLabel("Gold Balance:");
		lblYourCurrentGold.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYourCurrentGold.setBounds(10, 168, 123, 29);
		frmYourInventory.getContentPane().add(lblYourCurrentGold);
		
		JLabel goldDisplay = new JLabel("" + inventoryManager.getSlayerGold() + "G");
		goldDisplay.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		goldDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		goldDisplay.setBounds(22, 191, 93, 29);
		frmYourInventory.getContentPane().add(goldDisplay);
		
	}
}
