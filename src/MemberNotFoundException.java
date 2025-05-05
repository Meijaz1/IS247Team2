/**
 * @Exception -
 */
public class MemberNotFoundException extends LibraryException {
    public MemberNotFoundException(String title) {
        super("Member: '" + title + "' does not exist.");
    }
}