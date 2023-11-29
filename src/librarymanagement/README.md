// Manual Test cases because my front end and my back end are basically the same and I don't have time to fix it (Willy)
// Test 1: Admin logins
// Case 1: Empty username, password: asdf
// Case 1 result: Popup saying "Exception: Empty username field"
// Case 2: Empty password, filled username
// Case 2 result: Popup saying "Exception: Empty password field"
// Case 3: Incorrect username and password
// Case 3 result: "Exception: Incorrect password and username combination"
// Case 4: Username: admin, password: password
// Case 4 result: Open LibraryAdminCatalogMenu, with Users listed, 
// remove, add, book catalog, and logout buttons

// Test 2a: LibraryAdminCatalogMenu Remove 
// Case 1: Do not check any users and then press remove
// Case 1 Result: Popup "No user was selected to be removed"
// Case 2: Remove a user by selecting checkbox and selecting remove
// Case 2 Result: User should be removed, resulting in 1 less spot

// Test 2b: LibraryUserMenu Add (user) (opens sign up window)
// Case 1: Press add button
// Case 1 result: Open Signup window with first name, last name, phone num, password fields
// Case 2: Do nothing in the signup window, only press register
// Case 2 result: Popup: "Exception: Empty first name field"
// Case 3: Fill in first name with "w"
// Case 3 result: Popup: "Exception: Empty last name field"
// Case 4: Fill in first name and last name with "w"
// Case 4 result: Popup: "Exception: Empty phone number field"
// Case 5: Phone number with 23, first and last name w
// Case 5 result: Popup: "Exception: Phone number is not 9 digits"
// Case 6: Phone number with 23w, first and last name w
// Case 6 result: Popup: "Exception: Phone number contains non-digits"
// Case 7: Phone number with > 9 numbers(1231231234), first and last name w
// Case 7 result: Popup: "Exception: Phone number is not 9 digits"
// Case 8: 9 digit phone number, first and last name w
// Case 8 result: Popup: "Exception: Password needs at least 1 character"
// Case 9: Phone number valid, first and last name w, password w
// Case 9 result: Sign up window closes, user is added, popup saying that
// "You registered successfully! Your username/library card is (Libraryprefix-numbers)
// Your password is : (password)"
// Case 10: Phone number already registered, first and last name w, password: w
// Case 10 result: Popup: "Exception: The phone number is already registered"
// Case 11: Phone number registered, first name = 321, last name = w, password w
// Case 11 result: Last name contains non-letters

// Test 2c:
// Case 1: Logout button
// Case 1 result: Return to main menu (login, signup, exit, admin login)

// Test 2d: Book Catalog from Admin (LibraryAdminCatalogMenu)
// Case 1: Select no checkboxes for books, hit remove
// Result: Popup: "Exception: No books selected for removal"
// Case 2: Remove a book by selecting a check box, hit remove
// Result: Book removed, reopens JFrame
// Case 3: Press add book
// Result: opens EnterBookFrame JFrame
// Case 4: Add book with empty title and author, then try add book
// Result: Popup: "Exception: No text in title"
// Case 5: add book with empty author, title: w
// Result: Popup: "Exception no text in author"
// Case 6: Add book with at least 1 char for author and title
// Result: Book should be added

// Test 2e: Logout from Book Catalog 
// Result: New JFrame, closes others, return to main menu

// Test 3: Signup is basically should work like the admin signup

// Test 4: Login
// Case 1: Empty fields
// Result: Popup: "Exception: Empty username field"
// Case 2: Fill in username (incorrect)
// Result: Popup: "Exception: Empty password field"
// Case 3: Incorrect password and username fields
// Result: Popup: "Exception: Incorrect password and username combination"
// Applies for various combinations of incorrect combinations
// Case 4: Correct password and username
// Result: close main menu, login window, opens JFrame of LibraryCatalogMenu

// Test 5: Borrowing books
// Case 1: Don't select any books with checkbox, and then hit borrow
// Result: Popup: "Exception: No books were borrowed"
// Case 2: Book Available is borrowed
// Result: Reopens LibraryCatalogMenu with updated info that the book
// went from Available to Borrowed, popup tells each book the user borrowed
// by saying "You borrowed: (title) by (author), (repeated for each book) 
// Thank you for the support!"
// Case 3: Borrowing already borrowed books, whether it is the only selected or
// with multiple other books of different borrow states
// Result: Popup: "Exception: A book trying to be checked out is already borrowed"

// Test 5a: Open BooksBorrowed, opening LibraryBorrowedBooksMenu,
//  User's list of books currently borrowed
// Case 1: Don't select any books, hit return books
// Result: Popup: "Exception: No borrowed books were returned"
// Case 2: Selected multiple books, Return book(s) (one or multiple)
// Result: Popup: "You returned: (title) by (author) (repeating for each book),
// Thank you for the support!"
// Test 6: Logout: Should return back to main menu
// Result: Closes other windows, opens main menu

// Test 7: Importing and exporting
// 