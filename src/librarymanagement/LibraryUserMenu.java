package librarymanagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LibraryUserMenu {
	LibraryUserMenu(Library library) {
		JFrame frame = new JFrame("Library User Management");
		JPanel panel = new JPanel();
		JPanel southPanel = new JPanel();
		JScrollPane userCatalog = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		panel.setPreferredSize(new Dimension(400,600));
		
		JButton removeUser = new JButton("Remove");
		JButton addUser = new JButton("Add");
		JButton openBookCatalog = new JButton("Book Catalog");
		
		southPanel.add(removeUser);
		southPanel.add(Box.createRigidArea(new Dimension(150,0)));
		southPanel.add(addUser);
		southPanel.add(Box.createRigidArea(new Dimension(150,0)));
		southPanel.add(openBookCatalog);
		
		ArrayList<User> userList = new ArrayList<User>();
		int length = library.getuserList().size()/2 + 1;
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 20,20);
		
		panel.setLayout(flowLayout);
		for(User u: library.getuserList()) {
			JLabel label = new JLabel("<html>" + u.getName() + "<br/>" + 
					u.getLibraryCard(library.getCardPrefix()) + "<html>");
			label.setPreferredSize(new Dimension(150,60));
			JCheckBox selectUser = new JCheckBox();
			selectUser.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
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
				// TODO Auto-generated method stub
				// I need to refresh the list whenever i remove
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
				}

				

			}
			
		});
		
		addUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame temp = new JFrame();
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
		
		frame.add(southPanel, BorderLayout.SOUTH);
		frame.setSize(new Dimension(800,600));
		frame.add(userCatalog, BorderLayout.CENTER);
		frame.setVisible(true);
		
	}
}
