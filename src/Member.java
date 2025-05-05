import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Younoussa Daffe
//ydaffe1@umbc.edu

/**
 * Member class that defines and initializes needed variables needed to create an account
 * includes methods to get info and add and remove books
 * @param ~ memID - user's member ID
 * @param ~ firstName - user's first name
 * @param ~ lastName - user's last name
 * @param ~ email - user's email
 * @param ~ borrowedBooks - All borrowed books by user
 */
public class Member {
    private String memID;
    private String firstName;
    private String lastName;
    private String email;
    private Queue<Book> borrowedBooks;
    private final int borrowLimit = 5;

    public Member(String memID, String firstName, String lastName, String email) {
        this.memID = memID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.borrowedBooks = new LinkedList<>();
    }

    /**
     * Method which returns user's membership ID
     * @return String
     */
    public String getMemberId() {
        return memID;
    }

    /**
     * Method which returns user's full name
     * @return String
     */
    public String getName() {
        String fullName = firstName + " " + lastName;
        return fullName;
    }

    /**
     * Method which returns user's email
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method which returns all the books the user has borrowed
     * @return List
     */
    public List<Book> getBorrowedBooks() {
        return (List<Book>) borrowedBooks;
    }

    /**
     * Method which adds book to borrowed books of the user.
     */
    public void checkOut(Book book) {
        borrowedBooks.add(book);
    }

    /**
     * Method which returns book to borrowed books of the user.
     */
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }


    public void borrowBook(Book book) throws BorrowLimitExceededException, ItemNotAvailableException {
        if (borrowedBooks.size() >= borrowLimit) {
            throw new BorrowLimitExceededException(borrowLimit);
        }
        checkOut(book);
    }

    public Book returnBook() throws NoBooksBorrowedException {
        if (borrowedBooks.isEmpty()) {
            throw new NoBooksBorrowedException();
        }
        Book book = borrowedBooks.poll();
        returnBook(book);
        return book;
    }

    /**
     * Method which returns relevant member info in an organized string
     * @return String
     */
    @Override
    public String toString() {
        return "Member ID: " + memID + ", Name: " + getName() + ", Email: " + email +
                ", Books Borrowed: " + borrowedBooks.size();
    }
}
