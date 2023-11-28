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

public class EnterLoginAdminFrame extends EnterInformationFrame{

	
	
	/**
	 * Frame extends EnterInformation frame
	 * Makes the login screen for admins to login
	 * Throws exceptions and makes windows on failure to
	 * enter "admin" and "password" into the respective username
	 * and password field
	 * @param windowName The name of the JFrame for logging in
	 * @param library The library being accessed by admin
	 * @param frame The main menu (LibraryLoginSignUpFrame) that will be 
	 * disposed on successful login
	 */
	public EnterLoginAdminFrame(String windowName, Library library, JFrame frame) {
		super(windowName, library, frame);
		JLabel usernameLabel = new JLabel("Username: ");
		JTextField usernameField = new JTextField();
		JLabel passwordLabel = new JLabel("Password: ");
		JPasswordField passwordField = new JPasswordField();
		JPanel panelCenter = new JPanel(new GridLayout(2,2,5,40));
	
		JButton loginButton = new JButton("Login");


		/**
		 * Takes the username and password fields the admin used
		 * and compares the values to the correct username and password
		 * needed to login
		 * Successful login allows the Admin to access LibraryCatalogMenu,
		 * which shows the list of users
		 * Failing to login creates a popup notifying the admin of what went
		 * wrong
		 */
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String copyUsername = usernameField.getText();
				String copyPassword = passwordField.getText();
				
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
					if (!library.getAdminPassword().equals(copyPassword) || 
					!library.getAdminUsername().equals(copyUsername)) {
						throw new LoginException.IncorrectUsernamePasswordCombo();
					}
					
					if(library.getAdminPassword().equals(copyPassword) && 
							library.getAdminUsername().equals(copyUsername)) {
						frame.dispose();
						enterInfoFrame.dispose();
						new LibraryUserMenu(library);

						
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
