//Younoussa Daffe
//ydaffe1@umbc.edu
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
