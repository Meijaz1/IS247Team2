import java.util.ArrayList;
import java.util.List;

//Younoussa Daffe
//ydaffe1@umbc.edu
public class Member {
    private String memID;
    private String firstName;
    private String lastName;
    private String email;
    private List<Book> borrowedBooks;

    public Member(String memID, String firstName, String lastName, String email) {
        this.memID = memID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getMemberId() {
        return memID;
    }

    public String getName() {
        String fullName = firstName + " " + lastName;
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
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
