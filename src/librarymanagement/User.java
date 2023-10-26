package librarymanagement;

import java.util.ArrayList;
import java.util.List;
// 10/24/23
// We may need to limit the amount of objects a user can check out

public class User {
    private String name;
    private String cardNumber;
    private List<Book> borrowedBooks;

    
    /**
     * Default constructor
     * Format for card number should probably indicate it is for a specific
     * library branch
     * We don't have to use an ArrayList for borrowed books
     */
    public User() {
        this.name = "John Doe";
        this.cardNumber = "SM-123456789";
        this.borrowedBooks = new ArrayList<Book>();
    }

    /**
     * Constructor with parameters
     * @param name the user's name
     * @param cardNumber the card's ID
     */
    public User(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
        borrowedBooks = new ArrayList<Book>();
    }

    public void checkOut(Book book) {
    	// TODO should add a book for borrowedBooks,
    	// update borrowedBook to true

        if (!book.getBorrowed()){
            borrowedBooks.add(book);
            book.setBorrowed(true);
            System.out.println("User: " + name + ",borrows book: " + book.getBookTitle() + ", Thank you for your shopping.");
        }
        else {
            System.out.println( "The book has been borrowed");
    }
    }
    
    public void checkIn(Book book) {
    	// update book(s) to false...
 System.out.println(("User: " + name + ", cardNumber: " + cardNumber + ", is checking book: " + book.getBookTitle()));
        if(borrowedBooks.contains(book)){
            borrowedBooks.remove(book);
             book.setBorrowed(false);
            System.out.println("return book: "+ book.getBookTitle() + ", Thank you for your shopping.");
        }
        else {
            System.out.println("you didn't borrow this book.");
        }

        
    }
    public String getName() {
    	return this.name;
    }
    public String getCardNumber() {
    	return this.cardNumber;
    }
    
/*    public List<Book> getBorrowedBooks(){
        return borrowedBooks;
    }

    public void borrowBook(Book book){
        borrowedBooks.add(book);
    }

    public void returnBook(Book book){
        borrowedBooks.remove(book);
    }  */ 
        //can be deleted if repeat the code above
}
