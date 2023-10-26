package librarymanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashSet;

public class Library {
    private String name;
    
    // ArrayList for sorting books
    // Map for tracking quantity
    private List<Book> bookList = new ArrayList<Book>();
    private Map<Book, Integer> bookListMap = new HashMap<Book, Integer>();
    private HashSet<User> userList = new HashSet<User>();

    /**
     * Default constructor
     */
    public Library() {
        name = "Library";
    }

    /**
     * Parameterized constructor
     * @param name the library's name
     */
    public Library(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void removeBook(Book book) {
        bookList.remove(book);
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void removeUser(User user) {
        userList.remove(user);
    }

    public void displayBooks() {

    }

    public void displayUsers() {
        
    }
}