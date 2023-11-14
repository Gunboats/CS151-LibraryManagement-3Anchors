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

public class LibraryAdminCatalogMenu {
	LibraryAdminCatalogMenu(Library library) {
		JFrame frame = new JFrame("Library Catalog");
		JPanel bookPanel = new JPanel();
		JScrollPane bookCatalog = new JScrollPane(bookPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		bookCatalog.getVerticalScrollBar().setUnitIncrement(15);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		bookPanel.setPreferredSize(new Dimension(400,600));
		
		JPanel southPanel = new JPanel();
		
		ArrayList<Book> removeList = new ArrayList<Book>();
		
		FlowLayout panelLayout = new FlowLayout(FlowLayout.LEFT, 25, 5);
		bookPanel.setLayout(panelLayout);
		JButton removeBooks = new JButton("Remove");
		
		
		JButton addBook = new JButton("Add book");
		
		
		southPanel.add(removeBooks);
		southPanel.add(Box.createRigidArea(new Dimension(350,0)));
		southPanel.add(addBook);
		
		for(Book b: library.getBookList()) {
			JLabel label = new JLabel("<html>" + b.getBookTitle() + "<br/>" + 
		b.getAuthor() + "<br/>" + (b.getBorrowed() ? "Borrowed" : "Available") + "<html>");
			
			label.setSize(new Dimension(180,60));
			JCheckBox removeCheckBox = new JCheckBox();
			removeCheckBox.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					if(e.getStateChange() == 1) {
						removeList.add(b);
					} else {
						removeList.remove(b);
					}
				}
			});
			
			bookPanel.add(label);
			bookPanel.add(removeCheckBox);
		}
		
		removeBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame removeExceptionFrame = new JFrame("Remove book exception");
				JPanel removeFailPanel = new JPanel();
				removeFailPanel.add(Box.createRigidArea(new Dimension(0,150)));
				removeExceptionFrame.setSize(new Dimension(600,200));
				
				try {
					for (Book b: removeList) {
						if (b.getBorrowed()) {
							throw new AddRemoveBookException.RemovedBookIsBorrowed();
						} 
					}
				
					if(removeList.isEmpty()) {
						throw new AddRemoveBookException.NoRemovedBooks();
					}
					
					for (Book b: removeList) {
						
						library.removeBook(b);;
					}
					frame.dispose();
					new LibraryAdminCatalogMenu(library);
					// TO BE ADDED
					// show user's entire borrowed book list
					// admin remove and add users
					
					
					
					
				} catch(AddRemoveBookException.NoRemovedBooks noRemovedBook) {
					JLabel exceptionMessage = new JLabel(noRemovedBook.getMessage());
					removeFailPanel.add(exceptionMessage);
					removeExceptionFrame.add(removeFailPanel);
					removeExceptionFrame.setVisible(true);
				} catch (AddRemoveBookException.RemovedBookIsBorrowed bookBorrowed) {
					JLabel exceptionMessage = new JLabel(bookBorrowed.getMessage());
					removeFailPanel.add(exceptionMessage);
					removeExceptionFrame.add(removeFailPanel);
					removeExceptionFrame.setVisible(true);
				}
				
			}
			
		});
		
		addBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EnterBookFrame(library, frame);
				
			}
			
		});
		
		
		frame.add(bookCatalog, BorderLayout.CENTER);
		frame.add(southPanel, BorderLayout.SOUTH);
		frame.setSize(new Dimension(800,600));

		frame.setVisible(true);
	}
}
