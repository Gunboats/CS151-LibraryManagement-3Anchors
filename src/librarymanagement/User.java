package librarymanagement;

import java.util.ArrayList;
import java.util.List;
// 10/24/23
// We may need to limit the amount of objects a user can check out

public class User implements Comparable<User> {
    private String name;
    private List<LibraryCard> libraryCards;
    private List<Book> borrowedBooks;

    
    /**
     * Default constructor
     * Format for card number should probably indicate it is for a specific
     * library branch
     * We don't have to use an ArrayList for borrowed books
     */
    public User() {
        this.name = "John Doe";
        libraryCards = new ArrayList<LibraryCard>();
        this.borrowedBooks = new ArrayList<Book>();
    }

    /**
     * Constructor with parameters
     * @param name the user's name
     * @param cardNumber the card's ID
     */
    public User(String name) {
        this.name = name;
        libraryCards = new ArrayList<LibraryCard>();
        borrowedBooks = new ArrayList<Book>();
    }

    public void checkOut(Book book) {
    	// TODO should add a book for borrowedBooks,
    	// update borrowedBook to true

        
    }
    
    public void checkIn(Book book) {
    	// update book(s) to false...
 System.out.println(("User: " + name + ", cards: " + getCardsAsString() + ", is checking book: " + book.getBookTitle()));
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

    public void borrowBook(Book book){
        borrowedBooks.add(book);
    }

    public void returnBook(Book book){
        borrowedBooks.remove(book);
    }
        //can be deleted if repeat the code above

    public void addCard(LibraryCard c) {
        libraryCards.add(c);
    }

    @Override
    public int compareTo(User o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "User: " + name + ", cards: " + getCardsAsString() +
        "\nBooks: \n" + getBooksAsString(); 
    }
}
