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
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

public class UseItemScreen {

	private JFrame frmSelectAMonster;

	private GameEnvironment manager;
	
	public UseItemScreen(GameEnvironment incomingManager) {
		manager = incomingManager;
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
		frmSelectAMonster.setBounds(100, 100, 450, 300);
		frmSelectAMonster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSelectAMonster.getContentPane().setLayout(null);
		
		JLabel lblSelectAMonster = new JLabel("Select a monster to use your selected item on:");
		lblSelectAMonster.setBounds(44, 12, 347, 15);
		frmSelectAMonster.getContentPane().add(lblSelectAMonster);
		
		DefaultListModel<Monster> listModel = new DefaultListModel<>();
		ArrayList<Monster> monsters = manager.getMonsters();
		System.out.println(monsters.size());
		for (int i = 0; i < monsters.size(); i++) {
			listModel.addElement(monsters.get(i));
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(44, 45, 347, 171);
		frmSelectAMonster.getContentPane().add(panel);
		JList<Monster> monsterList = new JList<Monster>(listModel);
		monsterList.setFont(new Font("Dialog", Font.PLAIN, 8));
		panel.add(monsterList);
		
		JButton useItemButton = new JButton("Use item on selected monster");
		useItemButton.setBounds(82, 228, 276, 25);
		frmSelectAMonster.getContentPane().add(useItemButton);
		useItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monster selectedMonster = monsterList.getSelectedValue();
				manager.useItem(manager.getGuiItemIndex(), monsters.indexOf(selectedMonster));
			}
		});
	}
}
