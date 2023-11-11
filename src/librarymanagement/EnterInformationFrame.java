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
	private JPanel panelSouth = new JPanel(); // setting this private messes with resolution
	private JPanel panelNorth = new JPanel();
	
	JFrame enterInfoFrame = new JFrame();

	
	//10/31/2023 I can take out some common elements like the panels in the frame and then
	// reduce duplicate code

		/**
		 * EnterInformationFrame creates 2 types of windows based on the boolean
		 * if boolean is True: Create a window for signing up
		 * if false: Create a window for logging in
		 * Users can enter their first name, last name, and phone number to sign up
		 * Signing up requires at least one character letter for first name and last name
		 * Phone numbers are unique and only used once
		 * Users enter their username and password to log in, their library card string
		 * and their phone number
		 * 
		 * @param windowName The name of the window
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
