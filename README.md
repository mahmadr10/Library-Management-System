# Library Management System

## About
This repository contains a Library Management System project developed by Muhammad Ahmad, a student of BS Data Science at SEECS. The CMS ID for Muhammad Ahmad is 461348. This is Muhammad Ahmad's first project uploaded to GitHub.

## Project Description
The project is a simple library management system implemented in Java. It allows users to add books and users to the library, check out books, return books, and search for books by title or author.

## Libraries Used
The following libraries are imported for this management system:
- `java.util.Scanner`
- `java.io.*`
- `java.util.*`

## Classes
### Book
- **Attributes**:
  - `bookID: String`
  - `title: String`
  - `author: String`
  - `genre: String`
  - `available: boolean`
- **Methods**:
  - Getter and Setter methods for attributes

### User
- **Attributes**:
  - `userID: int`
  - `name: String`
  - `contactInfo: String`
  - `borrowedBooks: List<Book>`
- **Methods**:
  - Getter and Setter methods for attributes

### Library
- **Attributes**:
  - `books: List<Book>`
  - `users: List<User>`
- **Methods**:
  - `addBook(String title, String author, String genre, boolean available)`: Adds a book to the library
  - `addUser(String name, String contactInfo)`: Adds a user to the library
  - `checkoutBook(int userID, String title)`: Checks out a book from the library
  - `returnBook(int userID, String title)`: Returns a book to the library
  - `searchByTitle(String title)`: Searches for books by title
  - `searchByAuthor(String author)`: Searches for books by author
  - `saveLibrary(String file)`: Saves the library state to a file
  - `static Library viewLibrary(String file)`: Views the library state from a file

### Main
- Entry point of the program.
- Allows users to interact with the library management system through the command line.

## How to Use
1. Clone this repository to your local machine.
2. Compile and run the `LibraryManagementSystem.java` file.
3. Follow the prompts to interact with the library management system.

## Author
- **Muhammad Ahmad**
- Student ID: 461348
- BS Data Science, SEECS

## Contact Information
For any inquiries or issues, please contact Muhammad Ahmad at [insert_email_address_here].

## License
This project is licensed under the MIT License.
