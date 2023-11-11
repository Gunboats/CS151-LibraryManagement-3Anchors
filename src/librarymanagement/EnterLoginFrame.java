package librarymanagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import librarymanagement.LoginException.IncorrectUsernamePasswordCombo;

public class EnterLoginFrame extends EnterInformationFrame{

	public EnterLoginFrame(String windowName, Library library, JFrame frame) {
		super(windowName, library, frame);
		// TODO Auto-generated constructor stub

			
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
						
						if(library.getPhoneNumAndUserMap().containsKey(copyPassword) && 
								library.getPhoneNumAndUserMap().get(copyPassword).getLibraryCard(library.getCardPrefix()).getFullCardID().equals(copyUsername)) {
							frame.dispose();
							enterInfoFrame.dispose();
							
							User copyUser = library.getPhoneNumAndUserMap().get(copyPassword);
							new LibraryCatalogMenu(library, copyUser);
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
			
			getPanelWest().setPreferredSize(new Dimension(195,200));
			getPanelEast().setPreferredSize(new Dimension(195,200));
			getPanelSouth().setPreferredSize(new Dimension(200,230));
			
			panelCenter.add(usernameLabel);
			panelCenter.add(usernameField);
			panelCenter.add(passwordLabel);
			panelCenter.add(passwordField);
			
			getPanelSouth().add(loginButton);
			
			enterInfoFrame.add(panelCenter, BorderLayout.CENTER);
			enterInfoFrame.add(getPanelWest(), BorderLayout.WEST);
			enterInfoFrame.add(getPanelEast(), BorderLayout.EAST);
			enterInfoFrame.add(getPanelSouth(), BorderLayout.SOUTH);
			enterInfoFrame.setVisible(true);
		
	}
	
}
