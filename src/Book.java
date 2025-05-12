//Younoussa Daffe
//ydaffe1@umbc.edu
// Refactored core class: Book.java
public class Book {
    private String title;
    private String author;
    private String genre;
    private int numberOfCopies;
    private int availableCopies;
    private String ISBN;

    /**
     * Constructs a Book object.
     * @param title Title of the book
     * @param author Author of the book
     * @param genre Genre of the book
     * @param numberOfCopies Total copies of the book
     * @param ISBN ISBN number of the book
     */
    public Book(String title, String author, String genre, int numberOfCopies, String ISBN) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.numberOfCopies = numberOfCopies;
        this.availableCopies = numberOfCopies;
        this.ISBN = ISBN;
    }

    /**
     * Checks if the book is available to borrow.
     * @return true if available copies > 0
     */
    public boolean isAvailable() {
        return availableCopies > 0;
    }

    public void incrementCopies(int amount) {
        this.numberOfCopies += amount;
        this.availableCopies += amount;
    }

    public void decrementCopies(int amount) {
        this.numberOfCopies -= amount;
        this.availableCopies -= amount;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public String getISBN() { return ISBN; }
}

// Partial refactor for Member.java to fix casting issue
public class Member {
    private String memID;
    private String firstName;
    private String lastName;
    private String email;
    private Queue<Book> borrowedBooks;
    public static final int BORROW_LIMIT = 3; // Unified limit

    public Member(String memID, String firstName, String lastName, String email) {
        this.memID = memID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.borrowedBooks = new LinkedList<>();
    }

    public String getMemberId() { return memID; }
    public String getName() { return firstName + " " + lastName; }
    public String getEmail() { return email; }

    public List<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }

    public void borrowBook(Book book) throws BorrowLimitExceededException, ItemNotAvailableException {
        if (borrowedBooks.size() >= BORROW_LIMIT) {
            throw new BorrowLimitExceededException(BORROW_LIMIT);
        }
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Member ID: " + memID + ", Name: " + getName() + ", Email: " + email +
                ", Books Borrowed: " + borrowedBooks.size();
    }
}

// Constants.java
public class Constants {
    public static final int BORROW_LIMIT = 3;
    public static final String MEMBER_ID_PREFIX = "MEM";
}
