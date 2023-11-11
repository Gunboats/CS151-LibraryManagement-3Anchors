package librarymanagement;

public class BorrowBook extends Exception {
	BorrowBook(String error) {
			super(error);
	}
	
	
	public static class CannotBorrow extends BorrowBook {

		CannotBorrow() {
			super("A book trying to be checked out is already borrowed");
			// TODO Auto-generated constructor stub
		}
		
	}
	
	public static class NoBorrowedBooks extends BorrowBook {

		NoBorrowedBooks() {
			super("Exception: No books were borrowed");
			// TODO Auto-generated constructor stub
		}
		
	}
}
