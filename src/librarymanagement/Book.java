package librarymanagement;

public class Book {
    private String bookTitle;
    private String author;
    private long ISBN;
    private boolean borrowed;

    Book() {
        this.bookTitle = "Default Book Name";
        this.author = "John Doe";
        this.ISBN = 1111111111111;
        this.borrowed = false;
    }

    
    Book(String bookTitle, String author, long ISBN) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.ISBN = ISBN;
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


    @Override
    public String toString() {
        return "Book Title: " + bookTitle + "\nAuthor: " + author + "\nISBN: "
        + ISBN + "\nBorrowed: " + borrowed;
    }


}
