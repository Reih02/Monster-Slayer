package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.border.CompoundBorder;

import main.Battle;
import main.GameEnvironment;
import main.Monster;

import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BattleScreen {

	private JFrame BattleScreenFrame;
	
	private GameEnvironment gameManager;
	
	
	
	
	
	/**
	 * Create the application.
	 */
	public BattleScreen(GameEnvironment manager) {
		gameManager = manager;
		initialize();
		BattleScreenFrame.setVisible(true);
	}
	
	
	public void closeWindow() {
		BattleScreenFrame.dispose();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleScreen window = new BattleScreen();
					window.BattleScreenFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	
	/**
	 * Create the application.
	 */
	public BattleScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		BattleScreenFrame = new JFrame();
		BattleScreenFrame.setTitle("Battle Screen");
		BattleScreenFrame.setBounds(100, 100, 631, 490);
		BattleScreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BattleScreenFrame.getContentPane().setLayout(null);
		
		
		
		JLabel battlesLabel = new JLabel("Potential battles");
		battlesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		battlesLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		battlesLabel.setBounds(85, 67, 425, 38);
		BattleScreenFrame.getContentPane().add(battlesLabel);
		
		
		
		JButton goBackButton = new JButton("Home");
		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BattleScreenFrame.dispose();
				gameManager.launchMainScreen();
			}
		});
		goBackButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		goBackButton.setBounds(10, 11, 185, 62);
		BattleScreenFrame.getContentPane().add(goBackButton);
		
		JList<ArrayList<String>> potentialBattlesList = new JList<ArrayList<String>>();
		potentialBattlesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		potentialBattlesList.setBorder(new CompoundBorder());
		potentialBattlesList.setModel(new AbstractListModel() {
			ArrayList<String> values = gameManager.viewStringBattles();
			public int getSize() {
				return values.size();
			}
			public Object getElementAt(int index) {
				return values.get(index);
			}
		});
		potentialBattlesList.setSelectedIndex(0);
		potentialBattlesList.setBounds(10, 111, 595, 230);
		BattleScreenFrame.getContentPane().add(potentialBattlesList);
		
		JButton startBattleButton = new JButton("START BATTLE");
		startBattleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String battleFeedback = gameManager.chooseBattle(potentialBattlesList.getSelectedIndex());
				JOptionPane.showMessageDialog(BattleScreenFrame, battleFeedback);
				gameManager.removeBattle(potentialBattlesList.getSelectedIndex());
				potentialBattlesList.setModel(new AbstractListModel() {
					ArrayList<String> values = gameManager.viewStringBattles();
					public int getSize() {
						return values.size();
					}
					public Object getElementAt(int index) {
						return values.get(index);
					}
				});
			}
		});
		startBattleButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		startBattleButton.setBounds(130, 352, 308, 88);
		BattleScreenFrame.getContentPane().add(startBattleButton);
	}
}
