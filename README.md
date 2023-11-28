## Team: 3 Anchors
## Team members: Willy Tang, Alexander Pham, Yelin Wu
## Contributions to proposal
### Willy: Wrote to problem to solve, most of the functionality section, some operations for each class,
### some of the High level
### Alex: Added some of the high level description of the solution, operations for library, half of functions
### Yelin: Wrote in a separate document but was not really used much in the shared document final proposal 

## Contributions to UML Diagrams
### Willy: Did the Use Case, Sequence, and Class Diagram, updated Use Case diagram
### Alex: Did the State Diagram, gave feedback on the UML Diagrams
### Yelin: Updated class diagram and sequence diagram, did not contribute to initial UML Diagrams 

## Members working on Project Code:
### Willy: Managed github post-proposal creation. Created most exceptions for AddRemoveBookException, AddRemoveUserException, BorrowBook, SignUpException, LoginException. Worked on Library, User, Book. Contributed to EnterInformationFrame, LibraryLoginSignUpFrame, LibraryCatalogMenu, EnterLoginAdminFrame, EnterSignUpFrame, LibraryUserMenu, EnterBookFrame, Enter InformationFrame, LibraryBorrowedBooksMenu, the README.md inside the src folder with test cases you manually have to enter. Implemented exception handling, made most of the GUI's JFrames, popups, Bonus's user view and admin view. 
### Alex: Managed github during project proposal phase, transferred control to Willy after.
### Yelin: Contributed to Libray.java, User.java, LibrayLoginSignUpFrame.java(These were pushed the laurindaaa-patch branch. But it was overrided by the team's code and didn't merge into the final branch). Added the password format checker. Fixed the import path for library.json. Updated the libray.json data inclduing books data and user data. 

## Members working on Project Report:
### Problem/Issue: Problem to solve: We have a library that lack a digital system for users to use and store important data such as the books in their catalog and the users that are registered with the library. We want to create a library management system that manages a library’s digital catalog of books and users with their respective information such as borrowed books, their name, and their library card number. This library management system should have a GUI that is intuitive and not difficult to use. Libraries and users need to be able to login to use their respective privileges. This requires us to uniquely identify each user to each library.

### Assumptions / Operating Environments / Intended Usage: Assumptions: The project of a Library management system will run on Java and the interactable user interface will be implemented using Java Swing to create a GUI. Users will be able to interact with the library, being able to use functions like borrow books, return books. Libraries can manage users and books in their system, adding and removing them. Both libraries and users should be able to interact with the GUI by performing actions like clicking on buttons. The library will have the ability to save and load stored data.
### Previous works?
### Diagrams
# UML Diagrams
## UML Class Diagram
[UML Class Diagram](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/blob/Test-branch-file-writing/diagrams/UpdatedProjectClassDiagram.png)

## UML State Diagram
[UML State Diagram](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/blob/main/diagrams/ProjectUMLStateDiagram.png)

## UML Use Case Diagram
[UML Use Case Diagram](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/blob/Test-branch-file-writing/diagrams/UpdatedProjectUseCaseDiagramFinal.png)

## UML Sequence Diagram
[UML Sequence Diagram](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/blob/Test-branch-file-writing/diagrams/UpdatedProjectSequenceDiagram.png)

### Functionality
* The project will store the data of a library in a file to keep track of books, users, and update if there are any changes to it.
* Data can be loaded, providing access to a library, their users, and their books.
* Users will be able to borrow books, check borrowed books, and look through the library’s catalog (without being able to modify it directly except through checking out or returning).
* Libraries can manage their users and books by removing and adding them.
* The system will have functions to manage user’s borrowing fees.
* There will be a login system with different levels of access for libraries and users.
### Operations
* The system supports loading data: loading library data from a file to initialize the system.
* The system supports registration/login/logout: users can register and log in to browse/borrow/return books, and log out after completing the operation.
* The system supports borrowing books: users can borrow books from the library.
* The system supports checking borrowed books: users can check the currently borrowed books and return them.
* The system supports catalog browsing: users can browse the library's catalog to view available books.
* The system supports adding/removing books: librarians can add new books to the catalog or delete books from the catalog.
### Solution

### Steps to Run Code
* Before running the code, make sure you have set up the environment, for example: Make sure you have set up the necessary development environment, including the required programming language (JAVA).
* Clone repository from github, how to clone project repository to local IDE.
* Open a terminal and navigate to the project directory.
* Use a compiler or build tool with the JAVA programming language to compile the source code.
* The command executes compiled code.
* Follow the on-screen instructions to interact with the library management system
  
### Steps to Run JAR
* Clone the project repository to your local computer.
* Import the project into the IDE.
* Build the project to compile the source code.
* Run the main class or file containing the main method (please run LibraryGUI.java)
* Once the code is running, follow any on-screen instructions to interact with the Library Management System.

  
### References:
####JSON Library:
-Library Used: library.json
-Version: 20231013 
-Description: A JSON library for storing book's data and admin user's data.

####Frame:
1. Enter BookFrame:
-Source code location: src/librarymanagement/EnterBookFrame.java
-Description: The EnterBookFrame class allows administrators to enter the title and author information of a book and interact with other components that manage book information to add new book information to the system.

2.EnterInformationFrame:
-Source code location: src/librarymanagement/EnterInformationFrame.java
-Description: The EnterBookFrame class provides a basic interface for user login or registration, and interacts with other components that manage book information to implement user login or registration. It is extended by three subclasses, which are used to create the administrator login window (EnterLoginAdminFrame), the user login window (EnterLoginFrame) and the user registration window (EnterSignUpFrame).

3.LibraryLoginSignUpFrame:
-Source code location: src/librarymanagement/LibraryLoginSignUpFrame.java
-Description: The EnterBookFrame class creates the main menu interface of the library management system, providing operation buttons for login, registration, import, export and other functions. Interacting with other components that manage book information is to implement a series of operation entrances.


