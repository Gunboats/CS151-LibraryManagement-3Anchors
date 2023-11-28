package librarymanagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LibraryBorrowedBooksMenu {
	JFrame frame = new JFrame("Borrowed Books");
	/**
	 * Creates JFrame showing the User's borrowed books
	 * Users can click on check boxes and then press
	 * the return button to return books back to the 
	 * library
	 * @param user
	 */
	LibraryBorrowedBooksMenu(User user, JFrame catalogFrame, Library library) {
		
		JPanel bookPanel = new JPanel();
		JScrollPane bookCatalog = new JScrollPane(bookPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		bookCatalog.getVerticalScrollBar().setUnitIncrement(15);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		bookPanel.setPreferredSize(new Dimension(400,600));
		
		
		
		ArrayList<Book> borrowedBookList = new ArrayList<Book>();
		
		JPanel northPanel = new JPanel();
		northPanel.add(new JLabel("Borrowed Books"));
		
		JPanel southPanel = new JPanel();
		JButton returnBooks = new JButton("Return books");
		
		FlowLayout panelLayout = new FlowLayout(FlowLayout.LEFT, 25, 5);
		bookPanel.setLayout(panelLayout);
		
		for(Book b: user.getBorrowedBooks()) {
			JLabel label = new JLabel("<html>" + b.getBookTitle() + "<br/>" + 
		b.getAuthor() + "<br/>" + (b.getBorrowed() ? "Borrowed" : "Available") + "<html>");
			label.setSize(new Dimension(180,60));
			JCheckBox borrowCheckBox = new JCheckBox();
			borrowCheckBox.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == 1) {
						borrowedBookList.add(b);
					} else {
						borrowedBookList.remove(b);
					}
				}
			});
			bookPanel.add(label);
			bookPanel.add(borrowCheckBox);
		}
		
		
		returnBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame returnExceptionFrame = new JFrame("Return exception");
				JPanel returnFailPanel = new JPanel();
				returnFailPanel.add(Box.createRigidArea(new Dimension(0,150)));
				returnExceptionFrame.setSize(new Dimension(600,200));
				
				try {
				
					if(borrowedBookList.isEmpty()) {
						throw new BorrowBook.NoBorrowedBooksReturned();
					}
					
					for (Book b: borrowedBookList) {
						user.returnBook(b);
					}
					frame.dispose();
					catalogFrame.dispose();
					new LibraryBorrowedBooksMenu(user, catalogFrame, library);
					new LibraryCatalogMenu(library, user);
					LibraryLoginSignUpFrame.exportLibrary(library, "lib\\library.json");
					JFrame thanksFrame = new JFrame("Thank you");
					thanksFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					thanksFrame.setSize(new Dimension(800,600));
					JPanel thanksPanel = new JPanel();
					
					
					thanksPanel.setLayout(new BoxLayout(thanksPanel, BoxLayout.Y_AXIS));
					thanksPanel.add(Box.createRigidArea(new Dimension(0,150)));
					JLabel thanksLabel = new JLabel("Thank you for the support!");
					JLabel youBorrowed = new JLabel("You returned: ");
					youBorrowed.setAlignmentX(JLabel.CENTER_ALIGNMENT);
					thanksPanel.add(youBorrowed);
					for (Book b: borrowedBookList) {
						
						JLabel bookLabel = new JLabel(b.getBookTitle() + " by " + 
								b.getAuthor());
						bookLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
						thanksPanel.add(bookLabel);
					}
					
					thanksLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
					thanksPanel.add(thanksLabel);
					thanksFrame.add(thanksPanel);
					thanksFrame.setVisible(true);
					LibraryGUI.openJFrames.add(thanksFrame);
					
				} catch (BorrowBook.NoBorrowedBooksReturned noBooks) {
					JLabel exceptionMessage = new JLabel(noBooks.getMessage());
					returnFailPanel.add(exceptionMessage);
					returnExceptionFrame.add(returnFailPanel);
					returnExceptionFrame.setVisible(true);
					LibraryGUI.openJFrames.add(returnExceptionFrame);
				}
			}
			
		});
		
		southPanel.add(returnBooks);
		frame.add(bookCatalog, BorderLayout.CENTER);
		frame.add(southPanel, BorderLayout.SOUTH);
		frame.add(northPanel, BorderLayout.NORTH);
		frame.setSize(new Dimension(800,600));
		LibraryGUI.openJFrames.add(frame);
		frame.setVisible(true);
		
		
		
	}
	
	public JFrame getJFrame() {
		return frame;
	}
	
	
}
