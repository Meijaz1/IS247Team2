import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private List<Book> books;
    private List<Member> members;
    private int memberIdcount = 1;

    public LibrarySystem() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        loadData();
    }

    public void addBook(String title, String author, String genre, int copies, String ISBN) {
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

    public void registerMember(String firstName, String lastName, String email) {
        String memId = "MEM" + memberIdcount++;
        members.add(new Member(memId, firstName, lastName, email));
    }

    public Member findMember(String memId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memId)) {
                return member;
            }
        }
        return null;
    }

    public List<Book> searchBooks(String searchTerm) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    book.getISBN().equalsIgnoreCase(searchTerm)) {
                results.add(book);
            }
        }
        return results;
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

    private void loadData() {

    }

    public void saveData() {

    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public List<Member> getAllMembers() {
        return new ArrayList<>(members);
    }
}
