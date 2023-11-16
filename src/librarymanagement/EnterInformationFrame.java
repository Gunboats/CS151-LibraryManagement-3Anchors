package librarymanagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import librarymanagement.LoginException.EmptyPassword;
import librarymanagement.LoginException.IncorrectUsernamePasswordCombo;

public class EnterInformationFrame {
	private String buttonName;
	private String windowName;
	private boolean login;
	
	private JPanel panelWest = new JPanel();
	private JPanel panelEast = new JPanel();
	private JPanel panelSouth = new JPanel(); 
	private JPanel panelNorth = new JPanel();
	
	JFrame enterInfoFrame = new JFrame();


		/**
		 * EnterInformationFrame is extended by children to create 2 types 
		 * of windows: a window for signing up, and a window for logging in
		 * Users can enter their first name, last name, and phone number to sign up
		 * Forms the basic signup frame for both frames with a title, Jframe window name
		 * and some formatting to the JFrame
		 * 
		 * @param windowName The name of the window
		 * @param library The library being used to register/signup
		 * @param The main menu (first JFrame on launch) to be closed after successful
		 * login
		 */
	public EnterInformationFrame(String windowName, Library library, JFrame frame) {
		login = false;
		enterInfoFrame.setName(windowName);
		enterInfoFrame.setResizable(false);
		enterInfoFrame.setSize(600, 600);
		enterInfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel title = new JLabel(windowName);
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		
		panelNorth.add(title);
		panelNorth.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		panelNorth.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
		panelNorth.setPreferredSize(new Dimension(600,230));
//		panelNorth.setBackground(Color.red);
		panelNorth.add(Box.createRigidArea(new Dimension(0,350)));
		
		enterInfoFrame.add(panelNorth, BorderLayout.NORTH);


		
	}
	
	public boolean getLogin() {
		return login;
	}

	public JPanel getPanelSouth() {
		return panelSouth;
		
	}
	
	public JPanel getPanelEast() {
		return panelEast;
		
	}
	public JPanel getPanelWest() {
		return panelWest;
		
	}
	public JPanel getPanelNorth() {
		return panelNorth;
		
	}
	
}
