package librarymanagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LibraryUserMenu {
	
	/**
	 * For admins, it creates a list of users registered, allowing them
	 * to remove them by selecting checkboxes and clicking the remove button
	 * They can also press the book catalog button to acces the library's list
	 * of books, and add users to the list of users in the library
	 * @param library
	 */
	LibraryUserMenu(Library library) {
		JFrame frame = new JFrame("Library User Management");
		JPanel panel = new JPanel();
		JPanel southPanel = new JPanel();
		JScrollPane userCatalog = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		panel.setPreferredSize(new Dimension(400,600));
		
		JButton removeUser = new JButton("Remove");
		JButton addUser = new JButton("Add");
		JButton openBookCatalog = new JButton("Book Catalog");
		JButton logout = new JButton("Logout");
		JButton importButton = new JButton("Import");
		JButton exportButton = new JButton("Export");
		southPanel.add(removeUser);
		southPanel.add(Box.createRigidArea(new Dimension(40,0)));
		southPanel.add(addUser);
		southPanel.add(Box.createRigidArea(new Dimension(40,0)));
		southPanel.add(openBookCatalog);
		southPanel.add(Box.createRigidArea(new Dimension(40,0)));
		southPanel.add(logout);
		southPanel.add(Box.createRigidArea(new Dimension(40,0)));
		southPanel.add(importButton);
		southPanel.add(Box.createRigidArea(new Dimension(40,0)));
		southPanel.add(exportButton);
		
		ArrayList<User> userList = new ArrayList<User>();
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 20,20);
		
		panel.setLayout(flowLayout);
		for(User u: library.getuserList()) {
			JLabel label = new JLabel("<html>" + u.getName() + "<br/>" + 
					u.getLibraryCard() + "<html>");
			label.setPreferredSize(new Dimension(150,60));
			JCheckBox selectUser = new JCheckBox();
			selectUser.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == 1) {
						userList.add(u);
					} else {
						userList.remove(u);
					}
				}
				
			});
			panel.add(label);
			panel.add(selectUser);
		}
		
		removeUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame removeException = new JFrame("Remove user exception");
				removeException.setSize(new Dimension(600,200));
				JPanel removePanel = new JPanel();
				removePanel.add(Box.createRigidArea(new Dimension(0,150)));
				
				try {
					
					if(userList.isEmpty()) {
						throw new AddRemoveUserException.RemoveEmpty();
					}
					
					for (User u : userList ) {
						library.removeUser(u);
					}
					frame.dispose();
					new LibraryUserMenu(library);
					
				} catch (AddRemoveUserException.RemoveEmpty removeUserEmpty) {
					JLabel exceptionMessage = new JLabel(removeUserEmpty.getMessage());
					removePanel.add(exceptionMessage);
					removeException.add(removePanel);
					removeException.setVisible(true);
					LibraryGUI.openJFrames.add(removeException);
					
				}

				

			}
			
		});
		
		addUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new EnterSignUpFrame("Sign up", library, frame, true);
				
			}
			
		});
		
		openBookCatalog.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LibraryAdminCatalogMenu(library);
				
			}
			
		});
		
		logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				LibraryGUI.closeJFrames();
				new LibraryLoginSignUpFrame(library);
			}
			
		});

		importButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					Library newLibrary = LibraryLoginSignUpFrame.setLibrary(library, file);
					frame.dispose();
					
					new LibraryUserMenu(newLibrary);
				}
			}

		});

		exportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnVal = fc.showOpenDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					LibraryLoginSignUpFrame.exportLibrary(library, file.getPath() + "\\" + library.getName() + ".json");
				}
			}

		});
		frame.add(southPanel, BorderLayout.SOUTH);
		frame.setSize(new Dimension(800,600));
		frame.add(userCatalog, BorderLayout.CENTER);
		frame.setVisible(true);
		LibraryGUI.openJFrames.add(frame);
		
	}
}
