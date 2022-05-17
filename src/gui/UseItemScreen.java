package gui;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import main.GameEnvironment;
import main.Item;
import main.Monster;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

public class UseItemScreen {

	private JFrame frmSelectAMonster;

	private GameEnvironment manager;
	
	public UseItemScreen(GameEnvironment incomingManager) {
		this.manager = incomingManager;
		initialize();
		frmSelectAMonster.setVisible(true);
	}
	
	public void closeWindow() {
		frmSelectAMonster.dispose();
	}
	
	public void shutdownWindow() {
		manager.closeUseItemScreen(this);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UseItemScreen window = new UseItemScreen();
					window.frmSelectAMonster.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UseItemScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSelectAMonster = new JFrame();
		frmSelectAMonster.setTitle("Select a monster");
		frmSelectAMonster.setBounds(100, 100, 631, 490);
		frmSelectAMonster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSelectAMonster.getContentPane().setLayout(null);
		
		JLabel lblSelectAMonster = new JLabel("Select a monster to use your selected item on:");
		lblSelectAMonster.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelectAMonster.setBounds(149, 19, 357, 33);
		frmSelectAMonster.getContentPane().add(lblSelectAMonster);
		
		DefaultListModel<Monster> listModel = new DefaultListModel<>();
		ArrayList<Monster> monsters = manager.getMonsters();
		for (int i = 0; i < monsters.size(); i++) {
			listModel.addElement(monsters.get(i));
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(92, 108, 447, 208);
		frmSelectAMonster.getContentPane().add(panel);
		JList<Monster> monsterList = new JList<Monster>(listModel);
		monsterList.setFont(new Font("Dialog", Font.PLAIN, 11));
		panel.add(monsterList);
		
		JButton useItemButton = new JButton("Use item on selected monster");
		useItemButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		useItemButton.setBounds(170, 346, 288, 42);
		frmSelectAMonster.getContentPane().add(useItemButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(10, 13, 102, 49);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shutdownWindow();
				manager.launchInventoryScreen();
			}
		});
		
		frmSelectAMonster.getContentPane().add(btnBack);
		useItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monster selectedMonster = monsterList.getSelectedValue();
				JOptionPane.showMessageDialog(frmSelectAMonster, "Used " + manager.getInventoryRaw().get(manager.getGuiItemIndex()).getName() + " on " + selectedMonster.getName());
				manager.useItem(manager.getGuiItemIndex(), monsters.indexOf(selectedMonster)); // calls useItem with selected item from inventory and selected monster as index integers
				shutdownWindow(); // goes back to inventory screen
				manager.launchInventoryScreen();
			}
		});
	}
}
