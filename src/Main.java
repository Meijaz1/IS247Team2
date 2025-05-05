//Younoussa Daffe
//ydaffe1@umbc.edu

import java.util.Scanner;

public class Main {
    public static void printOpt () {
        System.out.println("=== Library Management System ===");
        System.out.println("1) Add Book");
        System.out.println("2) Register Member");
        System.out.println("3) Borrow Book");
        System.out.println("4) Return Book");
        System.out.println("5) List Books");
        System.out.println("6) List Books");
        System.out.println("7) Search Book");
        System.out.println("8) Exit");
        System.out.println("=================================");
    }
    public static void addBook () throws LibraryException  {

    }
    public static void registerMember () {

    }
    public static void borrowBook () {

    }
    public static void returnBook () {

    }
    public static void listBooks () {

    }
    public static void listMembers () {

    }
    public static void searchBook () {

    }
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        LibrarySystem system = new LibrarySystem();

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
                    case 8 -> {
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
