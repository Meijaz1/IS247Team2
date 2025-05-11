import java.util.Scanner;
import java.util.List;

public class Main {
    final static Scanner input = new Scanner(System.in);
    final static LibrarySystem system;


    static {
        try {
            system = new LibrarySystem();
        } catch (LibraryException e) {
            throw new RuntimeException(e);
        }
    }

    // Input Methods //
    /**
     * @Method ~ intInput - Method which allows user to input ints.
     */
    private static int intInput(String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            System.out.println("Please enter a number!");
            input.next();
        }
        int value = input.nextInt();
        input.nextLine();
        return value;
    }
    /**
     * @Method ~ stringInput - Method which allows user to input strings
     */
    private static String stringInput(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    public static void main(String[] args) {

        while (true) {
            printMainMenu();
            int opt = intInput("Enter option: ");

            try {
                switch (opt) {
                    case 1 -> bookMenu();
                    case 2 -> memberMenu();
                    case 3 -> infoMenu();
                    case 4 -> {
                        System.out.println("Exiting system...");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid option!");
                }
            } catch (LibraryException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // Menu Methods //
    /**
     * @Method ~ printMainMenu - prints out all the options for management
     */
    private static void printMainMenu() {
        System.out.println("=== LIBRARY MANAGEMENT SYSTEM ===");
        System.out.println("1. Book Management");
        System.out.println("2. Member Management");
        System.out.println("3. Information");
        System.out.println("4. Exit");
        System.out.println("==================================");
    }

    /**
     * @Method ~ bookMenu - prints out all options related to book management
     */
    private static void bookMenu() throws LibraryException {
        while (true) {
            System.out.println("=== BOOK MANAGEMENT ===");
            System.out.println("1. Register Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Back to Main Menu");

            int opt = intInput("Enter option: ");
            switch (opt) {
                case 1 -> registerBook();
                case 2 -> borrowBook();
                case 3 -> returnBook();
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
    /**
     * @Method ~ memberMenu - prints out all options related to member management
     */
    private static void memberMenu() throws LibraryException {
        while (true) {
            System.out.println("=== MEMBER MANAGEMENT ===");
            System.out.println("1. Register Member");
            System.out.println("2. Back to Main Menu");

            int opt = intInput("Enter option: ");
            switch (opt) {
                case 1 -> registerMember();
                case 2-> {
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
    /**
     * @Method ~ infoMenu - prints out all options related to info management
     */
    private static void infoMenu() {
        while (true) {
            System.out.println("=== INFORMATION ===");
            System.out.println("1. View All Borrowed Books");
            System.out.println("2. View All Members");
            System.out.println("3. View All Books");
            System.out.println("4. Back to Main Menu");

            int opt = intInput("Enter option: ");
            switch (opt) {
                case 1 -> viewBorrowedBooks();
                case 2 -> listAllMembers();
                case 3 -> listAllBooks();
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    // Action Methods //
    /**
     * @Method ~ registerBook - prints out question in order to register a book
     */
    private static void registerBook() throws LibraryException {
        System.out.println("=== Add New Book ===");
        String title = stringInput("Title: ");
        String author = stringInput("Author: ");
        String genre = stringInput("Genre: ");
        int copies = intInput("Number of copies: ");
        String ISBN = stringInput("ISBN: ");

        system.registerBook(title, author, genre, copies, ISBN);
        System.out.println("Book added successfully!");
    }
    /**
     * @Method ~ borrowBook - prints out question in order to borrow a book
     */
    private static void borrowBook() throws LibraryException {
        System.out.println("=== Borrow Book ===");
        String memId = stringInput("Member ID: ");
        String isbn = stringInput("Book ISBN: ");

        system.borrowBook(memId, isbn);
        System.out.println("Book borrowed successfully!");
    }
    /**
     * @Method ~ returnBook - prints out question in order to return a book
     */
    private static void returnBook() throws LibraryException {
        System.out.println("=== Return Book ===");
        String memId = stringInput("Member ID: ");
        String isbn = stringInput("Book ISBN: ");

        system.returnBook(memId, isbn);
        System.out.println("Book returned successfully!");
    }
    /**
     * @Method ~ registerMember - prints out question in order to register a member
     */
    private static void registerMember() {
        System.out.println("=== Register Member ===");
        String first = stringInput("First Name: ");
        String last = stringInput("Last Name: ");
        String email = stringInput("Email: ");

        String memId = system.registerMember(first, last, email);
        System.out.println("Member registered successfully! ID: " + memId);
    }

    // Display Methods //
    /**
     * @Method ~ listAllMembers - prints out all members within system
     */
    private static void listAllMembers() {
        System.out.println("=== ALL MEMBERS ===");
        List<Member> members = system.getAllMembers();

        if (members.isEmpty()) {
            System.out.println("No members registered in the system.");
        } else {
            System.out.println("Total members: " + members.size());
            members.forEach(member -> System.out.println("\n" + member));
        }
    }
    /**
     * @Method ~ listAllBooks - prints out all books within catalog
     */
    private static void listAllBooks() {
        System.out.println("=== All Books ===");
        List<Book> books = system.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books in library.");
        } else {
            books.forEach(book -> System.out.println(book.getTitle() + " by " + book.getAuthor()));
        }
    }
    /**
     * @Method ~ viewBorrowedBooks - prints out question in order to see what a certain member borrowed
     */
    private static void viewBorrowedBooks() {
        System.out.println("=== Borrowed Books ===");
        String memId = stringInput("Member ID: ");

        try {
            List<Book> borrowed = system.getBorrowedBooks(memId);
            if (borrowed.isEmpty()) {
                System.out.println("No books currently borrowed.");
            } else {
                borrowed.forEach(book -> System.out.println(book.getTitle()));
            }
        } catch (MemberNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}