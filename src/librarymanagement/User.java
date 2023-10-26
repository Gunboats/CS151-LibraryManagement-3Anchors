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

    public void checkOut(Book book) {
    	// TODO should add a book for borrowedBooks,
    	// update borrowedBook to true

        if (!book.isBorrowed()){
            borrowedBooks.add(book);
            book.setBorrowed(true);
            System.out.println("User: " + name + ",borrows book: " + book.getBookTitle());
        }
        else {
            System.out.println( "The book has been borrowed");
    }
    }
    
    public void checkIn(Book book) {
    	// update book(s) to false...

        if(borrowedBooks.contains(book)){
            borrowedBooks.remove(book);
             book.setBorrowed(false);
            System.out.println(("User: " + name + ", cardNumber: " + cardNumber + ",return book: "+ book.getBookTitle() + ", Thank you for your shopping.");
        }
        else {
            System.out.println(("User: " + name + ", cardNumber: " + cardNumber);
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
