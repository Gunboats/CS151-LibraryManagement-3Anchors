package librarymanagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.io.FileWriter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.Scanner;
import java.util.List;
import java.util.NoSuchElementException;

import org.json.*;

public class LibraryLoginSignUpFrame {
	private Library library;
	
	
	
	/**
	 * Constructor creates the main menu frame, which has the options of
	 * logging in, signing up, importing, exporting at a library, and exiting
	 * For each option, there is a respective button in the JFrame allowing
	 * users to perform those action
	 * @param lib The library being accessed
	 */
	LibraryLoginSignUpFrame(Library lib) {
		
		library = lib;
		
		// Frame for logging in and signing in 
		JFrame frame = new JFrame("Library Management System");
		frame.setSize(new Dimension(800, 600));
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelNorth = new JPanel();
		JLabel labelSystemName = new JLabel("Library Management system");
		JPanel panelCenter = new JPanel();
		JPanel panelWest = new JPanel();
		JPanel panelEast = new JPanel();
		JPanel panelSouth = new JPanel();
		JLabel labelLibName = new JLabel(lib.getName());
		
		JButton adminLogin = new JButton("Admin login");
		adminLogin.setAlignmentX(JButton.RIGHT_ALIGNMENT);
		// These panels dimensions are used to squash the components into place because
		// I don't know any other way with the default Java Swing layouts
		panelNorth.setPreferredSize(new Dimension(400,100));
		
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		panelCenter.add(Box.createVerticalGlue());
		panelCenter.add(Box.createHorizontalGlue());
		panelSouth.setPreferredSize(new Dimension(400,100));
		panelWest.setPreferredSize(new Dimension(100,400));
		panelEast.setPreferredSize(new Dimension(100,400));
				
		// Uncomment to see what the center panel covers
//		panelCenter.setBackground(Color.red);

		// makes font big and chooses font
		labelSystemName.setFont(new Font("Arial", Font.PLAIN, 20));;
		panelNorth.add(labelSystemName);
		labelLibName.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		labelLibName.setFont(new Font("Arial", Font.PLAIN, 20));
		panelCenter.add(labelLibName);
		
		panelSouth.add(adminLogin);

		JButton signUp = new JButton("Sign up");
		signUp.setAlignmentX(JButton.CENTER_ALIGNMENT);
		
		JButton login = new JButton("  Login ");	
		login.setAlignmentX(JButton.CENTER_ALIGNMENT);
		
		JButton exit = new JButton("Exit");
		exit.setAlignmentX(JFileChooser.CENTER_ALIGNMENT);
		
		// Creates a login window when the user presses the button
		
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EnterInformationFrame loginFrame = new EnterLoginFrame("Login", library, frame);
				
				if(loginFrame.getLogin()) {
					
					frame.dispose();
				}
			}
			
		});
		
		// signUp creates a new JFrame for the user to
		// enter their information
		signUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EnterSignUpFrame("Sign up", library, frame, false);
				
			}
			
		});
		
		
		adminLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EnterLoginAdminFrame("Admin login", library, frame);
				
			}
			
		});


		
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				exportLibrary(library, "lib\\library.json");
				System.exit(0);
			}
			
		});
		
		panelNorth.add(Box.createRigidArea(new Dimension(0,150)));
		
		panelCenter.add(Box.createRigidArea(new Dimension(100,20)));
		panelCenter.add(login);
		panelCenter.add(Box.createRigidArea(new Dimension(100,20)));
		panelCenter.add(signUp);
		panelCenter.add(Box.createRigidArea(new Dimension(100,20)));
		panelCenter.add(exit);
		panelCenter.add(Box.createVerticalGlue());
		panelCenter.add(Box.createHorizontalGlue());
		
		frame.add(panelSouth, BorderLayout.SOUTH);
		frame.add(panelWest, BorderLayout.WEST);
		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelCenter, BorderLayout.CENTER);
		frame.add(panelEast, BorderLayout.EAST);
		frame.setVisible(true);
	}
	
	
	/**
	 * A method that will create a library that loads stored data from a file and return it
	 * Uses org.json package to read JSON file data and create a library
	 * If the file is invalid, a popup will appear noting this, and this method will return the parameter library
	 * @param library the current library
	 * @param f a file with path leading to a data JSON file to read
	 * @return a library with the file data loaded, or the library passed as parameter if the file fails
	 */
	public static Library setLibrary(Library library, File f) {
		Library prevLibrary = library;

		try {
			JSONObject obj = new JSONObject(new String(Files.readAllBytes(f.toPath())));
			JSONArray books = obj.getJSONArray("books");
			JSONArray users = obj.getJSONArray("users");
			library = new Library(obj.getString("name"), obj.getString("prefix"));
			for (int i = 0; i < books.length(); i++) {
				JSONObject bookObj = books.getJSONObject(i);
				Book b = new Book(bookObj.getString("title"), bookObj.getString("author"));
				b.setISBN(bookObj.getInt("isbn"));
				library.addBook(b);
			}
			for (int i = 0; i < users.length(); i++) {
				JSONObject userObj = users.getJSONObject(i);
				User u = new User(userObj.getString("first_name"), userObj.getString("last_name"), userObj.getString("phone_number"), userObj.getString("password"), userObj.getString("libraryCard"));
				JSONArray borrowedBooks = userObj.getJSONArray("borrowed_books");
				for (int j = 0; j < borrowedBooks.length(); j++) {
					int bookISBN = borrowedBooks.getInt(j);
					List<Book> bookList = library.getBookList();
					boolean found = false;
					for (int k = 0; k < bookList.size(); k++) {
						Book b = bookList.get(k);
						if (!b.getBorrowed() && b.getISBN() == bookISBN) {
							library.checkOutBook(u, b);
							found = true;
							break;
						}
					}
					if (!found) {
						throw new JSONException("Invalid File");
					}
				}
				library.addUser(u, false);
			}
			// JOptionPane.showMessageDialog(null, "Library successfully imported.");
			return library;
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Invalid File");
			library = prevLibrary;
		}
		catch (JSONException e) {
			JOptionPane.showMessageDialog(null, "Invalid File");
			library = prevLibrary;
		}
		return prevLibrary;
	}
	
	/**
	 * A method to export a library to a new JSON file at a desired path
	 * Uses org.json package to store the library data in the JSON file in proper format for import
	 * @param library the library to export
	 * @param path the path of the file that should be created
	 */
	public static void exportLibrary(Library library, String path) {
		JSONObject libraryObj = new JSONObject();
		
		libraryObj.put("name", library.getName());
		libraryObj.put("prefix", library.getCardPrefix());
		JSONArray bookArray = new JSONArray();
		List<Book> bookList = library.getBookList();
		for (Book b : bookList) {
			JSONObject bookObj = new JSONObject();
			bookObj.put("title", b.getBookTitle());
			bookObj.put("author", b.getAuthor());
			bookObj.put("isbn", b.getISBN());
			bookArray.put(bookObj);
		}
		libraryObj.put("books", bookArray);
		
		JSONArray userArray = new JSONArray();
		List<User> userList = library.getuserList();
		for (User u : userList) {
			JSONObject userObj = new JSONObject();
			userObj.put("first_name", u.getFirstName());
			userObj.put("last_name", u.getLastName());
			userObj.put("phone_number", u.getPhoneNumber());
			userObj.put("password", u.getPassword());
			userObj.put("libraryCard", u.getLibraryCard());
			JSONArray borrowedBooksList = new JSONArray();
			for (Book b : u.getBorrowedBooks()) {
				borrowedBooksList.put(b.getISBN());
			}
			userObj.put("borrowed_books", borrowedBooksList);
			
			userArray.put(userObj);
		}
		libraryObj.put("users", userArray);
		
		try {
			FileWriter writer = new FileWriter(path);
			writer.write(libraryObj.toString());
			writer.close();
			// JOptionPane.showMessageDialog(null, "Library successfully exported.");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Invalid Location");
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null, "Library Error");
		}
	}
}

class InvalidFileException extends Exception {
}
