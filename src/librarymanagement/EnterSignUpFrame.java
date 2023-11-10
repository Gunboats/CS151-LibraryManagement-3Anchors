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

	public EnterSignUpFrame(String windowName, Library library, JFrame frame) {
		super(windowName, library, frame);
		// TODO Auto-generated constructor stub


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
			enterInfoFrame.setVisible(true);
		
	}

}
