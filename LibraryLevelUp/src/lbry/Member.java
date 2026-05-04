package lbry;
class Member extends Person {
    private LibraryItem[] borrowedItems; // list of borrowed items
    private int borrowCount;             // total borrowed

    public Member(String id, String name) {
        super(id, name);
        borrowedItems = new LibraryItem[10]; // max 10 items
        borrowCount = 0;
    }

    // borrow item
    public void borrowItem(LibraryItem item) {
        borrowedItems[borrowCount++] = item;
        item.available = false; // mark unavailable
    }

    // return item
    public void returnItem(LibraryItem item) {
        item.available = true;
    }

    // OVERLOADING: show all items
    public void searchItem(LibraryItem[] catalog, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(catalog[i].getInfo());
        }
    }

    // OVERLOADING: search by keyword
    public void searchItem(LibraryItem[] catalog, int size, String keyword) {
        for (int i = 0; i < size; i++) {
            if (catalog[i].getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(catalog[i].getInfo());
            }
        }
    }

    // OVERRIDING
    @Override
    public String getInfo() {
        return super.getInfo() + " | Borrowed: " + borrowCount;
    }
}