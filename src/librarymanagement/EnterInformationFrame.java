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

public class EnterInformationFrame {
	private String buttonName;
	private String windowName;
	
	EnterInformationFrame(String windowName, boolean needsSignIn) {
		JFrame enterInfoFrame = new JFrame(windowName);
		enterInfoFrame.setSize(600, 600);
		enterInfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panelNorth = new JPanel();
		JLabel title = new JLabel(windowName);
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		
		panelNorth.add(title);
		panelNorth.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		panelNorth.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
		panelNorth.setPreferredSize(new Dimension(600,230));
		panelNorth.setBackground(Color.red);
		
		
		enterInfoFrame.add(panelNorth, BorderLayout.NORTH);

		if(!needsSignIn) {

		}
		
		
		if (needsSignIn) {

//			JButton button = new JButton();
//			button.addActionListener(this);
			
			JPanel panelCenter = new JPanel(new GridLayout(2,2,5,40));
			
			JLabel firstNameLabel = new JLabel("First name: ");
			JTextField firstNameField = new JTextField();
			

			JLabel lastNameLabel = new JLabel("Last name: ");
			JTextField lastNameField = new JTextField();
			
			JPanel panelWest = new JPanel();

			
			JPanel panelEast = new JPanel();
			JPanel panelSouth = new JPanel();
			

			// These panels dimensions are used to squash the components into place because
			// I don't know any other way with the default Java Swing layouts
			panelWest.setPreferredSize(new Dimension(175,200));
			panelEast.setPreferredSize(new Dimension(175,200));
			panelSouth.setPreferredSize(new Dimension(200,230));
			
			panelWest.setBackground(Color.cyan);
			
			panelCenter.add(firstNameLabel);
			panelCenter.add(firstNameField);
			panelCenter.add(lastNameLabel);
			panelCenter.add(lastNameField);
			enterInfoFrame.add(panelCenter, BorderLayout.CENTER);
			enterInfoFrame.add(panelWest, BorderLayout.WEST);
			enterInfoFrame.add(panelEast, BorderLayout.EAST);
			enterInfoFrame.add(panelSouth, BorderLayout.SOUTH);
			
			JButton registerButton = new JButton("Register");
			registerButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					// Create user
				}
				
			});
			

		}
		enterInfoFrame.setVisible(true);
		
	}
	


	
	
}
