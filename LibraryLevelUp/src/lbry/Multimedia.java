package lbry;
class Multimedia extends LibraryItem {
    private String type;    // type (movie, music, etc.)
    private int duration;   // duration in minutes

    public Multimedia(String id, String title, String type, int duration) {
        super(id, title);
        this.type = type;
        this.duration = duration;
    }

    public String getType() { return type; }
    public int getDuration() { return duration; }

    // OVERRIDING method
    @Override
    public String getInfo() {
        return title + " (" + type + ", " + duration + " mins)";
    }

    // initial data
    public static Multimedia[] getInitialMultimedia() {
        return new Multimedia[] {
            new Multimedia("M1", "The Amazing Digital Circus", "Movie", 120),
            new Multimedia("M2", "Ghost In The Cell", "Movie", 105)
        };
    }
}