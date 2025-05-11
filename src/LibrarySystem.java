import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private List<Book> books;
    private List<Member> members;
    private int memberIdcount = 1;

    public LibrarySystem() throws LibraryException {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();

        if (books.isEmpty()) {
            initializeBooks();
        }
    }

    private void initializeBooks() throws LibraryException {
        registerBook("Red Rising", "Pierce Brown", "SCI-FI", 3, "0-345-53978-8");
        registerBook("Golden Son", "Pierce Brown", "SCI-FI", 3, "0-345-53981-8");
        registerBook("Morning Star", "Pierce Brown", "SCI-FI", 3, "0-345-53984-2");
        registerBook("The Way of Kings", "Brandon Sanderson", "Fantasy", 3, "978-0-7653-2635-5");
        registerBook("Words of Radiance", "Brandon Sanderson", "Fantasy", 3, "978-0-7653-2636-2");

        registerMember("John", "Doe", "jdoe@gmail.com");
        borrowBook("MEM1", "0-345-53978-8");
    }

    public void registerBook(String title, String author, String genre, int copies, String ISBN) {
        Book newBook = new Book(title, author, genre, copies, ISBN);
        books.add(newBook);
    }

    public Book findBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    public String registerMember(String firstName, String lastName, String email) {
        String memId = "MEM" + memberIdcount++;
        members.add(new Member(memId, firstName, lastName, email));
        return memId;
    }

    public Member findMember(String memId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memId)) {
                return member;
            }
        }
        return null;
    }

    public List<Book> getBorrowedBooks(String memId) throws MemberNotFoundException {
        Member member = findMember(memId);
        if (member == null) throw new MemberNotFoundException(memId);
        return member.getBorrowedBooks();
    }

    public void borrowBook(String memId, String ISBN) throws LibraryException {
        Member member = findMember(memId);
        Book book = findBook(ISBN);

        if (member == null) throw new MemberNotFoundException(memId);
        if (book == null) throw new BookNotFoundException(ISBN);

        member.borrowBook(book);
        book.decrementCopies(1);
    }

    public void returnBook(String memId, String ISBN) throws LibraryException {
        Member member = findMember(memId);
        Book book = findBook(ISBN);

        if (member == null) throw new MemberNotFoundException(memId);
        if (book == null) throw new BookNotFoundException(ISBN);

        member.returnBook(book);
        book.incrementCopies(1);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public List<Member> getAllMembers() {
        return new ArrayList<>(members);
    }
}
