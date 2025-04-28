//Younoussa Daffe
//ydaffe1@umbc.edu

/**
 * @Exception - Warns user that they have no borrowed books.
 */
public class NoBooksBorrowedException extends LibraryException {
    public NoBooksBorrowedException() {
        super("No books currently borrowed");
    }
}