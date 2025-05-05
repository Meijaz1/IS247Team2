/**
 * @Exception -
 */
public class BookNotFoundException extends LibraryException {
    public BookNotFoundException(String title) {
        super("Book: '" + title + "' does not exist.");
    }
}