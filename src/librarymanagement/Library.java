package librarymanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private String name;
    
    // ArrayList for sorting books
    // Map for tracking quantity
    private List<Book> bookList = new ArrayList<Book>();
    private Map<Book, Integer> bookListMap = new HashMap<Book, Integer>();
    private List<User> userList = new ArrayList<User>();

    
}