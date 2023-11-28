package librarymanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private String name;
    private String cardPrefix;
    // ArrayList for sorting books
    // Map for tracking quantity
    private List<Book> bookList = new ArrayList<Book>();
    private List<User> userList = new ArrayList<User>();  
    private Map<String, User> cardNumAndUserMap = new HashMap<String, User>();
    private Map<String, User> phoneNumAndUserMap = new HashMap<String,User>();
    private String adminUsername = "admin";
    private String adminPassword = "password";
    /**
     * Default constructor
     * Libraries have lists for books and users
     * Maps for cards and users, phone numbers and users
     * default admin and password for admin logins
     */
    public Library() {
        name = "Library";
    }

    /**
     * Parameterized constructor
     * Libraries have lists for books and users
     * Maps for cards and users, phone numbers and users
     * default admin and password for admin logins, a card
     * prefix for all cards they assign to users
     * cardPrefix is used to assign the string prefix to a library
     * card Id as a way of being a unique identifier
     * @param name the library's name
     * @param cardPrefix the library card letters before numbers
     */
    public Library(String name, String cardPrefix) {
        this.name = name;
        this.cardPrefix = cardPrefix;
    }

    /**
     * Adds the book to the library's list of books
     * @param book The book being added
     */
    public void addBook(Book book) {
        bookList.add(book);
    }

    /**
     * Removes a book from a library's list of books
     * @param book The book being removed
     */
    public void removeBook(Book book) {
        bookList.remove(book);
    }
    
    /**
     * Checks if the phoneNumAndUserMap has the phone number
     * that a user entered when they tried signing up
     * Return 
     * @param number The phone number the user entered
     * @return True if number is used or false if not used
     */
    public boolean containsNumber(String number) {
    	if(!phoneNumAndUserMap.containsKey(number)) {
    		return false;
    	}
    	return true;
    }
    
    /**
     * Getter that returns the phone number and user map 
     * @return phoneNumAndUserMap
     */
    public Map<String, User> getPhoneNumAndUserMap()  {
    	return phoneNumAndUserMap;
    }
    
    
    /**
     * Adds a user to a library if the phone number is not already there
     * Then, it gives the user their library card, which has a string
     * to allow them to login, which is randomly generated with a 
     * random large number as part of the identifier
     * @param user The user being registered to the library
     */
    public void addUser(User user) {
    	if(!containsNumber(user.getPhoneNumber())) {
            userList.add(user);
            
            phoneNumAndUserMap.put(user.getPhoneNumber(), user);
            
            user.setCard(cardPrefix + "-" + ((int) (Math.random() * 9000000) + 1000000));
            cardNumAndUserMap.put(user.getLibraryCard(), user);
    	}

    }

    /**
     * Overloaded method that does not create a credit
     * card, mainly for writing to file so that it does
     * not recreate a new random library card
     * Checks if the user's number is not already added
     * If not, add it to the card and phone number hashmaps,
     * and add the user to the user list
     * @param user
     * @param f
     */
    public void addUser(User user, boolean f) {
    	if(!containsNumber(user.getPhoneNumber())) {
            userList.add(user);
            
            phoneNumAndUserMap.put(user.getPhoneNumber(), user);
            
            
            cardNumAndUserMap.put(user.getLibraryCard(), user);
    	}

    }


    /**
     * removes user from each of the lists and maps that store them
     * @param user The user being removed
     */
    public void removeUser(User user) {
        userList.remove(user);
        phoneNumAndUserMap.remove(user.getPhoneNumber());
        cardNumAndUserMap.remove(user.getLibraryCard());
        
    }

    
    /**
     * Prints the books in the library's bookList
     */
    public void displayBooks() {
        bookList.sort(null);
        for (Book b : bookList) {
            System.out.println(b);
        }
    }

    /**
     * Prints the users in the userList list
     */
    public void displayUsers() {
        userList.sort(null);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * Returns the book list of a library
     * @return bookList
     */
    public List<Book> getBookList() {
    	return bookList;
    }
    
    /**
     * Returns the user list of a library
     * @return userList
     */
    public List<User> getuserList() {
    	return userList;
    }
    
    
    
    /**
     * Assuming the book if not borrowed(false), users 
     * can check out the book, and they will receive the 
     * book in their book list, updating the book to now
     * be borrowed (true)
     * @param user The user trying to borrow a book
     * @param book The book being borrowed
     * @return Returns the book being borrowed
     */
    public Book checkOutBook(User user, Book book) {
        
        if (!book.getBorrowed()){
            user.borrowBook(book);
            book.setBorrowed(true);
            
        }
        return book;
    }
    
    /**
     * Gets the library's admin username
     * @return adminUsername
     */
    public String getAdminUsername() {
    	return adminUsername;
    }
    
    /**
     * Gets the library's admin password
     * @return adminPassword
     */
    public String getAdminPassword() {
    	return adminPassword;
    }
    
    /**
     * Gets the name of the library
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the cardPrefix of the library, an identifier
     * that is specific to a library's library cards to make 
     * them unique
     * @return cardPrefix
     */
    public String getCardPrefix() {
    	return cardPrefix;
    }
    
}