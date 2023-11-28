package librarymanagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EnterBookFrame {
	
	
	/**
	 * Creates a JFrame allowing admins to make a book with 
	 * an admin specified name and author
	 * On successful creation, it is added to the library's
	 * list of books, and will refresh the JFrame for the 
	 * library's catalog of books, showing that the new book
	 * is in fact, in the library's catalog
	 * @param library The library the book will be added to
	 * @param frame The catalog frame that gets refreshed
	 */
	EnterBookFrame(Library library, JFrame frame) {
		/**
		 * Creates the JFrame that displays content, creates 4 panels
		 * to format the center panel, which uses a grid layout to display
		 * the labels and text fields, format the positions of the components
		 * Also creates button to add a book
		 */
		JFrame addBookFrame = new JFrame();
		addBookFrame.setSize(new Dimension(600,600));
		addBookFrame.setResizable(false);
		JLabel titleLabel = new JLabel("Title: ");
		JTextField titleField = new JTextField();
		JLabel authorLabel = new JLabel("Author ");
		JTextField authorField = new JTextField();
		JPanel panelCenter = new JPanel(new GridLayout(2,2,5,40));
		
		JPanel panelWest = new JPanel();
		JPanel panelEast = new JPanel();
		JPanel panelSouth = new JPanel(); 
		JPanel panelNorth = new JPanel();
		JLabel title = new JLabel("Add book");
		
		JButton addBook = new JButton("Add book");
		
		/**
		 * Section adjusts the size of each panel to squash the central
		 * panel into place, and adds the buttons, labels, and fields to
		 * the panels, uses a box in the northern panel to push down add book text
		 * Also adds the panel to the frame so they can be displayed
		 */
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		panelWest.setPreferredSize(new Dimension(195,200));
		panelEast.setPreferredSize(new Dimension(195,200));
		panelSouth.setPreferredSize(new Dimension(200,230));
		panelSouth.add(addBook);
		panelNorth.add(title);
		panelNorth.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		panelNorth.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
		panelNorth.setPreferredSize(new Dimension(600,230));
//		panelNorth.setBackground(Color.red);
		panelNorth.add(Box.createRigidArea(new Dimension(0,350)));
		
		panelCenter.add(titleLabel);
		panelCenter.add(titleField);
		panelCenter.add(authorLabel);
		panelCenter.add(authorField);
		
		addBookFrame.add(panelCenter, BorderLayout.CENTER);
		addBookFrame.add(panelNorth, BorderLayout.NORTH);
		addBookFrame.add(panelWest, BorderLayout.WEST);
		addBookFrame.add(panelEast, BorderLayout.EAST);
		addBookFrame.add(panelSouth, BorderLayout.SOUTH);

		
		/**
		 * On pressing addBook, it checks that the title and
		 * author field are not empty. If they are both not
		 * empty, it makes the book and adds the book to the library
		 * and refreshes the catalog
		 * Successful adding will create a book Object,
		 * failure to fill out the fields will throw an error,
		 * and create a pop up
		 */
		addBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame addException = new JFrame("Add Excepotion");
				addException.setSize(new Dimension(600,200));
				JPanel addExceptionPanel = new JPanel();
				addExceptionPanel.add(Box.createRigidArea(new Dimension(0,150)));
				try {
					if (titleField.getText().length() < 1) {
						throw new AddRemoveBookException.EmptyTitle();
					}
					if (authorField.getText().length() < 1) {
						throw new AddRemoveBookException.EmptyAuthor();
					}	
					
					library.addBook(new Book(titleField.getText(), authorField.getText()));
					addBookFrame.dispose();
					frame.dispose();
					new LibraryAdminCatalogMenu(library);
					
					
				} catch(AddRemoveBookException.EmptyTitle noTitle) {
					JLabel exceptionMessage = new JLabel(noTitle.getMessage());
					addExceptionPanel.add(exceptionMessage);
					addException.add(addExceptionPanel);
					addException.setVisible(true);
					LibraryGUI.openJFrames.add(addException);
				} catch(AddRemoveBookException.EmptyAuthor noAuthor) {
					JLabel exceptionMessage = new JLabel(noAuthor.getMessage());
					addExceptionPanel.add(exceptionMessage);
					addException.add(addExceptionPanel);
					addException.setVisible(true);
					LibraryGUI.openJFrames.add(addException);
				}
				
			}
			
		});

		
		addBookFrame.setVisible(true);
		LibraryGUI.openJFrames.add(addBookFrame);
		
		
	}
}
