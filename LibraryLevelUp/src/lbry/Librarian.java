package lbry;
import java.util.ArrayList;

class Librarian extends Person {

    private ArrayList<Books> catalog = new ArrayList<>();         // book list
    private ArrayList<Multimedia> multimedia = new ArrayList<>(); // multimedia list
    private ArrayList<Member> members = new ArrayList<>();        // members
    private ArrayList<BorrowRecord> records = new ArrayList<>();  // borrow records

    public Librarian(String id, String name) {
        super(id, name);

        // load initial data
        for (Books b : Books.getInitialBooks()) {
            catalog.add(b);
        }

        for (Multimedia m : Multimedia.getInitialMultimedia()) {
            multimedia.add(m);
        }
    }

    // OVERLOADING: add book
    public void addBook(String id, String title, String author) {
        catalog.add(new Books(id, title, author, "Unknown"));
        System.out.println("Book added: " + title);
    }

    public void addBook(String id, String title, String author, String genre) {
        catalog.add(new Books(id, title, author, genre));
        System.out.println("Book added: " + title + " (" + genre + ")");
    }

    // remove book
    public void removeBook(String id) {
        catalog.removeIf(b -> b.getItemId().equals(id));
        System.out.println("Book removed!");
    }

    // register member
    public void registerMember(Member m) {
        members.add(m);
        System.out.println("Member registered: " + m.getName());
    }

    // find item by title
    public LibraryItem findItemByTitle(String title) {
        for (Books b : catalog) {
            if (b.getTitle().equalsIgnoreCase(title)) return b;
        }
        for (Multimedia m : multimedia) {
            if (m.getTitle().equalsIgnoreCase(title)) return m;
        }
        return null;
    }

    // show all items
    public void showAllItems() {
    System.out.println("\n=== BOOKS ===");
    for (Books b : catalog) {
        System.out.println(b.getItemId() + " | " + b.getInfo());
    }

    System.out.println("\n=== MULTIMEDIA ===");
    for (Multimedia m : multimedia) {
        System.out.println(m.getItemId() + " | " + m.getInfo());
    }
}

    // record borrow
    public void recordBorrow(Member m, LibraryItem item) {
        records.add(new BorrowRecord("R" + (records.size()+1), m, item, "Today"));
    }

    // record return
    public void recordReturn(LibraryItem item) {
        for (BorrowRecord r : records) {
            if (r.getItem() == item && !r.isReturned()) {
                r.markReturned("Today");
                break;
            }
        }
    }

    // combine all items
    public ArrayList<LibraryItem> getAllItems() {
        ArrayList<LibraryItem> all = new ArrayList<>();
        all.addAll(catalog);
        all.addAll(multimedia);
        return all;
    }
}