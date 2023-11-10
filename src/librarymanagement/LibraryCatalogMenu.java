package librarymanagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
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
	LibraryCatalogMenu(Library library, User user) {
		JFrame frame = new JFrame("Library Catalog");
		JPanel bookPanel = new JPanel();
		JScrollPane bookCatalog = new JScrollPane(bookPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		bookCatalog.getVerticalScrollBar().setUnitIncrement(15);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		ArrayList<Book> toBorrowList = new ArrayList<Book>();
		
		int length = library.getBookList().size()/2 + library.getBookList().size() %2 ;
		
		GridLayout panelLayout = new GridLayout(length, 4);
		JButton borrowBooks = new JButton("Borrow");
		borrowBooks.setSize(new Dimension(100,40));
		
		for(Book b: library.getBookList()) {
			JLabel label = new JLabel("<html>" + b.getBookTitle() + "<br/>" + 
		b.getAuthor() + "<br/>" + (b.getBorrowed() ? "Borrowed" : "Available") + "<html>");
			
			label.setSize(new Dimension(150,60));
			JCheckBox borrowCheckBox = new JCheckBox();
			borrowCheckBox.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
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
				// TODO Auto-generated method stub
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
				
					for (Book b: toBorrowList) {
//						ok actually borrow this time
						
						library.checkOutBook(user, b);
					}
					frame.dispose();
					
					// TO BE ADDED
					// show user's entire borrowed book list
					// admin login
					// admin remove and add users
					
					
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
					
				} catch(BorrowBook.CannotBorrow bookBorrowed) {
					JLabel exceptionMessage = new JLabel(bookBorrowed.getMessage());
					borrowFailPanel.add(exceptionMessage);
					borrowExceptionFrame.add(borrowFailPanel);
					borrowExceptionFrame.setVisible(true);
				}
				
			}
			
		});
		
		
		frame.add(bookCatalog);
		frame.add(borrowBooks, BorderLayout.SOUTH);
		frame.setSize(new Dimension(800,600));

		frame.setVisible(true);
	}
	

	
	
}
