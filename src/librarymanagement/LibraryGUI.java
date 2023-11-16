package librarymanagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LibraryGUI {
    private Library library;

    public LibraryGUI(Library library) {
        this.library = library;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        // The main window
        JFrame frame = new JFrame("Library Management System");
        frame.setSize(new Dimension(400, 300));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel for displaying library information
        JPanel infoPanel = new JPanel();
        JLabel libraryNameLabel = new JLabel("Library Name: " + library.getName());
        JLabel cardPrefixLabel = new JLabel("Card Prefix: " + library.getCardPrefix());
        infoPanel.add(libraryNameLabel);
        infoPanel.add(cardPrefixLabel);

        // Panel for displaying buttons
        JPanel buttonPanel = new JPanel();
        JButton displayBooksButton = new JButton("Display Books");
        JButton displayUsersButton = new JButton("Display Users");
        JButton loginButton = new JButton("Login/Sign Up");

        // Add action listeners to buttons
        displayBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayBooks();
            }
        });

        displayUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayUsers();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoginSignUpFrame();
            }
        });

        buttonPanel.add(displayBooksButton);
        buttonPanel.add(displayUsersButton);
        buttonPanel.add(loginButton);

        // Add panels to the main frame
        frame.add(infoPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        // Display the frame
        frame.setVisible(true);
    }

    private void displayBooks() {
        // Create a new frame to display books
        JFrame booksFrame = new JFrame("Book List");
        booksFrame.setSize(new Dimension(400, 300));

        // Panel for displaying books
        JPanel booksPanel = new JPanel();
        booksPanel.setLayout(new BoxLayout(booksPanel, BoxLayout.Y_AXIS));

        for (Book book : library.getBookList()) {
            JLabel bookLabel = new JLabel(book.toString());
            booksPanel.add(bookLabel);
        }

        // Add the books panel to the frame
        booksFrame.add(booksPanel);

        // Display the frame
        booksFrame.setVisible(true);
    }

    private void displayUsers() {
        // Create a new frame to display users
        JFrame usersFrame = new JFrame("User List");
        usersFrame.setSize(new Dimension(400, 300));

        // Panel for displaying users
        JPanel usersPanel = new JPanel();
        usersPanel.setLayout(new BoxLayout(usersPanel, BoxLayout.Y_AXIS));

        for (User user : library.getUserList()) {
            JLabel userLabel = new JLabel(user.toString());
            usersPanel.add(userLabel);
        }

        // Add the users panel to the frame
        usersFrame.add(usersPanel);

        // Display the frame
        usersFrame.setVisible(true);
    }

    private void showLoginSignUpFrame() {
        // Display the login/signup frame
        new EnterInformationFrame("Login/Sign Up", true, library);
    }

    public static void main(String[] args) {
        // The Window for displaying content
        Library library = new Library("Library", "3Anchors");
        LibraryGUI libraryGUI = new LibraryGUI(library);
    }
}
