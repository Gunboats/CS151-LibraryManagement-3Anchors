package librarymanagement;

public class Book {
    private String bookTitle;
    private String author;
    private int ISBN;
    private boolean borrowed;

    
    /**
     * Default constructor for a Book object
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
    Book(String bookTitle, String author, int ISBN) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.ISBN = ISBN;
        this.borrowed = false;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public long getISBN() {
        return ISBN;
    }
    
    public boolean getBorrowed() {
        return borrowed;
    }

    public void setBookTitle(String newBookTitle) {
    	this.bookTitle = newBookTitle;
    }
    
    public void setAuthor(String newAuthor) {
    	this.author = newAuthor;
    }
    
    public void setISBN(int newISBN) {
    	this.ISBN = newISBN;
    }
    
    public void setBorrowed(boolean borrowedStatus) {
    	this.borrowed = borrowedStatus;
    }
    
    @Override
    public String toString() {
        return "Book Title: " + bookTitle + "\nAuthor: " + author + "\nISBN: "
        + ISBN + "\nBorrowed: " + borrowed;
    }


}
