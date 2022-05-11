package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import main.GameEnvironment;

import java.awt.Font;
import javax.swing.JScrollPane;

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
		
		JTextArea txtrSelectAMonster = new JTextArea();
		txtrSelectAMonster.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrSelectAMonster.setText("Select a monster to use your selected item on:");
		txtrSelectAMonster.setBounds(80, 11, 273, 22);
		frmSelectAMonster.getContentPane().add(txtrSelectAMonster);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 63, 347, 160);
		frmSelectAMonster.getContentPane().add(scrollPane);
	}
}
