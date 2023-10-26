package librarymanagement;

public class LibraryCard {
    private String libraryPrefix;
    private int cardNumber;

    public LibraryCard(String prefix, int num) {
        libraryPrefix = prefix;
        cardNumber = num;
    }

    @Override
    public String toString() {
        return libraryPrefix + "-" + cardNumber;
    }
}