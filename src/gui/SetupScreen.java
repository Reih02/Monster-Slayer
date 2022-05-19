package gui;

import java.awt.EventQueue;
import main.GameEnvironment;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

/**
* In this class the user selects options depending on their preferences and chooses their starting Monster and can start 
* the game.
* Authors Orion Lynch and Reilly Haskins
*/

public class SetupScreen {

	private JFrame setupScreenFrame;
	private final ButtonGroup difficultyButtonGroup = new ButtonGroup();
	private JTextField playerNameInput;
	private final ButtonGroup startingMonsterButtonGroup = new ButtonGroup();
	private GameEnvironment manager;


	public SetupScreen(GameEnvironment incomingManager) {
		this.manager = incomingManager;
		initialize();
		setupScreenFrame.setVisible(true);
	}
	
	public void closeWindow() {
		setupScreenFrame.dispose();
	}
	
	public void shutdownWindow() {
		manager.closeSetupScreen(this);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen();
					window.setupScreenFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetupScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setupScreenFrame = new JFrame();
		setupScreenFrame.getContentPane().setBackground(SystemColor.inactiveCaption);
		setupScreenFrame.setTitle("Monster Slayer - Setup Screen");
		setupScreenFrame.setBounds(100, 100, 631, 490);
		setupScreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupScreenFrame.getContentPane().setLayout(null);
		
		JLabel welcomeLabel = new JLabel("Welcome, Monster Slayer!");
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		welcomeLabel.setBounds(174, 11, 324, 56);
		setupScreenFrame.getContentPane().add(welcomeLabel);
		
		JLabel difficultyLabel = new JLabel("Select Your Difficulty");
		difficultyLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		difficultyLabel.setBounds(101, 73, 125, 41);
		setupScreenFrame.getContentPane().add(difficultyLabel);
		
		JRadioButton easyDifficultyButton = new JRadioButton("Easy");
		easyDifficultyButton.setBackground(SystemColor.inactiveCaption);
		easyDifficultyButton.setActionCommand("False");
		easyDifficultyButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		easyDifficultyButton.setSelected(true);
		difficultyButtonGroup.add(easyDifficultyButton);
		easyDifficultyButton.setBounds(86, 112, 64, 23);
		setupScreenFrame.getContentPane().add(easyDifficultyButton);
		
		JRadioButton hardDifficultyButton = new JRadioButton("Hard");
		hardDifficultyButton.setBackground(SystemColor.inactiveCaption);
		hardDifficultyButton.setActionCommand("True");
		hardDifficultyButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		difficultyButtonGroup.add(hardDifficultyButton);
		hardDifficultyButton.setBounds(184, 112, 56, 23);
		setupScreenFrame.getContentPane().add(hardDifficultyButton);
		
		JLabel numDaysLabel = new JLabel("Number of days");
		numDaysLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		numDaysLabel.setBounds(371, 78, 170, 28);
		setupScreenFrame.getContentPane().add(numDaysLabel);
		
		JSlider numDaysSlider = new JSlider();
		numDaysSlider.setBackground(SystemColor.inactiveCaption);
		numDaysSlider.setFont(new Font("Tahoma", Font.PLAIN, 8));
		numDaysSlider.setMinorTickSpacing(1);
		numDaysSlider.setSnapToTicks(true);
		numDaysSlider.setPaintTicks(true);
		numDaysSlider.setPaintLabels(true);
		numDaysSlider.setMajorTickSpacing(1);
		numDaysSlider.setToolTipText("Select the number of days you want to play the game for (between 2 and 20).");
		numDaysSlider.setMaximum(20);
		numDaysSlider.setValue(2);
		numDaysSlider.setMinimum(2);
		numDaysSlider.setBounds(287, 112, 278, 41);
		setupScreenFrame.getContentPane().add(numDaysSlider);
		
		playerNameInput = new JTextField();
		playerNameInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		playerNameInput.setText("UserID");
		playerNameInput.setBounds(96, 252, 118, 41);
		setupScreenFrame.getContentPane().add(playerNameInput);
		playerNameInput.setColumns(10);
		
		JLabel playerNameLabel = new JLabel("Enter Player Name Here");
		playerNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		playerNameLabel.setBounds(75, 205, 155, 36);
		setupScreenFrame.getContentPane().add(playerNameLabel);
		
		JLabel selectMonsterLabel = new JLabel("Select your starting monster");
		selectMonsterLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		selectMonsterLabel.setBounds(331, 192, 179, 62);
		setupScreenFrame.getContentPane().add(selectMonsterLabel);
		
		JRadioButton garenStartingMonster = new JRadioButton("Garen");
		garenStartingMonster.setBackground(SystemColor.inactiveCaption);
		garenStartingMonster.setActionCommand("Garen");
		garenStartingMonster.setFont(new Font("Tahoma", Font.PLAIN, 12));
		garenStartingMonster.setSelected(true);
		startingMonsterButtonGroup.add(garenStartingMonster);
		garenStartingMonster.setToolTipText("Garen starts out with 90 health, 25 damage and heals 15 health each day.");
		garenStartingMonster.setBounds(309, 261, 109, 23);
		setupScreenFrame.getContentPane().add(garenStartingMonster);
		
		JRadioButton bloodMunchaStartingMonster = new JRadioButton("BloodMuncha");
		bloodMunchaStartingMonster.setBackground(SystemColor.inactiveCaption);
		bloodMunchaStartingMonster.setActionCommand("BloodMuncha");
		bloodMunchaStartingMonster.setFont(new Font("Tahoma", Font.PLAIN, 12));
		startingMonsterButtonGroup.add(bloodMunchaStartingMonster);
		bloodMunchaStartingMonster.setToolTipText("BloodMuncha starts out with 50 health, 45 damage and heals 25 health each day.");
		bloodMunchaStartingMonster.setBounds(309, 314, 109, 23);
		setupScreenFrame.getContentPane().add(bloodMunchaStartingMonster);
		
		JRadioButton katarinaStartingMonster = new JRadioButton("Katarina");
		katarinaStartingMonster.setBackground(SystemColor.inactiveCaption);
		katarinaStartingMonster.setActionCommand("Katarina");
		katarinaStartingMonster.setFont(new Font("Tahoma", Font.PLAIN, 12));
		startingMonsterButtonGroup.add(katarinaStartingMonster);
		katarinaStartingMonster.setToolTipText("Katarina starts out with 80 health, 30 damage and heals 15 health each day.");
		katarinaStartingMonster.setBounds(309, 366, 109, 23);
		setupScreenFrame.getContentPane().add(katarinaStartingMonster);
		
		JRadioButton malphiteStartingMonster = new JRadioButton("Malphite");
		malphiteStartingMonster.setBackground(SystemColor.inactiveCaption);
		malphiteStartingMonster.setActionCommand("Malphite");
		malphiteStartingMonster.setFont(new Font("Tahoma", Font.PLAIN, 12));
		startingMonsterButtonGroup.add(malphiteStartingMonster);
		malphiteStartingMonster.setToolTipText("Malphite starts out with 120 health, 15 damage and heals 25 health each day.");
		malphiteStartingMonster.setBounds(456, 261, 109, 23);
		setupScreenFrame.getContentPane().add(malphiteStartingMonster);
		
		JRadioButton masterYiStartingMonster = new JRadioButton("MasterYi");
		masterYiStartingMonster.setBackground(SystemColor.inactiveCaption);
		masterYiStartingMonster.setActionCommand("MasterYi");
		masterYiStartingMonster.setFont(new Font("Tahoma", Font.PLAIN, 12));
		startingMonsterButtonGroup.add(masterYiStartingMonster);
		masterYiStartingMonster.setToolTipText("MasterYi starts out with 100 health, 20 damage and heals 20 health each day.");
		masterYiStartingMonster.setBounds(456, 314, 109, 23);
		setupScreenFrame.getContentPane().add(masterYiStartingMonster);
		
		JRadioButton volibearStartingMonster = new JRadioButton("Volibear");
		volibearStartingMonster.setBackground(SystemColor.inactiveCaption);
		volibearStartingMonster.setActionCommand("Volibear");
		volibearStartingMonster.setFont(new Font("Tahoma", Font.PLAIN, 12));
		startingMonsterButtonGroup.add(volibearStartingMonster);
		volibearStartingMonster.setToolTipText("Volibear starts out with 150 health, 10 damage and heals 20 health each day.");
		volibearStartingMonster.setBounds(456, 366, 109, 23);
		setupScreenFrame.getContentPane().add(volibearStartingMonster);
		
		JButton btnNewButton = new JButton("Start Game!");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean difficulty;
				System.out.println(playerNameInput.getText());
				if (!manager.isNameValid(playerNameInput.getText())){
					JOptionPane.showMessageDialog(setupScreenFrame, "Please change your name so that it contains only alphanumeric characters (no spaces), and is between 3 and 15 characters");
				} else {
					if (difficultyButtonGroup.getSelection().getActionCommand() == "True") {
						difficulty = true;
					}
					else {
						difficulty = false;					
					}
					manager.setupGameEnvironment(playerNameInput.getText(), numDaysSlider.getValue(), startingMonsterButtonGroup.getSelection().getActionCommand(), difficulty);
					// new GameEnvironment(playerNameInput.getText(), numDaysSlider.getValue(), startingMonsterButtonGroup.getSelection().getActionCommand(), difficulty);
					setupScreenFrame.dispose();
					manager.launchMainScreen();
				}
				
			}
		});
	
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setToolTipText("Press this button once you are ready to start playing Monster-Slayer!");
		btnNewButton.setBounds(60, 314, 179, 85);
		setupScreenFrame.getContentPane().add(btnNewButton);
	}
}
