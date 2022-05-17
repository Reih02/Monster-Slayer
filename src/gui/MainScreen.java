package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import main.GameEnvironment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MainScreen {

	private JFrame frame;

	/**
	 * The manager of type GameEnvironment
	 */
	private GameEnvironment manager;
	
	public MainScreen(GameEnvironment incomingManager) {
		this.manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void shutdownWindow() {
		manager.closeMainScreen(this);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Home");
		frame.setBounds(100, 100, 631, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnViewTeam = new JButton("View Team");
		btnViewTeam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnViewTeam.setBounds(334, 185, 232, 48);
		frame.getContentPane().add(btnViewTeam);
		btnViewTeam.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				shutdownWindow();
				manager.launchViewTeamScreen();
			}
			
		});
		
		JButton storeBtn = new JButton("Visit Shop");
		storeBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		storeBtn.setBounds(62, 78, 201, 48);
		frame.getContentPane().add(storeBtn);
		storeBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				shutdownWindow();
				manager.launchStoreScreen();
				
			}
			
		});
		
		JButton inventoryBtn = new JButton("View Inventory");
		inventoryBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		inventoryBtn.setBounds(334, 78, 217, 48);
		frame.getContentPane().add(inventoryBtn);
		inventoryBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				shutdownWindow();
				manager.launchInventoryScreen();
				
			}
			
		});
		
		JButton battleBtn = new JButton("Battle");
		battleBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		battleBtn.setBounds(62, 185, 201, 48);
		frame.getContentPane().add(battleBtn);
		battleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shutdownWindow();
				manager.launchBattleScreen();
			}
		});
		
		JButton sleepBtn = new JButton("Sleep");
		sleepBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sleepBtn.setBounds(203, 283, 201, 108);
		frame.getContentPane().add(sleepBtn);
		
		JLabel currDayLabel = new JLabel("Day " + manager.getSlayerDay() + "/" + manager.getMaxDays());
		currDayLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		currDayLabel.setBounds(125, 11, 126, 48);
		frame.getContentPane().add(currDayLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBounds(43, 173, 241, 70);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_1.setBounds(43, 70, 241, 70);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_2.setBounds(316, 70, 250, 70);
		frame.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_3.setBounds(316, 173, 264, 70);
		frame.getContentPane().add(panel_3);
		
		JLabel lblGold = new JLabel("Gold: " + manager.getSlayerGold());
		lblGold.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblGold.setBounds(382, 11, 126, 48);
		frame.getContentPane().add(lblGold);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_4.setBounds(190, 273, 226, 125);
		frame.getContentPane().add(panel_4);
		
		
		sleepBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((manager.getSlayerDay() - manager.getMaxDays()) < 0) {
					JOptionPane.showMessageDialog(frame, manager.sleep());
					shutdownWindow();
					manager.launchMainScreen();
				} else {
					// print finish game message to console
				}
			}
		});
	}
}
