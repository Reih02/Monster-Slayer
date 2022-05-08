package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;

public class inventory {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inventory window = new inventory();
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
	public inventory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton homeBtn = new JButton("Home");
		homeBtn.setBounds(157, 11, 126, 35);
		frame.getContentPane().add(homeBtn);
		
		JTextArea txtrYourItems = new JTextArea();
		txtrYourItems.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtrYourItems.setText("Your Items:");
		txtrYourItems.setBounds(10, 117, 70, 19);
		frame.getContentPane().add(txtrYourItems);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 71, 334, 133);
		frame.getContentPane().add(scrollPane);
		
		JButton useItemBtn = new JButton("Use Item");
		useItemBtn.setBounds(132, 227, 89, 23);
		frame.getContentPane().add(useItemBtn);
		
		JButton sellItemBtn = new JButton("Sell Item");
		sellItemBtn.setBounds(267, 227, 89, 23);
		frame.getContentPane().add(sellItemBtn);
	}
}
