package lbry;
class Books extends LibraryItem {
    private String author; // author name
    private String genre;  // book genre

    public Books(String id, String title, String author, String genre) {
        super(id, title); // call parent constructor
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() { return author; }
    public String getGenre() { return genre; }

    // OVERRIDING method
    @Override
    public String getInfo() {
        return title + " by " + author + " [" + genre + "]";
    }

    // initial data
    public static Books[] getInitialBooks() {
        return new Books[] {
            new Books("B1", "I Want To End This Love Game", "Yuki Domoto", "Romance"),
            new Books("B2", "You and I Are Polar Opposite", "Kocha Agasawa", "Romance")
        };
    }
}