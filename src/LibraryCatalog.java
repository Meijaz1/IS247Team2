//Younoussa Daffe
//ydaffe1@umbc.edu

import java.util.*;
import java.io.*;

public class LibraryCatalog {
    private List<Book> books = new ArrayList<>();
    private static final String FILE_NAME = "libCatalog.txt";

    /**
     * Method which throws exception when duplicate book is being added
     * If not a duplicate, adds new book
     */
    public void addBook(Book book) throws LibraryException {
        if (books.stream().anyMatch(b -> b.getISBN().equals(book.getISBN()))) {
            throw new LibraryException("Book with ISBN " + book.getISBN() + " already exists");
        }
        books.add(book);
    }

    /**
     * Method which returns user's membership ID
     * @return list of books with ISBN specified
     */
    public Book searchByISBN(String ISBN) {
        return books.stream()
                .filter(b -> b.getISBN().equals(ISBN))
                .findFirst()
                .orElse(null);
        }

    /**
     * Method which saves info to file
     */
    public void saveToFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Book book : books) {
                writer.write(String.format("%s|%s|%s|%s|%s", book.getTitle(), book.getAuthor(), book.getGenre(), book.getISBN(), book.isAvailable()));
                writer.newLine();
                }
            }
        }

    /**
     * Method which loads info from file
     */
    public void loadFromFile() throws IOException {
        books.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                Book book = new Book(parts[0], parts[1], parts[2], Integer.parseInt(parts[4]), parts[3]);
                books.add(book);
                }
            }
        }
    }