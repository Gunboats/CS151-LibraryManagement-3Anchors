package librarymanagement;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private String cardPrefix;
    // ArrayList for sorting books
    // Map for tracking quantity
    private List<Book> bookList = new ArrayList<Book>();
    private List<User> userList = new ArrayList<User>();

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
    public Library(String name, String cardPrefix) {
        this.name = name;
        this.cardPrefix = cardPrefix;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void removeBook(Book book) {
        bookList.remove(book);
    }

    public void addUser(User user) {
        userList.add(user);
        user.addCard(new LibraryCard(name, cardPrefix, (int) (Math.random() * 90000) + 10000));
    }

    public void removeUser(User user) {
        userList.remove(user);
        
    }

    public void displayBooks() {
        bookList.sort(null);
        for (Book b : bookList) {
            System.out.println(b);
        }
    }

    public void displayUsers() {
        userList.sort(null);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    public Book checkOutBook(User user, String title) {
        int index = 0;
        while (index < bookList.size() && !bookList.get(index).getBookTitle().equals(title)) {
            index++;
        }
        if (index >= bookList.size()) {
            System.out.println("Book not found");
            return null;
        }
        Book book = bookList.remove(index);
        if (!book.getBorrowed()){
            user.borrowBook(book);
            book.setBorrowed(true);
            System.out.println("User: " + user.getName() + ",borrows book: " + book.getBookTitle() + ", Thank you for your shopping.");
        }
        return book;
    }
}