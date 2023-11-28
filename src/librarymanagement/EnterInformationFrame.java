package librarymanagement;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class EnterInformationFrame {

	private boolean login;	
	private JPanel panelWest = new JPanel();
	private JPanel panelEast = new JPanel();
	private JPanel panelSouth = new JPanel(); 
	private JPanel panelNorth = new JPanel();
	
	JFrame enterInfoFrame = new JFrame();


		/**
		 * EnterInformationFrame is extended by children to create 2 types 
		 * of windows: a window for signing up, and a window for logging in
		 * Forms the basic signup frame for both frames with a title, Jframe window name
		 * and some formatting to the JFrame
		 * Sets up 4 panels for a JFrame border layout setup
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
	
	/**
	 * Returns whether the login has finished or not
	 * Returns true if login was successful, false
	 * if it was not successful
	 * @return 
	 */
	public boolean getLogin() {
		return login;
	}

	/**
	 * returns the southern panel, which is used in a 
	 * border layout
	 * @return panelSouth
	 */
	public JPanel getPanelSouth() {
		return panelSouth;
		
	}
	
	/**
	 * returns the eastern panel, which is used in a 
	 * border layout
	 * @return panelEast
	 */
	public JPanel getPanelEast() {
		return panelEast;
		
	}

	/**
	 * returns the west panel, which is used in a 
	 * border layout
	 * @return panelWest
	 */
	public JPanel getPanelWest() {
		return panelWest;
		
	}
	/**
	 * returns the North panel, which is used in a 
	 * border layout
	 * @return panelNorth
	 */
	public JPanel getPanelNorth() {
		return panelNorth;
		
	}
	
}
