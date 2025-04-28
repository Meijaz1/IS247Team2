//Younoussa Daffe
//ydaffe1@umbc.edu

/**
 * @Exception - Warns user that they are attempting to exceed the borrow limit.
 */
public class BorrowLimitExceededException extends LibraryException {
    public BorrowLimitExceededException(int limit) {
        super("Maximum borrow limit (" + limit + ") exceeded");
    }
}