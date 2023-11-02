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
	
	
	//10/31/2023 I can take out some common elements like the panels in the frame and then
	// reduce duplicate code
	
	EnterInformationFrame(String windowName, boolean needsSignUp) {
		JFrame enterInfoFrame = new JFrame(windowName);
		enterInfoFrame.setSize(600, 600);
		enterInfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panelWest = new JPanel();
		JPanel panelEast = new JPanel();
		JPanel panelSouth = new JPanel();
		JPanel panelNorth = new JPanel();
		
		JLabel title = new JLabel(windowName);
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		
		panelNorth.add(title);
		panelNorth.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		panelNorth.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
		panelNorth.setPreferredSize(new Dimension(600,230));
//		panelNorth.setBackground(Color.red);
		panelNorth.add(Box.createRigidArea(new Dimension(0,350)));
		
		enterInfoFrame.add(panelNorth, BorderLayout.NORTH);

		if(!needsSignUp) {
			

			JButton loginButton = new JButton("Login");
			loginButton.addActionListener(new ActionListener() {
		
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					// Compare user username and password
					// create exceptions
					
					
					// work here
//					try {
//						
//					} catch() {
//						
//					}
					
				}
				
			});
			

			
			JLabel usernameLabel = new JLabel("Username: ");
			JTextField usernameField = new JTextField();
			JLabel passwordLabel = new JLabel("Password: ");
			JTextField passwordField = new JTextField();
			JPanel panelCenter = new JPanel(new GridLayout(2,2,5,40));
		
			panelWest.setPreferredSize(new Dimension(195,200));
			panelEast.setPreferredSize(new Dimension(195,200));
			panelSouth.setPreferredSize(new Dimension(200,230));
			
			panelCenter.add(usernameLabel);
			panelCenter.add(usernameField);
			panelCenter.add(passwordLabel);
			panelCenter.add(passwordField);
			
			panelSouth.add(loginButton);
			
			enterInfoFrame.add(panelCenter, BorderLayout.CENTER);
			enterInfoFrame.add(panelWest, BorderLayout.WEST);
			enterInfoFrame.add(panelEast, BorderLayout.EAST);
			enterInfoFrame.add(panelSouth, BorderLayout.SOUTH);
			
		}
		
		
		if (needsSignUp) {

			JLabel firstNameLabel = new JLabel("First name: ");
			JTextField firstNameField = new JTextField();
			JLabel lastNameLabel = new JLabel("Last name: ");
			JTextField lastNameField = new JTextField();
			
			// wow this works thats cool
			JLabel phoneNumberLabel = new JLabel("<html>Phone number: <br/>(9 digits only)<html>");
			JTextField phoneNumberField = new JTextField();
			
			JPanel panelCenter = new JPanel(new GridLayout(3,2,5,40));

			// These panels dimensions are used to squash the components into place because
			// I don't know any other way with the default Java Swing layouts
			panelWest.setPreferredSize(new Dimension(195,200));
			panelEast.setPreferredSize(new Dimension(195,200));
			panelSouth.setPreferredSize(new Dimension(200,160));
			
//			panelWest.setBackground(Color.cyan);
			
			panelCenter.add(firstNameLabel);
			panelCenter.add(firstNameField);
			panelCenter.add(lastNameLabel);
			panelCenter.add(lastNameField);
			panelCenter.add(phoneNumberLabel);
			panelCenter.add(phoneNumberField);
			
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
					String userFirstName = firstNameField.getText();
					String userLastName = lastNameField.getText();
					String userPhoneNumber = phoneNumberField.getText();
					boolean notDigit = false;
					for (Character c: userPhoneNumber.toCharArray()) {
						if (!Character.isDigit(c)) {
							notDigit = true;
							break;
						}
					}
					JFrame registrationExceptionFrame = new JFrame("Registration Error");
					registrationExceptionFrame.setSize(new Dimension(600,200));
					JPanel registrationExceptionPanel = new JPanel();
					registrationExceptionPanel.add(Box.createRigidArea(new Dimension(0,150)));
					
					// work here
					try {

						
						
						if(userFirstName.length() < 1) {
							throw new LoginSignUpException.EmptyFirstName();
						} else if(userLastName.length() < 1) {
							throw new LoginSignUpException.EmptyLastName();
						} else if (userPhoneNumber.length() < 1) {
							throw new LoginSignUpException.EmptyPhoneNumber();
						} else if (notDigit) {
							throw new LoginSignUpException.InvalidPhoneNumber();
						} else if (userPhoneNumber.length() != 9) {
							throw new LoginSignUpException.InvalidPhoneNumberLength();
						}
						// check if phone number has non digits
						// check if phone number is 9 digits
						
						
					} catch(LoginSignUpException.EmptyFirstName emptyFirstName) {
						JLabel exceptionMessage = new JLabel(emptyFirstName.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
						
					} catch(LoginSignUpException.EmptyLastName emptyLastName) {
						JLabel exceptionMessage = new JLabel(emptyLastName.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
						
					} catch(LoginSignUpException.EmptyPhoneNumber emptyPhoneNumber) {
						JLabel exceptionMessage = new JLabel(emptyPhoneNumber.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
						
					} catch(LoginSignUpException.InvalidPhoneNumber invalidNumber) {
						JLabel exceptionMessage = new JLabel(invalidNumber.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
						
					} catch(LoginSignUpException.InvalidPhoneNumberLength invalidNumberLength) {
						JLabel exceptionMessage = new JLabel(invalidNumberLength.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
					}
					registrationExceptionFrame.add(registrationExceptionPanel);
					registrationExceptionFrame.setVisible(true);
				}
				
			});
			
			panelSouth.add(registerButton);
			
		}
		enterInfoFrame.setVisible(true);
		
	}
	


	
	
}
