package librarymanagement;

import java.awt.BorderLayout;
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

public class EnterSignUpFrame extends EnterInformationFrame{

	
	/**
	 * Creates a signup frame allowing the user to enter a first name,
	 * last name, and their phone number
	 * Phone numbers are meant to be unique, and prevents the user from
	 * entering a duplicate phone number so that we can distinguish which
	 * user is which
	 * Signing up requires a name with valid letters and special characters
	 * Successful registration will give the user a library card with their
	 * Library id, and remind them of their password
	 * Failing to properly fill out fields will create a popup
	 * 
	 * Special case for admin adding users: This constructor is also used to 
	 * refresh the admin's JFrame of library users at a library, and is used
	 * to allow admin's to add users if users do not directly register themselves.
	 * 
	 * @param windowName The name of the JFrame window
	 * @param library The library adding the user
	 * @param frame The frame (AdminCatalogMenu) that is refreshed
	 * @param refresh True if the AdminCatalogMenu needs to be refreshed, false
	 * for other cases
	 */
	public EnterSignUpFrame(String windowName, Library library, JFrame frame, boolean refresh) {
		super(windowName, library, frame);
			JLabel firstNameLabel = new JLabel("First name: ");
			JTextField firstNameField = new JTextField();
			JLabel lastNameLabel = new JLabel("Last name: ");
			JTextField lastNameField = new JTextField();
			
			// wow this works thats cool
			JLabel phoneNumberLabel = new JLabel("<html>Phone number: <br/>(9 digits only)<html>");
			JTextField phoneNumberField = new JTextField();
			
			JLabel passwordLabel = new JLabel("Password: ");
			JTextField passwordField = new JTextField();

			JPanel panelCenter = new JPanel(new GridLayout(4,2,5,40));

			// These panels dimensions are used to squash the components into place because
			// I don't know any other way with the default Java Swing layouts
			getPanelWest().setPreferredSize(new Dimension(195,200));
			getPanelEast().setPreferredSize(new Dimension(195,200));
			getPanelSouth().setPreferredSize(new Dimension(200,90));
			
//			panelWest.setBackground(Color.cyan);
			
			panelCenter.add(firstNameLabel);
			panelCenter.add(firstNameField);
			panelCenter.add(lastNameLabel);
			panelCenter.add(lastNameField);
			panelCenter.add(phoneNumberLabel);
			panelCenter.add(phoneNumberField);
			panelCenter.add(passwordLabel);
			panelCenter.add(passwordField);
			
			enterInfoFrame.add(panelCenter, BorderLayout.CENTER);
			enterInfoFrame.add(getPanelWest(), BorderLayout.WEST);
			enterInfoFrame.add(getPanelEast(), BorderLayout.EAST);
			enterInfoFrame.add(getPanelSouth(), BorderLayout.SOUTH);
			
			JButton registerButton = new JButton("Register");
			registerButton.addActionListener(new ActionListener() {

				
				/**
				 * Checks first name and last name if there are non-letters
				 * or nonvalid characters, and throws exceptions to tell user
				 * what went wrong with registering
				 * There has to be a minimum of 1 letter for first name and last name
				 * Failing to register will create a popup telling users what went 
				 * wrong with registering
				 * Phone numbers must be all digits and 9 digits in total
				 * 
				 */
				@Override
				public void actionPerformed(ActionEvent e) {
					// Create user
					String userFirstName = firstNameField.getText();
					String userLastName = lastNameField.getText();
					String userPhoneNumber = phoneNumberField.getText();
					String userPassword = passwordField.getText();
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
						} else if (userPassword.length() < 1) {
							throw new SignUpException.EmptyPassword();
						}
						
						User newUser = new User(userFirstName, userLastName, userPhoneNumber, userPassword);
						if(library.containsNumber(userPhoneNumber)) {
							throw new SignUpException.PhoneNumberAlreadyUsed();
						} else {

							library.addUser(newUser);
							
							

							
							
							JFrame registered = new JFrame("Registered");
							registered.setSize(new Dimension(600,200));
							JPanel registeredPanel = new JPanel();
							registeredPanel.setLayout(new BoxLayout(registeredPanel, BoxLayout.Y_AXIS));
							JLabel registrationMessage = new JLabel("You registered successfully!");
							JLabel registrationUsername = new JLabel("Your username/library card is: " +
									newUser.getLibraryCard());
							JLabel registrationPassword = new JLabel("Your password is: " +
									newUser.getPassword());
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
							LibraryGUI.openJFrames.add(registered);
							enterInfoFrame.dispose();
							if (refresh) {
								frame.dispose();
								new LibraryUserMenu(library);
								
							}
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
						LibraryGUI.openJFrames.add(registrationExceptionFrame);
					} catch(SignUpException.EmptyPhoneNumber emptyPhoneNumber) {
						JLabel exceptionMessage = new JLabel(emptyPhoneNumber.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
						registrationExceptionFrame.add(registrationExceptionPanel);
						registrationExceptionFrame.setVisible(true);
						LibraryGUI.openJFrames.add(registrationExceptionFrame);
					} catch(SignUpException.InvalidPhoneNumber invalidNumber) {
						JLabel exceptionMessage = new JLabel(invalidNumber.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
						registrationExceptionFrame.add(registrationExceptionPanel);
						registrationExceptionFrame.setVisible(true);
						LibraryGUI.openJFrames.add(registrationExceptionFrame);
					} catch(SignUpException.InvalidPhoneNumberLength invalidNumberLength) {
						JLabel exceptionMessage = new JLabel(invalidNumberLength.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
						registrationExceptionFrame.add(registrationExceptionPanel);
						registrationExceptionFrame.setVisible(true);
						LibraryGUI.openJFrames.add(registrationExceptionFrame);
					} catch(SignUpException.InvalidFirstName invalidFirstName) {
						JLabel exceptionMessage = new JLabel(invalidFirstName.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
						registrationExceptionFrame.add(registrationExceptionPanel);
						registrationExceptionFrame.setVisible(true);
						LibraryGUI.openJFrames.add(registrationExceptionFrame);
					} catch(SignUpException.InvalidLastName invalidLastName) {
						JLabel exceptionMessage = new JLabel(invalidLastName.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
						registrationExceptionFrame.add(registrationExceptionPanel);
						registrationExceptionFrame.setVisible(true);
						LibraryGUI.openJFrames.add(registrationExceptionFrame);
					} catch(SignUpException.PhoneNumberAlreadyUsed numAlreadyUsed) {
						JLabel exceptionMessage = new JLabel(numAlreadyUsed.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
						registrationExceptionFrame.add(registrationExceptionPanel);
						registrationExceptionFrame.setVisible(true);
						LibraryGUI.openJFrames.add(registrationExceptionFrame);
					} catch(SignUpException.EmptyPassword emptyPassword) {
						JLabel exceptionMessage = new JLabel(emptyPassword.getMessage());
						exceptionMessage.setFont(new Font("Arial", Font.PLAIN, 20));
						registrationExceptionPanel.add(exceptionMessage);
						registrationExceptionFrame.add(registrationExceptionPanel);
						registrationExceptionFrame.setVisible(true);
						LibraryGUI.openJFrames.add(registrationExceptionFrame);
					}
					
				}
				
			});
			
			getPanelSouth().add(registerButton);
			enterInfoFrame.setVisible(true);
			LibraryGUI.openJFrames.add(enterInfoFrame);
		
	}

}
