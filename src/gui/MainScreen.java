package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import main.GameEnvironment;

public class MainScreen {

	private JFrame frame;

	/**
	 * The manager of type GameEnvironment
	 */
	private GameEnvironment manager;
	
	public MainScreen(GameEnvironment incomingManager) {
		manager = incomingManager;
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton storeBtn = new JButton("Visit Shop");
		storeBtn.setBounds(10, 54, 104, 35);
		frame.getContentPane().add(storeBtn);
		storeBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				shutdownWindow();
				manager.launchStoreScreen();
				
			}
			
		});
		
		JButton inventoryBtn = new JButton("Inventory");
		inventoryBtn.setBounds(10, 117, 104, 35);
		frame.getContentPane().add(inventoryBtn);
		inventoryBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				shutdownWindow();
				manager.launchInventoryScreen();
				
			}
			
		});
		
		JButton battleBtn = new JButton("Battle");
		battleBtn.setBounds(10, 178, 104, 35);
		frame.getContentPane().add(battleBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(154, 25, 252, 162);
		frame.getContentPane().add(scrollPane);
		
		JButton sleepBtn = new JButton("Sleep");
		sleepBtn.setBounds(233, 215, 104, 35);
		frame.getContentPane().add(sleepBtn);
	}
}
