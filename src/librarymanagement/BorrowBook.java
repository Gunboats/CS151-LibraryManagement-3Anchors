package librarymanagement;

/**
 * Exceptions that occur when users try to borrow a book
 * and also return books
 */
public class BorrowBook extends Exception {
	BorrowBook(String error) {
			super(error);
	}
	
	/**
	 * Created and used when user tries to borrow a book
	 * that is already borrowed
	 */
	public static class CannotBorrow extends BorrowBook {

		CannotBorrow() {
			super("A book trying to be checked out is already borrowed");
			
		}
		
	}
	
	/**
	 * Created and used when the user does not select any
	 * books with checkboxes and presses borrow button
	 */
	public static class NoBorrowedBooks extends BorrowBook {

		NoBorrowedBooks() {
			super("Exception: No books were borrowed");
			
		}
		
	}
	
	/**
	 * Created and used when the user did not select any books to
	 * return with a check box
	 */
	public static class NoBorrowedBooksReturned extends BorrowBook {

		NoBorrowedBooksReturned() {
			super("Exception: No books borrowed were returned");
			
		}
		
	}

	/**
	 * Created and used when the user tries to borrow a book
	 * that is in their list of borrowed books
	 */
	public static class BookBorrowedAlready extends BorrowBook {

		BookBorrowedAlready() {
			super("Exception: You have already borrowed this book");
		}
		
	}

	/**
	 * Created and used when user tries borrowing 2 books with
	 * the same exact title and author, assuming that upper and 
	 * lower cases matter
	 */
	public static class BorrowingDuplicates extends BorrowBook {

		BorrowingDuplicates() {
			super("Exception: Borrowing duplicate books");
		}
		
	}
}
