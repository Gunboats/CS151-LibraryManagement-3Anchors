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

    private List<Book> borrowedBooks;
    private String phoneNumber;
    private String password;
    private String libraryCard;

    
    /**
     * Default constructor
     * Format for card number should probably indicate it is for a specific
     * library branch
     * We don't have to use an ArrayList for borrowed books
     */
    public User() {
        this.firstName = "John";
        this.lastName = "Doe";
 
        this.borrowedBooks = new ArrayList<Book>();
        this.phoneNumber = "123456789";
    }

    /**
     * Constructor with parameters
     * @param name the user's name
     * @param cardNumber the card's ID
     */
    public User(String firstName, String lastName, String phoneNumber, String password, String libraryCard) {
        this.firstName = firstName;
        this.lastName = lastName;

        borrowedBooks = new ArrayList<Book>();
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.libraryCard = libraryCard;
    }

    public User(String firstName, String lastName, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;

        borrowedBooks = new ArrayList<Book>();
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.libraryCard = libraryCard;
    }
    
    public void checkIn(Book book) {
    	// update book(s) to false...
 System.out.println(("User: " + this.firstName + " " + this.lastName + ", card: " + getLibraryCard() + ", is checking book: " + book.getBookTitle()));
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
    


    public String getLibraryCard() {
        return libraryCard;
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

    public void setPassword(String newPass) {
        this.password = newPass;
    }

    public void borrowBook(Book book){
        borrowedBooks.add(book);
    }

    public void returnBook(Book book){
        borrowedBooks.remove(book);
        book.setBorrowed(false);
    }
        //can be deleted if repeat the code above

    public void setCard(String card) {
        libraryCard = card;
    }

    public void setUserBorrowedBookList(List<Book> list) {
        this.borrowedBooks = list;
    }
    

    

    
    @Override
    public int compareTo(User o) {
    	String name = this.getName();
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "User: " + getName() + ", cards: " + getLibraryCard() +
        "\nBooks: \n" + getBooksAsString(); 
    }
}
