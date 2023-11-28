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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import librarymanagement.LoginException.IncorrectUsernamePasswordCombo;

public class EnterLoginFrame extends EnterInformationFrame{

	/**
	 * Creates the login window for users to enter their username and password
	 * and checks if the information is correct before allowing the user to
	 * login. If the information is not correct, it will throw an exception
	 * and make a popup. 
	 * If the login is successful, it lets the user access the library's catalog
	 * @param windowName The name of the window
	 * @param library	The library being accessed
	 * @param frame The main menu frame to be closes on successful login
	 */
	public EnterLoginFrame(String windowName, Library library, JFrame frame) {
		super(windowName, library, frame);
			
			JLabel usernameLabel = new JLabel("Username: ");
			JTextField usernameField = new JTextField();
			JLabel passwordLabel = new JLabel("Password: ");
			JPasswordField passwordField = new JPasswordField();
			JPanel panelCenter = new JPanel(new GridLayout(2,2,5,40));
		
			JButton loginButton = new JButton("Login");
			loginButton.addActionListener(new ActionListener() {
				
				/**
				 * Login button creates a window for the user to enter their information
				 * There are 2 fields they use to enter their information
				 * One is for password, one is for username (library card id)
				 * If users incorrectly enter their information, there will be a popup 
				 * explaining that something went wrong like an empty field, incorrect info
				 * Successful login will open up the library catalog
				 * Compares the entered information with the library's database to see if 
				 * the user is with the library, if the username and password are correct
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
					boolean hasLogin = false;
					try {
						if (copyUsername.length() < 1) {
							throw new LoginException.EmptyUsername();
						}
						if (copyPassword.length() < 1) {
							throw new LoginException.EmptyPassword();
						}

						for(User u: library.getuserList()) {
							if(u.getPassword().equals(copyPassword) && 
								u.getLibraryCard().equals(copyUsername)) {
								hasLogin = true;
							}
						}

						if (hasLogin) {
							for(User u: library.getuserList()) {
								if(u.getPassword().equals(copyPassword) && 
									u.getLibraryCard().equals(copyUsername)) {
									frame.dispose();
									enterInfoFrame.dispose();
							
									User copyUser = u;
									new LibraryCatalogMenu(library, copyUser);
									break;
								}
							}
						} else {
							throw new LoginException.IncorrectUsernamePasswordCombo();
						}


						
					} catch(LoginException.EmptyUsername emptyUsername) {
						JLabel exceptionMessage = new JLabel(emptyUsername.getMessage());
						incorrectPanel.add(exceptionMessage);
						incorrectLogin.add(incorrectPanel);
						incorrectLogin.setVisible(true);
						LibraryGUI.openJFrames.add(incorrectLogin);
					} catch (LoginException.EmptyPassword emptyPassword) {
						JLabel exceptionMessage = new JLabel(emptyPassword.getMessage());
						incorrectPanel.add(exceptionMessage);
						incorrectLogin.add(incorrectPanel);
						incorrectLogin.setVisible(true);
						LibraryGUI.openJFrames.add(incorrectLogin);
					} catch (IncorrectUsernamePasswordCombo incorrectUserPass) {
						JLabel exceptionMessage = new JLabel(incorrectUserPass.getMessage());
						incorrectPanel.add(exceptionMessage);
						incorrectLogin.add(incorrectPanel);
						incorrectLogin.setVisible(true);
						LibraryGUI.openJFrames.add(incorrectLogin);
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
			LibraryGUI.openJFrames.add(enterInfoFrame);
		
	}
	
}
