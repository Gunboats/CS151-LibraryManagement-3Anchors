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
    public boolean containsNumber(String number) {
    	if(!phoneNumAndUserMap.containsKey(number)) {
    		return false;
    	}
    	return true;
    }
    
    public Map<String, User> getPhoneNumAndUserMap()  {
    	return phoneNumAndUserMap;
    }
    
    public void addUser(User user) {
    	if(!containsNumber(user.getPhoneNumber())) {
            userList.add(user);
            
            phoneNumAndUserMap.put(user.getPhoneNumber(), user);
            
            user.addCard(new LibraryCard(name, cardPrefix, (int) (Math.random() * 9000000) + 1000000));
            cardNumAndUserMap.put(user.getLibraryCard(cardPrefix).getFullCardID(), user);
    	}

    }

    public void removeUser(User user) {
        userList.remove(user);
        phoneNumAndUserMap.remove(user.getPhoneNumber());
        cardNumAndUserMap.remove(user.getLibraryCard(cardPrefix).getFullCardID());
        
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
            System.out.println("User: " + user.getName() + ",borrows book: " + book.getBookTitle() + ", Thank you for your support.");
        }
        return book;
    }
    public String getName() {
        return this.name;
    }
    public String getCardPrefix() {
    	return cardPrefix;
    }
    
}