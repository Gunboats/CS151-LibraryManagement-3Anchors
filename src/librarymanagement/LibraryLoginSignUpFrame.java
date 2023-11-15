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
	
	LibraryLoginSignUpFrame(Library lib) {
		library = lib;
		// Frame for logging in and signing in 
		JFrame frame = new JFrame("Library Management System");
		frame.setSize(new Dimension(800, 600));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelNorth = new JPanel();
		JLabel labelSystemName = new JLabel("Library Management system");
		JPanel panelCenter = new JPanel();
		JPanel panelWest = new JPanel();
		JPanel panelEast = new JPanel();
		JPanel panelSouth = new JPanel();
		JLabel labelLibName = new JLabel("Library Name");
		
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
		
		JButton importButton = new JButton("Import");
		importButton.setAlignmentX(JFileChooser.CENTER_ALIGNMENT);

		JButton exportButton = new JButton("Export");
		exportButton.setAlignmentX(JFileChooser.CENTER_ALIGNMENT);
		
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

		importButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					setLibrary(file);
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
					exportLibrary(file);
				}
			}
		});
		
		panelNorth.add(Box.createRigidArea(new Dimension(0,150)));
		
		panelCenter.add(Box.createRigidArea(new Dimension(100,20)));
		panelCenter.add(login);
		panelCenter.add(Box.createRigidArea(new Dimension(100,20)));
		panelCenter.add(signUp);
		panelCenter.add(Box.createRigidArea(new Dimension(100,20)));
		panelCenter.add(importButton);
		panelCenter.add(Box.createRigidArea(new Dimension(100,20)));
		panelCenter.add(exportButton);
		panelCenter.add(Box.createVerticalGlue());
		panelCenter.add(Box.createHorizontalGlue());
		
		frame.add(panelSouth, BorderLayout.SOUTH);
		frame.add(panelWest, BorderLayout.WEST);
		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelCenter, BorderLayout.CENTER);
		frame.add(panelEast, BorderLayout.EAST);
		frame.setVisible(true);
	}
	
	public void setLibrary(File f) {
		Library prevLibrary = library;
		try {
			JSONObject obj = new JSONObject(new String(Files.readAllBytes(f.toPath())));
			JSONArray books = obj.getJSONArray("books");
			JSONArray users = obj.getJSONArray("users");
			library = new Library(obj.getString("name"), obj.getString("prefix"));
			for (int i = 0; i < books.length(); i++) {
				JSONObject bookObj = books.getJSONObject(i);
				Book b = new Book(bookObj.getString("title"), bookObj.getString("author"));
				library.addBook(b);
			}
			for (int i = 0; i < users.length(); i++) {
				JSONObject userObj = users.getJSONObject(i);
				User u = new User(userObj.getString("first_name"), userObj.getString("last_name"), userObj.getString("phone_number"));
				library.addUser(u);
			}
			JOptionPane.showMessageDialog(null, "Library successfully imported.");
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Invalid File");
			library = prevLibrary;
		}
		catch (JSONException e) {
			JOptionPane.showMessageDialog(null, "Invalid File");
			library = prevLibrary;
		}
	}
	
	public void exportLibrary(File dir) {
		String path = dir.getPath() + "\\" + library.getName() + ".json";
		JSONObject libraryObj = new JSONObject();
		
		libraryObj.put("name", library.getName());
		libraryObj.put("prefix", library.getCardPrefix());
		JSONArray bookArray = new JSONArray();
		List<Book> bookList = library.getBookList();
		for (Book b : bookList) {
			JSONObject bookObj = new JSONObject();
			bookObj.put("title", b.getBookTitle());
			bookObj.put("author", b.getAuthor());
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
			userArray.put(userObj);
		}
		libraryObj.put("users", userArray);
		
		try {
			FileWriter writer = new FileWriter(path);
			writer.write(libraryObj.toString());
			writer.close();
			JOptionPane.showMessageDialog(null, "Library successfully exported.");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Invalid Location");
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null, "Library Error");
		}
	}
}

class InvalidFileException extends Exception {
}
