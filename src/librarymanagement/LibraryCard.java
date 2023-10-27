package librarymanagement;

public class LibraryCard {
    private String libraryPrefix;
    private int cardNumber;
    private String libraryName;

    public LibraryCard(String libName, String prefix, int num) {
        libraryPrefix = prefix;
        libraryName = libName;
        cardNumber = num;
    }

    public String getLibraryPrefix() {
    	return libraryPrefix;
    }
    public int getCardNumber() {
    	return cardNumber;
    }
    public String getLibraryName() {
        return libraryName;
    }
    
    @Override
    public String toString() {
        return "Library: " + libraryName + ": " + libraryPrefix + "-" + cardNumber;
    }
}