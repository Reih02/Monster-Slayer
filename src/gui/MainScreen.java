package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class MainScreen {

	private JFrame frame;

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
		
		JButton storeBtn = new JButton("Store");
		storeBtn.setBounds(10, 54, 104, 35);
		frame.getContentPane().add(storeBtn);
		
		JButton inventoryBtn = new JButton("Inventory");
		inventoryBtn.setBounds(10, 117, 104, 35);
		frame.getContentPane().add(inventoryBtn);
		
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
