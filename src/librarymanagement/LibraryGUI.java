package librarymanagement;


import java.io.File;
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
		library.addUser(new User("a", "a", "123123126", "asfd", "SJ-1232321"));
		library.addUser(new User("a", "a", "123123122", " askbw"));
		library.addUser(new User("a", "a", "123123121", "anjwk"));
		library.addUser(new User("a", "a", "123123124", " ans"));
		library.addUser(new User("a", "a", "123123125", " wan"));

		library = LibraryLoginSignUpFrame.setLibrary(library, new File("lib\\library.json"));
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
