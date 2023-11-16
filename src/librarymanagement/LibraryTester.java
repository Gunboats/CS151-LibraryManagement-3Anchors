package librarymanagement;

public class LibraryTester {
    public static void main(String[] args) {
        Library library = new Library("San Jose", "SJ");
        library.addBook(new Book("Book", "?"));
        User u = new User("test", "user", "4085125333");
        library.addUser(u);
        library.displayBooks();
        System.out.println("-----");
        library.displayUsers();
        System.out.println("-----");
//        library.checkOutBook(u, "Book");
        System.out.println("-----");
        library.displayBooks();
        System.out.println("-----");
        library.displayUsers();
    }
}
