package lbry;
class LibraryItem {
    protected String itemId;      // item ID
    protected String title;       // item title
    protected boolean available;  // availability status

    public LibraryItem(String itemId, String title) {
        this.itemId = itemId;
        this.title = title;
        this.available = true; // default available
    }

    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }

    // base info (will be overridden)
    public String getInfo() {
        return title;
    }

    @Override
    public String toString() {
        return getInfo();
    }
}