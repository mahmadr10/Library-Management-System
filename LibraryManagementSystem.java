// I am Muhammad Ahmad student of BS Data Science in SEECS
// My CMS id is 461348
// This is the first project that I am uploading on GitHub

// My file is LibraryManagementSystem

// I am importing following libraries for this management system

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class LibraryManagementSystem {

    // Defining the Book class 
    public static class Book implements Serializable {
        private String bookID;
        private String title;
        private String author;
        private String genre;
        private boolean available;

        // Book class constructor
        public Book(String title, String author, String genre, boolean available) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.available = available;
        }

        // Getter and Setter methods for the attributes
        public String getBookID() {
            return bookID;
        }

        public void setBookID(String bookID) {
            this.bookID = bookID;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title){
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author){
            this.author = author;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre){
            this.genre = genre;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }
    }

    // Defining the User class 
    public static class User implements Serializable {
        private int userID;
        private String name;
        private String contactInfo;
        private List<Book> borrowedBooks;

        // User class constructor
        public User(String name, String contactInfo) {
            this.name = name;
            this.contactInfo = contactInfo;
            this.borrowedBooks = new ArrayList<>();
        }

        // Getter and Setter methods for the attributes
        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContactInfo() {
            return contactInfo;
        }

        public void setContactInfo(String contactInfo) {
            this.contactInfo = contactInfo;
        }

        public List<Book> getBorrowedBooks() {
            return borrowedBooks;
        }

        public void setBorrowedBooks(List<Book> borrowedBooks) {
            this.borrowedBooks = borrowedBooks;
        }
    }

    // Defining the Library class
    public static class Library implements Serializable {
        private List<Book> books;
        private List<User> users;

        // Library class constructor
        public Library() {
            this.books = new ArrayList<>();
            this.users = new ArrayList<>();
        }

        // Method to add a book to the library
        public void addBook(String title, String author, String genre, boolean available) {
            Book book = new Book(title, author, genre, available);
            books.add(book);
        }

        // Method to add a user to the library
        public void addUser(String name, String contactInfo) {
            users.add(new User(name, contactInfo));
        }

        // Method to checkout a book from the library
        public void checkoutBook(int userID, String title) {
    for (Book book : books) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book '" + title + "' checked out by user ID " + userID);
            return;
        }
    }
    System.out.println("Book '" + title + "' does not exist.");
}


        // Method to return a book to the library
        public void returnBook(int userID, String title) {
            for (Book book : books) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Book '" + title + "' returned by user ID " + userID);
                    return;
                }
            }
            System.out.println("Book '" + title + "' does not exist or is already available.");
        }
      
        // Method to search for books by title
        public List<Book> searchByTitle(String title) {
            List<Book> titleBooks = new ArrayList<>();
            for (Book book : books) {
                if (book.getTitle()!="") {
                    titleBooks.add(book);
                }
            }
            return titleBooks;
        }
        

        // Method to search for books by author
        public List<Book> searchByAuthor(String author) {
            List<Book> authorBooks = new ArrayList<>();
            for (Book book : books) {
                if (book.getAuthor()!="") {
                    authorBooks.add(book);
                }
            }
            return authorBooks;
        }

        // Method to save the library state to a file
        public void saveLibrary(String file) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                out.writeObject(this);
                System.out.println("Library saved successfully.");
            } catch (IOException e) {
                System.out.println("Error saving library: " + e.getMessage());
            }
        }

        // Method to view the library state from a file
        public static Library viewLibrary(String file) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                Library library = (Library) in.readObject();
                System.out.println("Library viewed successfully.");
                return library;
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error viewing library");
            }
            return null;
        }
    }

    // Main method
public static void main(String[] args) {
    try {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to MUHAMMAD AHMAD'S Library Management System");
        Library library = new Library();

        // Prompting user to enter book details
        System.out.println("Enter the details of the book:");
        System.out.println("Title: ");
        String title = sc.nextLine();
        System.out.println("Author: ");
        String author = sc.nextLine();
        System.out.println("Genre: ");
        String genre = sc.nextLine();
        System.out.println("Availability (true/false): ");
        boolean available = sc.nextBoolean();
       
        // Adding book and user to the library
        library.addBook(title, author, genre, available);

        // Prompting user to enter user details
        System.out.println("Enter the details of the user:");
        System.out.println("Name: ");
        String name = sc.next();
        System.out.println("User id:");
        int userID = sc.nextInt();
        System.out.println("Contact Information: ");
        String contactInfo = sc.next();

        // Adding user to the library
        library.addUser(name, contactInfo);

        // Checking out a book and returning it
        System.out.println("Enter the title of the book to be checked out:");
        String checkoutTitle = sc.nextLine();
        library.checkoutBook(userID, checkoutTitle);

        System.out.println("Enter the title of the book to be returned:");
        String Title = sc.nextLine();
        library.returnBook(userID, Title);

        // Saving and viewing library state
        library.saveLibrary("library.ser");
        library.viewLibrary("library.ser");
        sc.close();

    } catch (Exception e) {
        System.out.println("Error!!! You entered something incorrect.");
    }
}
}
