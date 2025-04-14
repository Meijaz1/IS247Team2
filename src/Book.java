//Younoussa Daffe
//ydaffe1@umbc.edu


/**
* @param ~ title - Title of the book
* @param ~ author - Author of the book
* @param ~ genre - Genre of the book
* @param ~ numberOfCopies - Number of copies of specific book
* @param ~ available copies - Number of copies avaiable of specific book
*/
public class Book {
    private String title;
    private String author;
    private String genre;
    private int numberOfCopies;
    private int availableCopies;

    public Book (String title, String author, String genre, int numberOfCopies, int availableCopies) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.numberOfCopies = numberOfCopies;
        this.availableCopies = availableCopies;
    }

    public boolean isAvailable() {
        if (availableCopies > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void incrementCopies(int amount) {
        this.numberOfCopies += amount;
        this.availableCopies += amount;
    }

    public void decrementCopies(int amount) {
        this.numberOfCopies -= amount;
        this.availableCopies -= amount;
    }
}
