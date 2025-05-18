import java.util.Scanner;

class Book {
    private String bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(String bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Getters and Setters
    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "ID: " + bookID + 
               ", Title: " + title + 
               ", Author: " + author + 
               ", Available: " + (isAvailable ? "Yes" : "No");
    }
}

class Library {
    private Book[] books;
    private int count;

    public Library() {
        this.books = new Book[5];
        this.count = 0;
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Method to remove a book from the library
    public void removeBook(String bookID) {
        for (int i = 0; i < count; i++) {
            if (books[i].getBookID().equals(bookID)) {
                // Shift remaining elements to the left
                for (int j = i; j < count - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[count - 1] = null;
                count--;
                System.out.println("Book removed successfully!");
                return;
            }
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }

    // Method to replace a book's information
    public void replaceBook(String bookID, String newTitle, String newAuthor) {
        for (int i = 0; i < count; i++) {
            if (books[i].getBookID().equals(bookID)) {
                books[i].setTitle(newTitle);
                books[i].setAuthor(newAuthor);
                System.out.println("Book information updated successfully!");
                return;
            }
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }

    // Method to search for a book by ID
    public void searchBook(String bookID) {
        for (int i = 0; i < count; i++) {
            if (books[i].getBookID().equals(bookID)) {
                System.out.println("Book found: " + books[i]);
                return;
            }
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }

    // Method to display all books in the library
    public void displayBooks() {
        if (count == 0) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("Books in the library:");
        for (int i = 0; i < count; i++) {
            System.out.println(books[i]);
        }
    }
}

public class BookManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nBook Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Replace Book Information");
            System.out.println("4. Search Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;
                    
                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    String removeId = scanner.nextLine();
                    library.removeBook(removeId);
                    break;
                    
                case 3:
                    System.out.print("Enter Book ID to replace: ");
                    String replaceId = scanner.nextLine();
                    System.out.print("Enter new Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new Author: ");
                    String newAuthor = scanner.nextLine();
                    library.replaceBook(replaceId, newTitle, newAuthor);
                    break;
                    
                case 4:
                    System.out.print("Enter Book ID to search: ");
                    String searchId = scanner.nextLine();
                    library.searchBook(searchId);
                    break;
                    
                case 5:
                    library.displayBooks();
                    break;
                    
                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}