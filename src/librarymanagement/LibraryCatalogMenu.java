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

public class LibraryCatalogMenu {
	
	/**
	 * Creates the library catalog for users, allowing them
	 * to borrow books, and access their borrowed books list,
	 * and then logout, returning them to the main menu
	 * Users select check boxes to choose which books to borrow
	 * but they are prevented from borrowing already borrowed books
	 * Successful borrowing will tell users what they borrowed, but
	 * unsuccessful borrowing will give a popup
	 * @param library
	 * @param user
	 */
	LibraryCatalogMenu(Library library, User user) {
		JFrame frame = new JFrame("Library Catalog");
		JPanel bookPanel = new JPanel();
		JScrollPane bookCatalog = new JScrollPane(bookPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		bookCatalog.getVerticalScrollBar().setUnitIncrement(15);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		bookPanel.setPreferredSize(new Dimension(400,600));
		
		
		ArrayList<Book> toBorrowList = new ArrayList<Book>();
		
		
		JPanel southPanel = new JPanel();
		
		
		FlowLayout panelLayout = new FlowLayout(FlowLayout.LEFT, 25, 5);
		bookPanel.setLayout(panelLayout);
		JButton borrowBooks = new JButton("Borrow");
		
		
		JButton booksBorrowed = new JButton("Books Borrowed");
		JButton logout = new JButton("Logout");
		
		
		southPanel.add(borrowBooks);
		southPanel.add(booksBorrowed);
		southPanel.add(logout);
		
		for(Book b: library.getBookList()) {
			JLabel label = new JLabel("<html>" + b.getBookTitle() + "<br/>" + 
		b.getAuthor() + "<br/>" + (b.getBorrowed() ? "Borrowed" : "Available") + "<html>");
			
			label.setSize(new Dimension(180,60));
			JCheckBox borrowCheckBox = new JCheckBox();
			borrowCheckBox.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == 1) {
						toBorrowList.add(b);
					} else {
						toBorrowList.remove(b);
					}
				}
			});
						
			bookPanel.add(label);
			bookPanel.add(borrowCheckBox);

		}
		
		borrowBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame borrowExceptionFrame = new JFrame("Borrow exception");
				JPanel borrowFailPanel = new JPanel();
				borrowFailPanel.add(Box.createRigidArea(new Dimension(0,150)));
				borrowExceptionFrame.setSize(new Dimension(600,200));
				
				try {
					for (Book b: toBorrowList) {
						if (b.getBorrowed()) {
							throw new BorrowBook.CannotBorrow();
						} 
					}
				
					if(toBorrowList.isEmpty()) {
						throw new BorrowBook.NoBorrowedBooks();
					}

					if(toBorrowList.size() > 0) {
						for (Book b: toBorrowList) {
							if(!user.getBorrowedBooks().isEmpty()) {
								for(Book c: user.getBorrowedBooks()) {
									if (b.getAuthor().equals(c.getAuthor()) && b.getBookTitle().equals(c.getBookTitle())) {
										throw new BorrowBook.BookBorrowedAlready();
									}
								}
							}


						}
					}

					if(toBorrowList.size() > 0) {
						for(int i = 0; i < toBorrowList.size(); i++) {
							for (int j = 1; j < toBorrowList.size(); j++) {
								if (toBorrowList.get(i).getAuthor().equals(toBorrowList.get(j).getAuthor())) {
									if (toBorrowList.get(i).getBookTitle().equals(toBorrowList.get(j).getBookTitle())) {
										throw new BorrowBook.BorrowingDuplicates();
									}
								}
							}
						}
					}


					for (Book b: toBorrowList) {
//						This loop will borrow the books
						
						library.checkOutBook(user, b);
					}



					frame.dispose();
					new LibraryCatalogMenu(library, user);
					
					JFrame thanksFrame = new JFrame("Thank you");
					
					thanksFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					thanksFrame.setSize(new Dimension(800,600));
					JPanel thanksPanel = new JPanel();
					
					
					thanksPanel.setLayout(new BoxLayout(thanksPanel, BoxLayout.Y_AXIS));
					thanksPanel.add(Box.createRigidArea(new Dimension(0,150)));
					JLabel thanksLabel = new JLabel("Thank you for the support!");
					JLabel youBorrowed = new JLabel("You borrowed: ");
					youBorrowed.setAlignmentX(JLabel.CENTER_ALIGNMENT);
					thanksPanel.add(youBorrowed);
					for (Book b: toBorrowList) {
						
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
					
				} catch(BorrowBook.CannotBorrow bookBorrowed) {
					JLabel exceptionMessage = new JLabel(bookBorrowed.getMessage());
					borrowFailPanel.add(exceptionMessage);
					borrowExceptionFrame.add(borrowFailPanel);
					borrowExceptionFrame.setVisible(true);
					LibraryGUI.openJFrames.add(borrowExceptionFrame);
				} catch (BorrowBook.NoBorrowedBooks noBooks) {
					JLabel exceptionMessage = new JLabel(noBooks.getMessage());
					borrowFailPanel.add(exceptionMessage);
					borrowExceptionFrame.add(borrowFailPanel);
					borrowExceptionFrame.setVisible(true);
					LibraryGUI.openJFrames.add(borrowExceptionFrame);
				} catch (BorrowBook.BookBorrowedAlready borrowedAlready) {
					JLabel exceptionMessage = new JLabel(borrowedAlready.getMessage());
					borrowFailPanel.add(exceptionMessage);
					borrowExceptionFrame.add(borrowFailPanel);
					borrowExceptionFrame.setVisible(true);
					LibraryGUI.openJFrames.add(borrowExceptionFrame);
				} catch (BorrowBook.BorrowingDuplicates duplicateBorrowing) {
					JLabel exceptionMessage = new JLabel(duplicateBorrowing.getMessage());
					borrowFailPanel.add(exceptionMessage);
					borrowExceptionFrame.add(borrowFailPanel);
					borrowExceptionFrame.setVisible(true);
					LibraryGUI.openJFrames.add(borrowExceptionFrame);
				}
				
			}
			
		});
		
		booksBorrowed.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new LibraryBorrowedBooksMenu(user, frame, library);
				
			}
			
		});
		
		logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LibraryGUI.closeJFrames();
				new LibraryLoginSignUpFrame(library);
			}
			
		});
		
		frame.add(bookCatalog, BorderLayout.CENTER);
		frame.add(southPanel, BorderLayout.SOUTH);
		frame.setSize(new Dimension(800,600));
		LibraryGUI.openJFrames.add(frame);
		frame.setVisible(true);
	}
	

	
	
}
