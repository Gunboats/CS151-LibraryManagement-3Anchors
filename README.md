## Team: 3 Anchors
## Team members: Willy Tang, Alexander Pham, Yelin Wu
Link to running the jar, this is just one approach that should work: https://www.youtube.com/watch?v=K0sskws1XS8
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
### Problem/Issue: Problem to solve: We have a library that lacks a digital system for users to use and store important data such as the books in their catalog and the users that are registered with the library. We want to create a library management system that manages a library’s digital catalog of books and users with their respective information such as borrowed books, their name, and their library card number. This library management system should have a GUI that is intuitive and not difficult to use. Libraries and users need to be able to login to use their respective privileges. This requires us to uniquely identify each user to each library.

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
#### Admin operations:
* Import: Imports a library file's data to the GUI, which will allow the admin to use that data of books and users for removing, adding. The admin may choose what file to be imported, and only valid files work
* Export: Exports the library's data to a file, and the admin may choose where to place the file. It will create the file with a name based on the library's name
* Add user: Admins may add users to the library, but they must fill out the sign up fields of the user's first name, last name, phone number(must be unused with library), and their password
* Remove user: Select a user for removel, and removes a user from the library on pressing the remove button, and reopens the library's list of users to reflect that the selected user was removed
* Add book: Adds a book to the library, admins must fill out the book form, which requires a title and author, which will update the list of books in the library. Changes made will update the library.json file
* Remove book: Removes a book from the library if it is not already borrowed (we still want the book back for tracking before removing from catalog), changes made will update the library.json file
* Logout: Admins may logout of the GUI, returning them to the main menu (LibraryLoginSignUpFrame)
* Exit: Admins can exit the program, which will save the changes made to the library to the library.json file
* Login: Admins can login, requiring them to enter the proper username and password combination to access the next JFrame: The list of users in the library
#### User operations
* Sign up: Users can sign up, filling out their first name and last name with valid characters, unused phone number with library, a password with specific requirements for password strength
* Login: Users can login to the library, which checks for correct password and username combination: Prevents users from logging in if they enter incorrect information, and successful login allows the user to view the library's list of books for borrowing
* Borrow: Users may select checkboxes of books they wish to borrow, and upon pressing the borrow button, it will add the books to the user's list of borrowed books, updating that the books are borrowed. Borrowing fails when the user has already borrowed a copy of the book with exact casing and same title and author. Borrowing also fails when user tries to borrow 2 copies of the same book. Changes made will update the library.json file
* Books Borrowed: Displays the books the user has borrowed
* Return books: In the JFrame displaying the books the user has borrowed, the books borrowed can be returned by the user. By selecting the checkboxes of books and pressing the return book button, it will make the books available again at the library, and take out the books from the user's list of borrowed books. Changes made will be saved to the library
* Logout: Users may logout of the GUI, returning them to the main menu (LibraryLoginSignUpFrame)
* Exit: Exits the GUI, shutting down the components and saving the changes made to thel ibrary
### Solution
* We have created a GUI that uses a library.json file to store the contents of a library. Inside are the library's books, users, user's borrowed books
* Admins can login in the Admin login section, allowing them to select check boxes to choose what users to remove, what books to remove.
* Admins may additional create and add new books and users by filling out the JFrame's form, which will update the JFrame that displays all the users or books
* Admins may additionally import a library and export the data of the library
* Users can register and login to the library, which will open the Library's catalog of book
* Users can select checkboxes to choose what books to borrowed, though they cannot borrow books they already have borrowed or the books are already borrwoed
* Users may only borrow books available at the library
* Users can click the books borrowed button to see what books they have borrowed, and return books. Users cannot return if they have selected no books

### Steps to Run Code
* Before running the code, make sure you have set up the environment, for example: Make sure you have set up the necessary development environment, including the required programming language (JAVA).
* Download the zip file, take out the folder in side (CS151-LibraryManagement-3Anchors file)
* Add the contents of the CS151-LibraryManagement-3Anchors file into a new project
* The src folder's content's should go into the src folder of the new project, and the other files should be outside of the source folder
* Here is how the Package Explorer should look:
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/d20fa74f-0997-4606-9918-62852ed1f0bc)
* We see bin, diagrams, lib, and proposal are not in the src folder, etc but next to it

  
### Steps to Run JAR
* Clone the project repository to your local computer.
* Assuming you have download the Zip file, take the CS151-LibraryManagement-3Anchors file out of the zip or extract the file outside of the zip
* Run the JAR from inside the CS151-LibraryManagement-3Anchors file (not the compressed folder) that you took out 
* It should say "TestLib" on the main menu when you run it, not "a"

Link to running the jar, this is just one approach that should work: https://www.youtube.com/watch?v=K0sskws1XS8

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
* Opens the Add book JFrame from the add book button
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/2d52b31b-355f-4990-ab62-1ef061955c02)
* Occurs when admins try to remove 0 books that are selected with check boxes
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/0138e961-abe5-434e-b3a4-04088b71271d)
* Occurs when admin tries adding a book without a title
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/d1563f11-8aa1-490a-a72c-e04d98a74e44)
* Occurs when admin tries adding book with a title, but no author
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/32cbec7b-2e1c-49b5-9bfb-67ce2eaa3210)
* Occurs when user tries to borrow books, but no books were selected
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/6e39fe44-f225-43cb-bc72-e8d43b9c5a75)
* Occurs when user tries to borrow an already borrowed book
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/39c5913f-7f2e-46bc-8909-def0bf7303f1)
* Occurs when user tries to return 0 books selected
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/fc89d09c-5ed2-4d83-862b-fbe12ef4a2a4)
* Opens when pressing x button to close on the LibraryCatalogMenu, LibraryUserMenu, and LibraryAdminCatalogMenu frames
* ![image](https://github.com/Gunboats/CS151-LibraryManagement-3Anchors/assets/30137980/0812d034-4203-4b9d-84aa-3cf4a4dff13b)
















  
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


