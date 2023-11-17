package librarymanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// 10/24/23
// We may need to limit the amount of objects a user can check out
import java.util.Map;

public class User implements Comparable<User> {
    private String firstName;
    private String lastName;
    private List<LibraryCard> libraryCards;
    private Map<String, LibraryCard> passwordAndCards = new HashMap<String, LibraryCard>();
    private List<Book> borrowedBooks;
    private String phoneNumber;
    private String password;

    
    /**
     * Default constructor
     * Format for card number should probably indicate it is for a specific
     * library branch
     * We don't have to use an ArrayList for borrowed books
     */
    public User() {
        this.firstName = "John";
        this.lastName = "Doe";
        libraryCards = new ArrayList<LibraryCard>();
        this.borrowedBooks = new ArrayList<Book>();
        this.phoneNumber = "123456789";
        this.password = "asdfk";
    }

    /**
     * Constructor with parameters
     * @param name the user's name
     * @param cardNumber the card's ID
     */
    public User(String firstName, String lastName, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        libraryCards = new ArrayList<LibraryCard>();
        borrowedBooks = new ArrayList<Book>();
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    
    public void checkIn(Book book) {
    	// update book(s) to false...
 System.out.println(("User: " + this.firstName + " " + this.lastName + ", cards: " + getCardsAsString() + ", is checking book: " + book.getBookTitle()));
        if(borrowedBooks.contains(book)){
            borrowedBooks.remove(book);
             book.setBorrowed(false);
            System.out.println("return book: "+ book.getBookTitle() + ", Thank you for your support.");
        }
        else {
            System.out.println("you didn't borrow this book.");
        }

        
    }
    public String getFirstName() {
    	return this.firstName;
    }
    public String getLastName() {
    	return this.lastName;
    }
    public String getName() {
    	return firstName + " " + lastName;
    }
    
    public List<LibraryCard> getCards() {
    	List<LibraryCard> list = new ArrayList<LibraryCard>(libraryCards);
        return list;
    }

    public String getCardsAsString() {
        if (libraryCards.size() == 0) {
            return "";
        }
        String str = libraryCards.get(0).toString();
        for (int i = 1; i < libraryCards.size(); i++) {
            str += ", " + libraryCards.get(i).toString();
        }
        return str;
    }
    
    public List<Book> getBorrowedBooks(){
        return borrowedBooks;
    }

    public String getBooksAsString() {
        String str = "";
        for (Book book : borrowedBooks) {
            str += book.toString() + "\n";
        }
        return str;
    }
    
    public String getPhoneNumber() {
    	return this.phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void borrowBook(Book book){
        borrowedBooks.add(book);
    }

    public void returnBook(Book book){
        borrowedBooks.remove(book);
        book.setBorrowed(false);
    }
        //can be deleted if repeat the code above

    public void addCard(LibraryCard c) {
        libraryCards.add(c);
    }
    
    public boolean findLibraryCard(String libPrefix) {
    	for (LibraryCard card : libraryCards) {
    		if (card.getLibraryPrefix().equals(libPrefix)) {
    			return true;
    		} 
    	}
    	return false;
    }
    
    public LibraryCard getLibraryCard(String libPrefix) {
    	if(findLibraryCard(libPrefix)) {
    		for (LibraryCard card : libraryCards) {
        		if (card.getLibraryPrefix().equals(libPrefix)) {
        			return card;
        		} 
    		}
    	}
		return null;
    }
    
    @Override
    public int compareTo(User o) {
    	String name = this.getName();
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "User: " + getName() + ", cards: " + getCardsAsString() +
        "\nBooks: \n" + getBooksAsString(); 
    }
}
