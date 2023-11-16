package librarymanagement;


import java.util.ArrayList;
import javax.swing.JFrame;

public class LibraryGUI {
	public static ArrayList<JFrame> openJFrames;
	
	public static void main(String[] args) {
	// The Class for displaying content
		openJFrames = new ArrayList<JFrame>();
		
		Library library = new Library("a", "a");
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		library.addBook(new Book());
		// write to file..
		library.addUser(new User("a", "a", "123123126"));
		library.addUser(new User("a", "a", "123123122"));
		library.addUser(new User("a", "a", "123123121"));
		library.addUser(new User("a", "a", "123123124"));
		library.addUser(new User("a", "a", "123123125"));
		LibraryLoginSignUpFrame loginScreen = new LibraryLoginSignUpFrame(library);
		
	}
	
	/**
	 * Closes the frames that were opened and added to the array list,
	 * and then empties the array list of open frames
	 */
	public static void closeJFrames() {
		for (JFrame j: openJFrames) {
			j.dispose();
		}
		
		openJFrames = new ArrayList<JFrame>();
	}
	
	
}
