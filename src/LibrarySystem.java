import java.util.ArrayList;
import java.util.List;

/**
 * @param ~ books - List of all books in System.
 * @param ~ members - List of all members in System.
 * @param ~ memberIDcount - Member ID count which increases as users join system.
 * @param ~ borrowLimit - Maximum Limit a user can borrow at once.
 */

public class LibrarySystem {
    private List<Book> books;
    private List<Member> members;
    private int memberIdcount = 1;
    final private int borrowLimit = 3;

    /**
     * @Method ~ LibrarySystem - Starts brand-new system and initializes the default books that will be inside library.
     */
    public LibrarySystem() throws LibraryException {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();

        if (books.isEmpty()) {
            initializeBooks();
        }
    }
    /**
     * @Method ~ initializeBooks - adds books and first user into the library system.
     */
    private void initializeBooks() throws LibraryException {
        registerBook("Red Rising", "Pierce Brown", "SCI-FI", 3, "0-345-53978-8");
        registerBook("Golden Son", "Pierce Brown", "SCI-FI", 3, "0-345-53981-8");
        registerBook("Morning Star", "Pierce Brown", "SCI-FI", 3, "0-345-53984-2");
        registerBook("The Way of Kings", "Brandon Sanderson", "Fantasy", 3, "978-0-7653-2635-5");
        registerBook("Words of Radiance", "Brandon Sanderson", "Fantasy", 3, "978-0-7653-2636-2");

        registerMember("John", "Doe", "jdoe@gmail.com");
        borrowBook("MEM1", "0-345-53978-8");
    }

    /**
     * @Method ~ registerBook - Adds book into library catalog
     */
    public void registerBook(String title, String author, String genre, int copies, String ISBN) {
        Book newBook = new Book(title, author, genre, copies, ISBN);
        books.add(newBook);
    }

    /**
     * @Method ~ findBook - Finds books within the library catalog.
     */
    public Book findBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    /**
     * @Method ~ registerMember - Creates a member account for user
     */
    public String registerMember(String firstName, String lastName, String email) {
        String memId = "MEM" + memberIdcount++;
        members.add(new Member(memId, firstName, lastName, email));
        return memId;
    }

    /**
     * @Method ~ findMember - Finds member within the list of members in the system.
     */
    public Member findMember(String memId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memId)) {
                return member;
            }
        }
        return null;
    }

    /**
     * @Method ~ getBorrowedBooks - Gathers all the borrowed books by a chosen user
     */
    public List<Book> getBorrowedBooks(String memId) throws MemberNotFoundException {
        Member member = findMember(memId);
        if (member == null) throw new MemberNotFoundException(memId);
        return member.getBorrowedBooks();
    }

    /**
     * @Method ~ borrowBook - Borrows book from system and gives it to user.
     */
    public void borrowBook(String memID, String ISBN) throws LibraryException {
        Member member = findMember(memID);
        Book book = findBook(ISBN);

        if (member == null) throw new MemberNotFoundException(memID);
        if (book == null) throw new BookNotFoundException(ISBN);

        if (getBorrowedBooks(memID).size() >= borrowLimit) {
            throw new BorrowLimitExceededException(borrowLimit);
        }
        else {
            member.borrowBook(book);
            book.decrementCopies(1);
        }
    }

    /**
     * @Method ~ returnBook - returns Book back to system and removes it from user
     */
    public void returnBook(String memId, String ISBN) throws LibraryException {
        Member member = findMember(memId);
        Book book = findBook(ISBN);

        if (member == null) throw new MemberNotFoundException(memId);
        if (book == null) throw new BookNotFoundException(ISBN);

        member.returnBook(book);
        book.incrementCopies(1);
    }

    /**
     * @Method ~ getAllBooks - Returns all books within library
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
    /**
     * @Method ~ getAllMembers - Returns all members within system
     */
    public List<Member> getAllMembers() {
        return new ArrayList<>(members);
    }
}
