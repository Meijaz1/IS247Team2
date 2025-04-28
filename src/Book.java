//Younoussa Daffe
//ydaffe1@umbc.edu


/**
* @param ~ title - Title of the book
* @param ~ author - Author of the book
* @param ~ genre - Genre of the book
* @param ~ numberOfCopies - Number of copies of specific book
* @param ~ available copies - Number of copies avaiable of specific book
 * @param ~ ISBN # of book
*/
    public class Book {
        private String title;
        private String author;
        private String genre;
        private int numberOfCopies;
        private int availableCopies;
        private String ISBN;

    /**
     * @Method ~ Book -
     */
    public Book (String title, String author, String genre, int numberOfCopies, String ISBN) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.numberOfCopies = numberOfCopies;
        this.availableCopies = availableCopies;
        this.ISBN = ISBN;
    }
    /**
     * @Method ~ isAvailable -  to see if copy of book is available
     */
    public boolean isAvailable() {
        if (availableCopies > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public String getISBN() { return ISBN; }

    /**
     * @Method ~ incrementCopies - to increase number of copies
     */
    public void incrementCopies(int amount) {
        this.numberOfCopies += amount;
        this.availableCopies += amount;
    }
    /**
     * @Method ~ decrementCopies - to decrease number of copies
     */
    public void decrementCopies(int amount) {
        this.numberOfCopies -= amount;
        this.availableCopies -= amount;
    }
}
