package librarymanagement;

public class BorrowBook extends Exception {
	BorrowBook(String error) {
			super(error);
	}
	
	
	public static class CannotBorrow extends BorrowBook {

		CannotBorrow() {
			super("A book trying to be checked out is already borrowed");
			
		}
		
	}
	
	public static class NoBorrowedBooks extends BorrowBook {

		NoBorrowedBooks() {
			super("Exception: No books were borrowed");
			
		}
		
	}
	
	public static class NoBorrowedBooksReturned extends BorrowBook {

		NoBorrowedBooksReturned() {
			super("Exception: No books borrowed were returned");
			
		}
		
	}
}
