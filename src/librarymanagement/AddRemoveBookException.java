package librarymanagement;

/**
 * File contains all exceptions related to adding and removing a
 * book (occurs when admin tries to add and remove books)
 */
public class AddRemoveBookException extends Exception {
	public AddRemoveBookException(String error) {
		super(error);
	}
	/**
	 * Created when admin tries to remove a book, but none are selected
	 * for removal
	 */
	public static class NoRemovedBooks extends AddRemoveBookException {

		public NoRemovedBooks() {
			super("Exception: No books selected for removal");
		}
		

	}
	
	/**
	 * Created and used when admin tries to remove a book that is borrowed
	 * (we want the book still before we can officially remove it from the catalog)
	 */
	public static class RemovedBookIsBorrowed extends AddRemoveBookException {

		public RemovedBookIsBorrowed() {
			super("Exception: Cannot remove: This book is borrowed");
			
		}
		
	}
	
	/**
	 * Created and used when admin tries adding a book without a
	 * title
	 */
	public static class EmptyTitle extends AddRemoveBookException {

		public EmptyTitle() {
			super("Exception: No text in title");
		}
		
	}
	
	/**
	 * Created and used when admin tried adding a book without an
	 * author attached to the book
	 */
	public static class EmptyAuthor extends AddRemoveBookException {

		public EmptyAuthor() {
			super("Exception: No text in author");
		}
		
	}
	
}
