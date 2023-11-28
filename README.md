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
### Alex: Managed github during project proposal phase, transferred control to Willy after. Initialized project files in github. Added to basic Library operations during the early stages of the project and created some testing for the library, pre-GUI, in the Pre-commit-to-main-branch branch. Implemented import and export functionality on Test-branch-file-writing, and created a format for storing Library data in a JSON file along with some test libraries.
### Yelin: Contributed to Libray.java, User.java, LibrayLoginSignUpFrame.java(These were pushed the laurindaaa-patch branch. But it was overrided by the team's code and didn't merge into the final branch). Added the password format checker. Fixed the import path for library.json. Updated the libray.json data inclduing books data and user data. Updated README.md.

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
* Assuming you have download the Zip file, take the CS151-LibraryManagement-3Anchors file out of the zip
* Run the JAR from inside the CS151-LibraryManagement-3Anchors file that you took out 
* It should say "TestLib" on the main menu when you run it, not "a"

  

### Snapshot of running program
* When the user runs the program, the loginSignup interface will appear first.
* <img width="794" alt="loginSignupFrame" src="https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/147214348/204b68a4-a2ac-405d-b75d-70373ed1812b">
* To borrow books, users need to click signup first, obtain user information and then log in to borrow/return/checkbooks. Users access this by pressing sign up botton, admins access by pressing add user button
* <img width="584" alt="sign up" src="https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/147214348/b17ce1da-753d-4df8-bbf6-3fa2d6fe21b1">
* Obtain the registered user's password and library card id (username)
* <img width="595" alt="user information" src="https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/147214348/31534c9a-619f-4071-a974-18a051e69caf">
* Login window to the Library
* <img width="590" alt="login" src="https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/147214348/6138720f-29c8-49a1-8773-2eda77f58daa">
* Users can view books as well as borrow or return books,
* <img width="790" alt="book list" src="https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/147214348/33734c98-53c2-41ef-8784-9e4e1320dafc">
* <img width="802" alt="return book" src="https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/147214348/a0def085-3a76-4426-b395-c4b1b0650fcf">
* Show activity information
* <img width="798" alt="borrow book and show activity information" src="https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/147214348/dd2bc369-9d01-4ee0-b959-57922e159a08">
* <img width="795" alt="show activity information" src="https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/147214348/cb9df368-e381-4f95-860e-289fa918d4a0">

#### Other Exceptions/Popups that may appear when running program
* Occurs when admin or user fails to enter any characters in the username field
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/3a036125-aff3-4f97-9bfa-b3590a20a6fc)
* Occurs when admin or user enters info into passwordField, but leaves username field empty
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/a118b0b9-4932-492c-88ed-5cb77238cd71)
* Occurs when admin or user enters incorrect username and password combination
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/d7040036-8788-44be-a6b8-54e1b205ffad)
* Opens after successful login for admins, shows all users, allowing removing users, adding users, opening the admin view of the library's book catalog, can import and export the library
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/ee840989-2012-4fb2-b87b-ff8bba3c5e99)
* Occurs when no checkboxes are selected to remove a user
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/8b8370ad-3c96-49a5-b3c4-6f623350ca52)
* Occurs when user or admin tries to register a user, but does not fill in any fields
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/96b355a8-5b08-48ae-9a51-a62d1079c5c3)
* Occurs when first name field is filled, but last name field is not filled
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/d021fdb1-d121-4a13-8e32-4bcff209df09)
* Occurs when no number is provided for the phone number field
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/83262df9-a894-4bdc-a8f1-92c9d5e67996)
* Occurs when user or admin provides a number for the phone number field, but the length is not exactly 9 digits
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/5f18374a-56d1-43a8-b2e3-bd97cc76b861)
* Occurs when user or admin uses non-digit characters in the phone number field
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/2e016eeb-a34b-42ac-9032-d0ac9b0a0f2a)
* Occurs when password field is empty
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/b303cb7c-dc62-44c5-8627-1efddcc96abe)
* Occurs when password does not meet required password requirements
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/0594cafd-21c9-41ae-bd03-0e51827e7dab)
* Occurs when user or admin enters a phone number that is already used when they try to register a user
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/2e430840-17fe-4343-9fb6-83d1b778a62e)
* Opens when admin tries to import a file of library data to the GUI
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/6a277b3c-2d22-4da1-9ad5-f3803e3e94b1)
* Pop up of file explorer occurs when admin tries to import an invalid file to the library GUI
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/80d3dae1-585c-4361-a670-4e5158b6b6f7)
* Opens a file explorer when admin tries to export to a location
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/ba4dad49-ff10-494d-a4b2-52beb7ee37bb)












  
### References:
####JSON Library:
-Package Used: org.json (from json-20231013.jar)
-Version: 20231013 release
-Description: A package with useful operations for reading and writing JSON files. From https://github.com/stleary/JSON-java

####Frame:
* 1.Enter BookFrame:
-Source code location: src/librarymanagement/EnterBookFrame.java
-Description: The EnterBookFrame class allows administrators to enter the title and author information of a book and interact with other components that manage book information to add new book information to the system.

* 2.EnterInformationFrame:
-Source code location: src/librarymanagement/EnterInformationFrame.java
-Description: The EnterBookFrame class provides a basic interface for user login or registration, and interacts with other components that manage book information to implement user login or registration. It is extended by three subclasses, which are used to create the administrator login window (EnterLoginAdminFrame), the user login window (EnterLoginFrame) and the user registration window (EnterSignUpFrame).

* 3.LibraryLoginSignUpFrame:
-Source code location: src/librarymanagement/LibraryLoginSignUpFrame.java
-Description: The EnterBookFrame class creates the main menu interface of the library management system, providing operation buttons for login, registration, import, export and other functions. Interacting with other components that manage book information is to implement a series of operation entrances.


