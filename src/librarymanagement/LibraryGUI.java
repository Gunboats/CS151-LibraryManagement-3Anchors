package librarymanagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LibraryGUI {
	
	
	public static void main(String[] args) {
	// The Window for displaying content
		
		Library library = new Library("a", "a");
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		// write to file..
		library.addUser(new User("a", "a", "123123126"));
		library.addUser(new User("a", "a", "123123122"));
		library.addUser(new User("a", "a", "123123121"));
		library.addUser(new User("a", "a", "123123124"));
		library.addUser(new User("a", "a", "123123125"));
		LibraryLoginSignUpFrame loginScreen = new LibraryLoginSignUpFrame(library);
		
	}
}
