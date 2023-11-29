package librarymanagement;

public class Book implements Comparable<Book> {
    private String bookTitle;
    private String author;
    private int ISBN;
    private boolean borrowed;

    
    /**
     * Default constructor for a Book object
     * Books are not borrowed by default when created
     * 
     */
    Book() {
        this.bookTitle = "Book Name";
        this.author = "John Doe";
        this.ISBN = 1111111111;
        this.borrowed = false;
    }

    /**
     * Parameterized constructor for a Book object
     * By default, all books created are not borrowed, so
     * borrowed is set to false;
     * @param bookTitle Title of Book
     * @param author Author first and last name
     * @param ISBN A 10 digit long, basically a book ID number
     */
    Book(String bookTitle, String author) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.ISBN = (int) (Math.random() * 900000000) + 100000000;
        this.borrowed = false;
    }

    /**
     * Returns book title of object
     * @return book title
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * Returns the author of a book object
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the ISBN of a book
     * @return ISBN
     */
    public int getISBN() {
        return ISBN;
    }
    
    /**
     * Returns the status of a book's availability
     * @return true if borrowed, false if available
     */
    public boolean getBorrowed() {
        return borrowed;
    }

    /**
     * Setter that replaces old book title with a new
     * book title
     * @param newBookTitle The new book title of a book object
     */
    public void setBookTitle(String newBookTitle) {
    	this.bookTitle = newBookTitle;
    }
    
    /**
     * Setter replaces old author with new author
     * @param newAuthor The new author of a book object
     */
    public void setAuthor(String newAuthor) {
    	this.author = newAuthor;
    }
    
    /**
     * Setter for new ISBN of a book object
     * @param newISBN The new ISBN
     */
    public void setISBN(int newISBN) {
    	this.ISBN = newISBN;
    }
    

    /**
     * Updates the borrowed status of a Book object with
     * either true or false
     * @param borrowedStatus True or false
     */
    public void setBorrowed(boolean borrowedStatus) {
    	this.borrowed = borrowedStatus;
    }
    
    /**
     * Prints the contents of the Book object as a string
     */
    @Override
    public String toString() {
        return "Book Title: " + bookTitle + "\nAuthor: " + author + "\nISBN: "
        + ISBN + "\nBorrowed: " + borrowed;
    }

    /**
     * Was supposed to be used to compare books by book title order and sort
     * but not implemented due to lack of time
     */
    @Override
    public int compareTo(Book o) {
        return bookTitle.compareTo(o.bookTitle);
    }

}
