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
		 * @param windowName The name of the login or signup window
		 * @param needsSignUp True for sign up window, false for login window
		 */
	EnterInformationFrame(String windowName, boolean needsSignUp, Library library) {

		JFrame enterInfoFrame = new JFrame(windowName);
		enterInfoFrame.setResizable(false);
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
			
			JLabel usernameLabel = new JLabel("Username: ");
			JTextField usernameField = new JTextField();
			JLabel passwordLabel = new JLabel("Password: ");
			JTextField passwordField = new JTextField();
			JPanel panelCenter = new JPanel(new GridLayout(2,2,5,40));
		
			JButton loginButton = new JButton("Login");
			loginButton.addActionListener(new ActionListener() {
		
				
				/**
				 * Login button creates a window for the user to enter their information
				 * There are 2 fields they use to enter their information
				 * One is for password (phone number), one is for username (library card id)
				 * If users incorrectly enter their information, there will be a popup 
				 * explaining that something went wrong like an empty field, incorrect info
				 * 
				 * Not incorporated yet: I need to open a window on successful login for users
				 * to access the library catalog
				 * 
				 */
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					// Compare user username and password
					// create exceptions
					String copyUsername = usernameField.getText();
					String copyPassword = passwordField.getText();
					// work here
					JFrame incorrectLogin = new JFrame("Incorrect Login");
					JPanel incorrectPanel = new JPanel();
					incorrectPanel.add(Box.createRigidArea(new Dimension(0,150)));
					incorrectLogin.setSize(new Dimension(600,200));
					
					try {
						if (copyUsername.length() < 1) {
							throw new LoginException.EmptyUsername();
						}
						if (copyPassword.length() < 1) {
							throw new LoginException.EmptyPassword();
						}
						if (!library.getPhoneNumAndUserMap().containsKey(copyPassword) || 
						!library.getPhoneNumAndUserMap().get(copyPassword)
						.getLibraryCard(library.getCardPrefix()).getFullCardID().equals(copyUsername)) {
							throw new LoginException.IncorrectUsernamePasswordCombo();
						}
						
						
						
					} catch(LoginException.EmptyUsername emptyUsername) {
						JLabel exceptionMessage = new JLabel(emptyUsername.getMessage());
						incorrectPanel.add(exceptionMessage);
						incorrectLogin.add(incorrectPanel);
						incorrectLogin.setVisible(true);
					} catch (LoginException.EmptyPassword emptyPassword) {
						JLabel exceptionMessage = new JLabel(emptyPassword.getMessage());
						incorrectPanel.add(exceptionMessage);
						incorrectLogin.add(incorrectPanel);
						incorrectLogin.setVisible(true);
					} catch (IncorrectUsernamePasswordCombo incorrectUserPass) {
						JLabel exceptionMessage = new JLabel(incorrectUserPass.getMessage());
						incorrectPanel.add(exceptionMessage);
						incorrectLogin.add(incorrectPanel);
						incorrectLogin.setVisible(true);
					} 
					
				}
				
			});
			
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

				
				/**
				 * Checks first name and last name if there are non-letters
				 * or nonvalid characters, and throws exceptions to tell user
				 * what went wrong with registering
				 * Phone numbers must be all digits and 9 digits in total
				 * 
				 */
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					// Create user
					String userFirstName = firstNameField.getText();
					String userLastName = lastNameField.getText();
					String userPhoneNumber = phoneNumberField.getText();
					boolean notDigit = false;
					boolean invalidNameFirst = false;
					boolean invalidNameLast = false;
					
					for (Character c: userFirstName.toCharArray()) {
						if (!Character.isLetter(c) && !c.equals('-') && 
								!c.equals(' ') && !c.equals('\'') && !c.equals('.')) {
							invalidNameFirst = true;
							break;
						}
					}
					for (Character c: userLastName.toCharArray()) {
						if (!Character.isLetter(c) && !c.equals('-') && 
								!c.equals(' ') && !c.equals('\'') && !c.equals('.')) {
							invalidNameLast = true;
							break;
						}
					}
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
					
					try {
						
						if(userFirstName.length() < 1) {
							throw new SignUpException.EmptyFirstName();
						} else if(userLastName.length() < 1) {
							throw new SignUpException.EmptyLastName();
						} else if (userPhoneNumber.length() < 1) {
							throw new SignUpException.EmptyPhoneNumber();
						} else if (notDigit) {
							throw new SignUpException.InvalidPhoneNumber();
						} else if (userPhoneNumber.length() != 9) {
							throw new SignUpException.InvalidPhoneNumberLength();
						} else if (invalidNameFirst) {
							throw new SignUpException.InvalidFirstName();
						} else if (invalidNameLast) {
							throw new SignUpException.InvalidLastName();
						}
						
						User newUser = new User(userFirstName, userLastName, userPhoneNumber);
						if(library.containsNumber(userPhoneNumber)) {
							throw new SignUpException.PhoneNumberAlreadyUsed();
						} else {
							library.addUser(newUser);
							enterInfoFrame.dispose();
							JFrame registered = new JFrame("Registered");
							registered.setSize(new Dimension(600,200));
							JPanel registeredPanel = new JPanel();
							registeredPanel.setLayout(new BoxLayout(registeredPanel, BoxLayout.Y_AXIS));
							JLabel registrationMessage = new JLabel("You registered successfully!");
							JLabel registrationUsername = new JLabel("Your username/library card is: " +
									newUser.getLibraryCard(library.getCardPrefix()).getFullCardID());
							JLabel registrationPassword = new JLabel("Your password is: " +
									newUser.getPhoneNumber());
							registeredPanel.add(Box.createRigidArea(new Dimension(0,75)));
							registrationMessage.setAlignmentX(JLabel.CENTER_ALIGNMENT);
							registrationUsername.setAlignmentX(JLabel.CENTER_ALIGNMENT);
							registrationPassword.setAlignmentX(JLabel.CENTER_ALIGNMENT);
//							registeredPanel.add(Box.createRigidArea(new Dimension(0,150)));
							registeredPanel.add(registrationMessage, BorderLayout.NORTH);
							
							registeredPanel.add(registrationUsername);
							registeredPanel.add(registrationPassword);
							registered.add(registeredPanel);
							registered.setVisible(true);
						}
						
						
					} catch(SignUpException.EmptyFirstName emptyFirstName) {
						JLabel exceptionMessage = new JLabel(emptyFirstName.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
						registrationExceptionFrame.add(registrationExceptionPanel);
						registrationExceptionFrame.setVisible(true);
					} catch(SignUpException.EmptyLastName emptyLastName) {
						JLabel exceptionMessage = new JLabel(emptyLastName.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
						registrationExceptionFrame.add(registrationExceptionPanel);
						registrationExceptionFrame.setVisible(true);
					} catch(SignUpException.EmptyPhoneNumber emptyPhoneNumber) {
						JLabel exceptionMessage = new JLabel(emptyPhoneNumber.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
						registrationExceptionFrame.add(registrationExceptionPanel);
						registrationExceptionFrame.setVisible(true);
					} catch(SignUpException.InvalidPhoneNumber invalidNumber) {
						JLabel exceptionMessage = new JLabel(invalidNumber.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
						registrationExceptionFrame.add(registrationExceptionPanel);
						registrationExceptionFrame.setVisible(true);
					} catch(SignUpException.InvalidPhoneNumberLength invalidNumberLength) {
						JLabel exceptionMessage = new JLabel(invalidNumberLength.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
						registrationExceptionFrame.add(registrationExceptionPanel);
						registrationExceptionFrame.setVisible(true);
					} catch(SignUpException.InvalidFirstName invalidFirstName) {
						JLabel exceptionMessage = new JLabel(invalidFirstName.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
						registrationExceptionFrame.add(registrationExceptionPanel);
						registrationExceptionFrame.setVisible(true);
					} catch(SignUpException.InvalidLastName invalidLastName) {
						JLabel exceptionMessage = new JLabel(invalidLastName.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
						registrationExceptionFrame.add(registrationExceptionPanel);
						registrationExceptionFrame.setVisible(true);
					} catch(SignUpException.PhoneNumberAlreadyUsed numAlreadyUsed) {
						JLabel exceptionMessage = new JLabel(numAlreadyUsed.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
						registrationExceptionFrame.add(registrationExceptionPanel);
						registrationExceptionFrame.setVisible(true);
					}
					
				}
				
			});
			
			panelSouth.add(registerButton);
			
		}
		enterInfoFrame.setVisible(true);
		
	}
	


	
	
}
x