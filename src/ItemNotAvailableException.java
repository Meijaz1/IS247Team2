//Younoussa Daffe
//ydaffe1@umbc.edu

/**
 * @Exception - Warns user that chosen book is not available for checkout.
 */
public class ItemNotAvailableException extends LibraryException {
    public ItemNotAvailableException(String title) {
        super("'" + title + "' is not available for checkout");
    }
}