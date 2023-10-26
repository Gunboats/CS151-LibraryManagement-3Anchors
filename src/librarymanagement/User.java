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
    User() {
        this.name = "John Doe";
        this.cardNumber = "SM-123456789";
        this.borrowedBooks = new ArrayList<Book>();
    }

    public void checkOut() {
    	// TODO should add a book for borrowedBooks,
    	// update borrowedBook to true
    }
    
    public void checkIn() {
    	// update book(s) to false...
    }
    public String getName() {
    	return this.name;
    }
    public String getCardNumber() {
    	return this.cardNumber;
    }
    
    public List<Book> getBorrowedBooks(){
        return BorrowedBooks;
    }

    public void borrowBook(Book book){
        BorrowedBooks.add(book);
    }

    public void returnBook(Book book){
        BorrowedBooks.remove(book);
    }
}
