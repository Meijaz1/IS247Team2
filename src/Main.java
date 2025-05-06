//Younoussa Daffe
//ydaffe1@umbc.edu

import java.util.List;
import java.util.Scanner;

public class Main {
    final static Scanner input = new Scanner (System.in);
    final static LibrarySystem system = new LibrarySystem();

    public static void printOpt () {
        System.out.println("=== Library Management System ===");
        System.out.println("1) Add Book");
        System.out.println("2) Register Member");
        System.out.println("3) Borrow Book");
        System.out.println("4) Return Book");
        System.out.println("5) List Books");
        System.out.println("6) List Members");
        System.out.println("7) Search Book");
        System.out.println("8) Exit");
        System.out.println("=================================");
    }
    public static void addBook () throws LibraryException  {
        System.out.println("=== Add Book ===");

        System.out.println("Enter Title: ");
        String title = input.nextLine();

        System.out.println("Enter Author: ");
        String author = input.nextLine();

        System.out.println("Enter Genre: ");
        String genre = input.nextLine();

        System.out.println("# of copies: ");
        int copies = input.nextInt();

        System.out.println("Enter ISBN: ");
        String ISBN = input.nextLine();

        system.addBook(title, author, genre, copies, ISBN);
        System.out.println("Book added successfully!");
    }
    public static void registerMember () {
        System.out.println("=== Register Member ===");

        System.out.println("Enter First Name: ");
        String first = input.nextLine();

        System.out.println("Enter Last Name: ");
        String last = input.nextLine();

        System.out.println("Enter email: ");
        String email = input.nextLine();

        //Member mem = new Member(first, last, email);
        system.registerMember(first, last, email);
        System.out.println("Member registered successfully!");
    }
    public static void borrowBook () throws LibraryException {
        System.out.println("=== Borrow Book ===");
        System.out.println("Member ID: ");
        String memId = input.nextLine();
        System.out.println("Book ISBN: ");
        String isbn = input.nextLine();

        system.borrowBook(memId, isbn);
        System.out.println("Book borrowed successfully!");
    }
    public static void returnBook () throws LibraryException {
        System.out.println("=== Return Book ===");
        System.out.println("Member ID: ");
        String memId = input.nextLine();
        System.out.println("Book ISBN: ");
        String isbn = input.nextLine();

        system.returnBook(memId, isbn);
        System.out.println("Book returned successfully!");
    }
    public static void listBooks () {
        System.out.println("=== All Books ===");
        List<Book> books = system.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            books.forEach(book -> System.out.println(book));
        }
    }
    public static void listMembers () {
        System.out.println("=== All Members ===");
        List<Member> members = system.getAllMembers();
        if (members.isEmpty()) {
            System.out.println("No members registered.");
        } else {
            members.forEach(member -> System.out.println(member));
        }
    }
    public static void searchBook () {
        System.out.println("=== Search Book ===");
        System.out.print("Enter title or ISBN: ");
        String searchTerm = input.nextLine();

        List<Book> results = system.searchBooks(searchTerm);
        if (results.isEmpty()) {
            System.out.println("No books found matching your search.");
        } else {
            System.out.println("\nSearch Results:");
            results.forEach(book -> System.out.println(book));
        }
    }
    public static void borrowedBooks () {
        System.out.println("\n=== Borrowed Books ===");
        System.out.print("Member ID: ");
        String memId = input.nextLine();

        try {
            List<Book> borrowed = system.getBorrowedBooks(memId);
            if (borrowed.isEmpty()) {
                System.out.println("No books currently borrowed by this member.");
            } else {
                System.out.println("Borrowed Books:");
                borrowed.forEach(book -> System.out.println(book));
            }
        } catch (MemberNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        while (true) {
            printOpt();
            int choice = input.nextInt();
            input.nextLine();

            try {
                switch (choice) {
                    case 1 -> addBook();
                    case 2 -> registerMember();
                    case 3 -> borrowBook();
                    case 4 -> returnBook();
                    case 5 -> listBooks();
                    case 6 -> listMembers();
                    case 7 -> searchBook();
                    case 8 -> borrowedBooks();
                    case 9 -> {
                        system.saveData();
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice!");
                }
            } catch (LibraryException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
