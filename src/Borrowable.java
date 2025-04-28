//Younoussa Daffe
//ydaffe1@umbc.edu

public interface Borrowable {
    boolean isAvailable();
    void checkOut() throws ItemNotAvailableException;
    void returnItem();
}
