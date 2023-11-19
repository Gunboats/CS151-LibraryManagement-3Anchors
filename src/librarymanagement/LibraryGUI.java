package librarymanagement;


import java.util.ArrayList;
import javax.swing.JFrame;

public class LibraryGUI {
	public static ArrayList<JFrame> openJFrames = new ArrayList<JFrame>();
	
	public static void main(String[] args) {
	// The Class for displaying content
		
		
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
		library.addUser(new User("a", "a", "123123126", "asfd"));
		library.addUser(new User("a", "a", "123123122", " askbw"));
		library.addUser(new User("a", "a", "123123121", "anjwk"));
		library.addUser(new User("a", "a", "123123124", " ans"));
		library.addUser(new User("a", "a", "123123125", " wan"));
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
