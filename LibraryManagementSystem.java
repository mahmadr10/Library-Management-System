// I am Muhammad Ahmad student of BS Data Science in SEECS
// My CMS id is 461348
// This is the first project that I am uploading on GitHub
// My file is LibraryManagementSystem

// For the management system, I am importing these necessary libraries




import java.util.Scanner;
import java.io.*;
import java.util.*;

// Defining the LibraryManagementSystem class
public class LibraryManagementSystem {

    // Defining the Book class as a nested class
    public static class Book implements Serializable {
        // Declaring instance variables for Book
        private String title, author;
        private boolean available;

        // Book class constructor
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.available = true;
        }

        // Getter method for the title of the book
        public String getTitle() {
            return title;
        }

        // Setter method for the title of the book
        public void setTitle(String title){
            this.title=title;
        }

        // Getter method for the author of the book
        public String getAuthor() {
            return author;
        }

        // Setter method for the author of the book
        public void setAuthor(String author){
            this.author=author;
        }

        // Getter method to check if the book is available
        public boolean isAvailable() {
            return available;
        }

        // Setter method to set the availability of the book
        public void setAvailable(boolean available) {
            this.available = available;
        }
    }

    // Defining the User class as a nested class
    public static class User implements Serializable {
        // Declaring instance variable for User
        private String username;

        // User class constructor
        public User(String username) {
            this.username = username;
        }

        // Getter method for the username
        public String getUsername() {
            return username;
        }

        // Setter method for the username
        public void setUsername(String username){
            this.username=username;
        }
    }

    // Defining the Library class as a nested class
    public static class Library implements Serializable {
        // Declaring instance variables for Library
        private List<Book> books;
        private Map<String, User> users;

        // Library class constructor
        public Library() {
            this.books = new ArrayList<>();
            this.users = new HashMap<>();
        }

        // Method to add a book to the library
        public void addBook(String title, String author) {
            books.add(new Book(title, author));
        }

        // Method to add a user to the library
        public void addUser(String username) {
            users.put(username, new User(username));
        }

        // Method to checkout a book from the library
        public void checkoutBook(String username, String title) {
            for (Book book : books) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book '" + title + "' checked out by " + username);
                    return;
                }
            }
            System.out.println("Book '" + title + "' does not exist.");
        }

        // Method to return a book to the library
        public void returnBook(String title) {
            for (Book book : books) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Book '" + title + "' returned.");
                    return;
                }
            }
            System.out.println("Book '" + title + "' does not exist.");
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
                if (book.getAuthor() !="") {
                    authorBooks.add(book);
                }
            }
            return authorBooks;
        }

        // Method to save the library state to a file
        public void saveLibrary(String file) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                out.writeObject(this);
                System.out.println("Library state saved successfully.");
            } catch (IOException e) {
                System.out.println("Error saving library state: " + e.getMessage());
            }
        }

        // Method to view the library state from a file
        public static Library viewLibrary(String file) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                Library library = (Library) in.readObject();
                System.out.println("Library viewed successfully.");
                return library;
            } 
             catch (IOException | ClassNotFoundException e) {
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
            System.out.println("Enter the user:");
            String username= sc.nextLine();
            System.out.println("Author: ");
            String author = sc.nextLine();

            // Adding book and user to the library
            library.addBook(title, author);
            library.addUser(username);

            // Checking out a book and returning it
            library.checkoutBook("Muhammad Ahmad", "Physics");
            library.returnBook("Physics");

            // Saving and viewing library state
            library.saveLibrary("library.ser");

            library.viewLibrary("library.ser");
        } 
        
        catch (Exception e) {
            System.out.println("Error!!!");
        }
    }
}
