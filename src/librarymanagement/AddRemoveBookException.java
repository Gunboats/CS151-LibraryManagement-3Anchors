package librarymanagement;

public class AddRemoveBookException extends Exception {
	public AddRemoveBookException(String error) {
		super(error);
	}
	
	public static class NoRemovedBooks extends AddRemoveBookException {

		public NoRemovedBooks() {
			super("Exception: No books selected for removal");
			// TODO Auto-generated constructor stub
		}
		

	}
	
	
	public static class RemovedBookIsBorrowed extends AddRemoveBookException {

		public RemovedBookIsBorrowed() {
			super("Exception: Cannot remove: This book is borrowed");
			
		}
		
	}
	
	public static class EmptyTitle extends AddRemoveBookException {

		public EmptyTitle() {
			super("Exception: No text in title");
			// TODO Auto-generated constructor stub
		}
		
	}
	
	public static class EmptyAuthor extends AddRemoveBookException {

		public EmptyAuthor() {
			super("Exception: No text in author");
			// TODO Auto-generated constructor stub
		}
		
	}
	
}
