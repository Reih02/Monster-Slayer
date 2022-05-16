package gui;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import main.GameEnvironment;
import main.Monster;

import javax.swing.JTextArea;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class ViewTeamScreen {

	private JFrame frmTeam;
	
	private GameEnvironment manager;
	
	public ViewTeamScreen(GameEnvironment incomingManager) {
		this.manager = incomingManager;
		initialize();
		frmTeam.setVisible(true);
	}
	
	public void closeWindow() {
		frmTeam.dispose();
	}
	
	public void shutdownWindow() {
		manager.closeViewTeamScreen(this);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTeamScreen window = new ViewTeamScreen();
					window.frmTeam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewTeamScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTeam = new JFrame();
		frmTeam.setTitle("Team");
		frmTeam.setBounds(100, 100, 450, 300);
		frmTeam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeam.getContentPane().setLayout(null);
		
		JTextArea txtrYourTeam = new JTextArea();
		txtrYourTeam.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtrYourTeam.setEditable(false);
		txtrYourTeam.setText("Your team:");
		txtrYourTeam.setBounds(182, 11, 84, 22);
		frmTeam.getContentPane().add(txtrYourTeam);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBounds(20, 44, 396, 210);
		frmTeam.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
	
		DefaultListModel<Monster> listModel = new DefaultListModel<>();
		ArrayList<Monster> monsters = manager.getMonsters();
		for (int i = 0; i < monsters.size(); i++) {
			listModel.addElement(monsters.get(i));
		}
		
		JList<Monster> monsterList = new JList<Monster>(listModel);
		panel.add(monsterList);
		
	}
}
