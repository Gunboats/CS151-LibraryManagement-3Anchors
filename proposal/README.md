# CS151-LibraryManagement-3Anchors

Project title: CS151-LibraryManagement-3Anchors

Team: 3 Anchors

Team Members: Willy Tang, Alexander Pham, Yelin Wu

## Problem to solve
We have a series of libraries that lack a digital system for users to use and store important data such as the books in their catalog and the users that are registered with the library. We want to create a library management system that manages a library’s digital catalog of books and users with their respective information such as borrowed books, their name, and their library card number. This library management system should have a GUI that is intuitive and not difficult to use. Libraries and users need to be able to login to use their respective privileges. This requires us to uniquely identify each user to each library.

## Assumptions
The project of a Library management system will run on Java and the interactable interface will be implemented using Java Swing to create a GUI. Users will be able to interact with the library, being able to use functions like borrow books. Libraries can manage users and books in their system. Both libraries and users should be able to interact with the GUI by performing actions like clicking on buttons.

## High level description of the solution
Our plan is to first create separate classes of library, book, and user, where each will be created and used as objects. Before creating the GUI, we would create a series of tests, test these three classes, and make sure that they work properly with each of the test cases with proper exception handling. Later on, with Java Swing, we can make a GUI that allows for performing actions with components like pressing buttons inside a window when the program runs. Using the GUI, we would make a user able to use the library’s operations from a visually understandable interface. There will be a way for users and libraries to login with their information. We then plan to implement a save and load function for the library’s data.

## Functionality
* The project will store the data of a library in a file to keep track of books, users, and update if there are any changes to it.
* Data can be loaded, providing access to a library, their users, and their books.
* Users will be able to borrow books, check borrowed books, and look through the library’s catalog (without being able to modify it directly except through checking out or returning).
* Libraries can manage their users and books by removing and adding them.
* The system will have functions to manage user’s borrowing fees.
* There will be a login system with different levels of access for libraries and users.

## Operations

### Library
* contains a constructor to create a library object with a name of a library and a data structure to store users registered with the library and books in the library’s catalog
* addBook: A library can add a new book to their library catalog
* removeBook: A library can remove a book from their list of books they have
* addUser: User is registered into a library’s database, with their name, a library card number, and borrowed books
* removeUser: User is removed from the library’s database, deleting information about their name, library card number, borrowed books
checkOut/returnBook: takes User and Book as parameter; allows user to check out or return a book, modifying the library catalog accordingly while hiding this data from the user (so user can’t just access the catalog directly)
* displayBooks: Displays the list of books a library has
* displayUsers: displayers the users of a library
* loadLibrary: static; reads a file passed as parameter and creates a Library object with the file’s specifications
* exportLibrary: takes a file passed as parameter and overwrites it with the current Library’s data

### User
* Constructor creates a user object with a name, list of books they borrowed, and their library card number
* checkOut: A user may borrow a book, which will be added to a data structure that stores the books the user is currently borrowing
* checkIn: A user may return their book(s), removing them from the list of books the user has borrowed.

### Book
* constructor creates a book with data of book title, isbn number, if it is borrowed or not, author
* toString: Prints a book’s title, author, isbn number, if it is borrowed or not

